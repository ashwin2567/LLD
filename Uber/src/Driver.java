public class Driver {
    String name;
    RATING rating;

    public Driver(String name, RATING rating) {
        this.name = name;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public RATING getRating() {
        return rating;
    }
}
