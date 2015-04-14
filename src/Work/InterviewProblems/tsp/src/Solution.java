package InterviewProblems.tsp.src;

/**
 * Characterizes the best day to meet, the city to meet in, and the round-trip travel total.
 */
public interface Solution {
    /**
     * @return the total round trip mileage for the two salespeople
     */
    public int getMileage();

    /**
     * @return the city to meet in (must not be null)
     */
    public City getCity();

    /**
     * @return the day on which the salespeople should meet
     */
    public int getDay();
}
