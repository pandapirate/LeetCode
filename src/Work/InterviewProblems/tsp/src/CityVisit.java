package InterviewProblems.tsp.src;

import InterviewProblems.tsp.src.City;

import java.util.Comparator;

/**
 * A city visited by a salesperson.
 */
public final class CityVisit {

    private final int _day;
    private final City _city;

    /**
     * Constructs a visit.
     *
     * @param day  the day on which to visit the city
     * @param city the city to visit (must not be null)
     */
    public CityVisit(City city, int day) {
        if (city == null) {
            throw new NullPointerException();
        }
        _day = day;
        _city = city;
    }

    public int getDay() {
        return _day;
    }

    public City getCity() {
        return _city;
    }

    public static final Comparator<CityVisit> COMPARE_BY_DAY =
            new Comparator<CityVisit>() {
                public int compare(CityVisit visit1, CityVisit visit2) {
                    return Integer.compare(visit1.getDay(), visit2.getDay());
                }
            };

    @Override
    public String toString() {
        return _city + " on day " + _day;
    }
}
