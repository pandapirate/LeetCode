package InterviewProblems.tsp.src;

public class TSPSolution implements Solution {
    private int mileage;
    private City city;
    private int day;

    public TSPSolution(int m, City c, int d) {
        mileage = m;
        city = c;
        day = d;
    }

    @Override
    public int getMileage() {
        return mileage;
    }

    @Override
    public City getCity() {
        return city;
    }

    @Override
    public int getDay() {
        return day;
    }
}