package InterviewProblems.tsp.test;

import InterviewProblems.tsp.src.*;
import junit.framework.TestCase;

import java.util.*;

/**
 * Tests for the solver.
 */
public class SolverTest extends TestCase {

    // These cities and distances are based on "California Driving Distances Map.jpg",
    // a free-for-all-uses map resource courtesy of the California tourism board.
    public static final City LOS_ANGELES     = new City("Los Angeles");
    public static final City SANTA_BARBARA   = new City("Santa Barbara");
    public static final City SAN_LUIS_OBISPO = new City("San Luis Obispo");
    public static final City MONTEREY        = new City("Monterey");
    public static final City BAKERSFIELD     = new City("Bakersfield");
    public static final City FRESNO          = new City("Fresno");
    public static final City STOCKTON        = new City("Stockton");
    public static final City SAN_FRANCISCO   = new City("San Francisco");

    protected final CityMap exampleCityMap = new CityMap();

    @Override
    public void setUp() {
        exampleCityMap.setMileages(LOS_ANGELES,     SANTA_BARBARA,   96);
        exampleCityMap.setMileages(LOS_ANGELES,     BAKERSFIELD,     101);
        exampleCityMap.setMileages(SANTA_BARBARA,   SAN_LUIS_OBISPO, 106);
        exampleCityMap.setMileages(SAN_LUIS_OBISPO, MONTEREY,        132);
        exampleCityMap.setMileages(SAN_LUIS_OBISPO, BAKERSFIELD,     114);
        exampleCityMap.setMileages(SAN_LUIS_OBISPO, FRESNO,          130);
        exampleCityMap.setMileages(MONTEREY,        FRESNO,          167);
        exampleCityMap.setMileages(MONTEREY,        SAN_FRANCISCO,   123);
        exampleCityMap.setMileages(BAKERSFIELD,     FRESNO,          100);
        exampleCityMap.setMileages(FRESNO,          STOCKTON,        126);
        exampleCityMap.setMileages(STOCKTON,        SAN_FRANCISCO,   70);
    }

    public void testVisitSameCitySameDay() {
        Salesperson salesperson1 = createSalesperson(LOS_ANGELES,   BAKERSFIELD, SANTA_BARBARA);
        Salesperson salesperson2 = createSalesperson(SAN_FRANCISCO, BAKERSFIELD, STOCKTON);
        Solution bestSolution = new Solver().findBestSolution(salesperson1, salesperson2, exampleCityMap);
        checkSolution(bestSolution, 2, BAKERSFIELD, 0);
    }

    public void testVisitNeighboringCities() {
        Salesperson salesperson1 = createSalesperson(LOS_ANGELES,   BAKERSFIELD, SAN_LUIS_OBISPO, SANTA_BARBARA);
        Salesperson salesperson2 = createSalesperson(SAN_FRANCISCO, STOCKTON,    FRESNO,          MONTEREY);
        Solution bestSolution = new Solver().findBestSolution(salesperson1, salesperson2, exampleCityMap);
        checkSolution(bestSolution, 3, SAN_LUIS_OBISPO, FRESNO, 260);
    }

    public void testVisitCitiesThatShareACommonNeighbor() {
        // San Francisco and Fresno both have Stockton and Monterey as a neighbors, but Stockton is closer.
        Salesperson salesperson1 = createSalesperson(null,     LOS_ANGELES, BAKERSFIELD,   STOCKTON,      SAN_FRANCISCO);
        Salesperson salesperson2 = createSalesperson(STOCKTON, null,        SAN_FRANCISCO, SANTA_BARBARA, FRESNO);
        Solution bestSolution = new Solver().findBestSolution(salesperson1, salesperson2, exampleCityMap);
        checkSolution(bestSolution, 5, STOCKTON, 392);
    }

    protected static Salesperson createSalesperson(City... cities) {
        List<CityVisit> visits = new ArrayList<CityVisit>();
        int day = 1;
        for (City city : cities) {
            if (city != null) {
                // Null indicates a day on which the salesperson is traveling, and not in any particular city.
                visits.add(new CityVisit(city, day));
            }
            day++;
        }
        return new Salesperson(visits);
    }

    protected static void checkSolution(Solution solution, int day, City city, int mileage) {
        if (solution == null
                || day != solution.getDay()
                || !city.equals(solution.getCity())
                || mileage != solution.getMileage()) {
            fail("expected " + solutionToString(day, city, mileage) + " but got " + solutionToString(solution));
        }
    }

    protected static void checkSolution(Solution solution, int day, City city1, City city2, int mileage) {
        if (solution == null
                || day != solution.getDay()
                || (!city1.equals(solution.getCity()) && !city2.equals(solution.getCity()))
                || mileage != solution.getMileage()) {
            fail("expected " + solutionToString(day, city1, city2, mileage) + " but got " + solutionToString(solution));
        }
    }

    protected static void checkNoSolutionFound(Solution solution) {
        if (solution != null) {
            fail("expected null but got " + solutionToString(solution));
        }
    }

    private static String solutionToString(Solution solution) {
        if (solution == null) {
            return "null";
        } else {
            return solutionToString(solution.getDay(), solution.getCity(), solution.getMileage());
        }
    }

    private static String solutionToString(int day, City city, int mileage) {
        return "<day " + day + " in " + city + " with " + mileage + " miles>";
    }

    private static String solutionToString(int day, City city1, City city2, int mileage) {
        return "<day " + day + " in " + city1 + " or " + city2 + " with " + mileage + " miles>";
    }

}
