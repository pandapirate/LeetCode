package InterviewProblems.tsp.src;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Solver for the Traveling Salesmen Problem.
 */
public class Solver {

    /**
     * @return the best solution, or null if there is no solution
     */
    public Solution findBestSolution(Salesperson salesperson1, Salesperson salesperson2, CityMap cityMap) {

        int min = -1;
        City minCity = null;
        int day = -1;

        List<CityVisit> route1 = salesperson1.getRoute();
        HashMap<Integer, City> sp2map = new HashMap<>();
        for (CityVisit cv : salesperson2.getRoute()) {
            sp2map.put(cv.getDay(), cv.getCity());
        }

        for (CityVisit cv : route1) {
            City c2 = sp2map.get(cv.getDay()); //get p2's location for this day
            if (c2 == null) { //p2 not available on this day
                continue;
            } else {
                if (c2 == cv.getCity()) { //p1 and p2 in the same city, this is the shortest distance
                    return new TSPSolution(0, c2, cv.getDay());
                } else {
                    Set<City> neighbors1 = cityMap.getNeighborCities(cv.getCity());
                    Set<City> neighbors2 = cityMap.getNeighborCities(c2);

                    if (neighbors1.contains(c2)) { //neighboring cities
                        int dist = cityMap.getMileage(cv.getCity(), c2) + cityMap.getMileage(c2, cv.getCity());
                        if (minCity == null || dist < min) {
                            min = dist;
                            minCity = cv.getCity();
                            day = cv.getDay();
                        }
                    }


                    Set<City> intersection = new HashSet<>();

                    for (City c : neighbors1) {
                        if (neighbors2.contains(c)) {
                            intersection.add(c);
                        }
                    }

                    if (neighbors1.size() > 0) {
                        for (City intersect : intersection) {
                            int dist = cityMap.getMileage(cv.getCity(), intersect) + cityMap.getMileage(intersect, cv.getCity());
                            dist += cityMap.getMileage(c2, intersect) + cityMap.getMileage(intersect, c2);
                            if (minCity == null || dist < min) {
                                min = dist;
                                minCity = intersect;
                                day = cv.getDay();
                            }
                        }
                    } else {
                        continue;
                    }
                }
            }
        }

        if (minCity == null)
            return null;

        return new TSPSolution(min, minCity, day);
    }


}
