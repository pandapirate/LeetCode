package InterviewProblems.tsp.src;

import java.util.*;

/**
 * A salesperson, represented simply as the list of cities he will visit this month.
 */
public class Salesperson {

    private final List<CityVisit> _route;

    public Salesperson(CityVisit... route) {
        this(Arrays.asList(route));
    }

    public Salesperson(Collection<CityVisit> route) {
        List<CityVisit> sortedRoute = new ArrayList<CityVisit>(route);
        Collections.sort(sortedRoute, CityVisit.COMPARE_BY_DAY);
        _route = Collections.unmodifiableList(sortedRoute);
    }

    /**
     * The list of cities visited by this salesperson. Guaranteed to be sorted in ascending order by day.
     */
    public List<CityVisit> getRoute() {
        return _route;
    }

}
