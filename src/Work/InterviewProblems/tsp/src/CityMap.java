package InterviewProblems.tsp.src;

import java.util.*;

/**
 * A map describes how cities are arranged: which cities are neighbors and the mileage between neighboring cities.
 */
public final class CityMap {

    private final Map<City, Map<City, Integer>> _map = new HashMap<City, Map<City, Integer>>();

    /**
     * Gets the one-way mileage from one city to another.
     * Note that there is no guarantee of symmetry (as there might be a shorter pay route going in one direction, for example)
     *
     * @param source the starting city
     * @param dest   the destination city
     * @return the mileage between the cities according to this map
     * @throws NullPointerException if <code>dest</code> is not a neighbor of <code>source</code>
     */
    public int getMileage(City source, City dest) {
        return _map.get(source).get(dest);
    }

    /**
     * Returns the cities that neighbor the given city.
     * A city is not considered a neighbor of itself.
     * If city A is a neighbor of city B, then city B is also a neighbor of city A.
     *
     * @param source the source city
     * @return a set of cities that are the neighbors of source
     * @throws NullPointerException if <code>source</code> has no neighbors
     */
    public Set<City> getNeighborCities(City source) {
        return Collections.unmodifiableSet(_map.get(source).keySet());
    }

    /**
     * Sets the mileage in both directions between two cities to the same value.
     *
     * @param city1    a city
     * @param city2    a neighboring city
     * @param mileage  the mileage between the given cities
     */
    public void setMileages(City city1, City city2, int mileage) {
        setMileages(city1, city2, mileage, mileage);
    }

    /**
     * Sets the mileage in both directions between two cities to potentially different values.
     *
     * @param city1        a city
     * @param city2        a neighboring city
     * @param mileage1to2  the distance from city1 to city2
     * @param mileage2to1  the distance from city2 to city1
     */
    public void setMileages(City city1, City city2, int mileage1to2, int mileage2to1) {
        if (!_map.containsKey(city1)) {
            _map.put(city1, new HashMap<City, Integer>());
        }
        if (!_map.containsKey(city2)) {
            _map.put(city2, new HashMap<City, Integer>());
        }
        _map.get(city1).put(city2, mileage1to2);
        _map.get(city2).put(city1, mileage2to1);
    }
}
