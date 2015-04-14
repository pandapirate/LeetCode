package InterviewProblems.tsp.test;

import InterviewProblems.tsp.src.Salesperson;
import InterviewProblems.tsp.src.Solution;
import InterviewProblems.tsp.src.Solver;

/**
 * Tests of interesting edge cases for the solver.
 */
public class AdvancedSolverTest extends SolverTest {

    public void testIntersectingRoutes() {
        Salesperson salespersonA = createSalesperson(LOS_ANGELES, SANTA_BARBARA, BAKERSFIELD, FRESNO,      STOCKTON);
        Salesperson salespersonB = createSalesperson(STOCKTON,    FRESNO,        BAKERSFIELD, LOS_ANGELES, SAN_FRANCISCO);
        Solution bestSolution = new Solver().findBestSolution(salespersonA, salespersonB, exampleCityMap);
        checkSolution(bestSolution, 3, BAKERSFIELD, 0);
    }

    public void testNonDirectlyNeighboringRoutes() {
        Salesperson salespersonA = createSalesperson(LOS_ANGELES,   SANTA_BARBARA);
        Salesperson salespersonB = createSalesperson(SAN_FRANCISCO, MONTEREY);
        Solution bestSolution = new Solver().findBestSolution(salespersonA, salespersonB, exampleCityMap);
        checkSolution(bestSolution, 2, SAN_LUIS_OBISPO, 476);
    }

    public void testDifferentRouteSizes() {
        Salesperson salespersonA = createSalesperson(LOS_ANGELES, SANTA_BARBARA, BAKERSFIELD);
        Salesperson salespersonB = createSalesperson(FRESNO,      BAKERSFIELD,   LOS_ANGELES, SAN_FRANCISCO);
        Solution bestSolution = new Solver().findBestSolution(salespersonA, salespersonB, exampleCityMap);
        checkSolution(bestSolution, 3, BAKERSFIELD, LOS_ANGELES, 202);
    }

    public void testShortRoute() {
        Salesperson salespersonA = createSalesperson(SAN_FRANCISCO);
        Salesperson salespersonB = createSalesperson(STOCKTON);
        Solution bestSolution = new Solver().findBestSolution(salespersonA, salespersonB, exampleCityMap);
        checkSolution(bestSolution, 1, SAN_FRANCISCO, STOCKTON, 140);
    }

    public void testRouteWithNoSolutionResultsInNullSolution() {
        Salesperson salespersonA = createSalesperson(SAN_FRANCISCO, STOCKTON);
        Salesperson salespersonB = createSalesperson(LOS_ANGELES,   SANTA_BARBARA);
        Solution bestSolution = new Solver().findBestSolution(salespersonA, salespersonB, exampleCityMap);
        checkNoSolutionFound(bestSolution);
    }

    public void testTieGoesToEarlierDay() {
        Salesperson salespersonA = createSalesperson(SAN_FRANCISCO, STOCKTON);
        Salesperson salespersonB = createSalesperson(STOCKTON,      SAN_FRANCISCO);
        Solution bestSolution = new Solver().findBestSolution(salespersonA, salespersonB, exampleCityMap);
        checkSolution(bestSolution, 1, SAN_FRANCISCO, STOCKTON, 140);
    }

    public void testRouteWithNoDaysInCommonResultsInNullSolution() {
        Salesperson salespersonA = createSalesperson(null, null, null, SAN_FRANCISCO, STOCKTON);
        Salesperson salespersonB = createSalesperson(STOCKTON, SAN_FRANCISCO);
        Solution bestSolution = new Solver().findBestSolution(salespersonA, salespersonB, exampleCityMap);
        checkNoSolutionFound(bestSolution);
    }

    public void testSharedNeighborBetterThanDirectNeighbor() {
        // Fresno and Bakersfield are neighbors, and also have San Luis Obispo as a shared neighbor.
        Salesperson salesperson1 = createSalesperson(FRESNO);
        Salesperson salesperson2 = createSalesperson(BAKERSFIELD);

        // Normally they would meet in either Fresno or Bakersfield, but if those cities became
        // further apart (perhaps due to a detour) then the shared neighbor would be preferred.
        exampleCityMap.setMileages(FRESNO, BAKERSFIELD, 300);

        Solution bestSolution = new Solver().findBestSolution(salesperson1, salesperson2, exampleCityMap);
        checkSolution(bestSolution, 1, SAN_LUIS_OBISPO, 488);
    }

    public void testAsymmetricMapWithDirectNeighbors() {
        // Fresno and Bakersfield are direct neighbors.
        Salesperson salesperson1 = createSalesperson(FRESNO);
        Salesperson salesperson2 = createSalesperson(BAKERSFIELD);

        // They're normally 100 miles apart, but let's say a detour makes one direction longer.
        exampleCityMap.setMileages(FRESNO, BAKERSFIELD, 100, 150);

        Solution bestSolution = new Solver().findBestSolution(salesperson1, salesperson2, exampleCityMap);
        checkSolution(bestSolution, 1, FRESNO, BAKERSFIELD, 250);
    }

    public void testAsymmetricMapWithSharedNeighbor() {
        // Fresno and Los Angeles have Bakersfield as a shared neighbor.
        Salesperson salesperson1 = createSalesperson(FRESNO);
        Salesperson salesperson2 = createSalesperson(LOS_ANGELES);

        // They're normally 100 and 75 miles apart, but let's say a detour makes one direction longer.
        exampleCityMap.setMileages(FRESNO,      BAKERSFIELD, 100, 150);
        exampleCityMap.setMileages(LOS_ANGELES, BAKERSFIELD, 75,  90);

        Solution bestSolution = new Solver().findBestSolution(salesperson1, salesperson2, exampleCityMap);
        checkSolution(bestSolution, 1, BAKERSFIELD, 415);
    }

}
