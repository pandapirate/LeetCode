package InterviewProblems.tsp.src;

/**
 * A city.
 */
public final class City {

    private final String _name;

    public City(String name) {
        if (name == null) {
            throw new NullPointerException();
        }
        _name = name;
    }

    public String getName() {
        return _name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        City city = (City) o;
        return _name.equals(city._name);
    }

    @Override
    public int hashCode() {
        return _name.hashCode();
    }

    @Override
    public String toString() {
        return _name;
    }
}
