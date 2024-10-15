public class Trip {
    Rider rider;
    Driver driver;
    Location srcLoc;
    Location desLoc;
    TRIP_STATUS tripStatus;
    double price;
    PricingStrategy pricingStrategy;
    DriverMatchingStrategy driverMatchingStrategy;
    int tripId;

    public Trip(Driver driver, Rider rider, Location srcLoc, Location desLoc, double price, PricingStrategy pricingStrategy, DriverMatchingStrategy driverMatchingStrategy) {
        this.driver = driver;
        this.rider = rider;
        this.srcLoc = srcLoc;
        this.desLoc = desLoc;
        this.price = price;
        this.pricingStrategy = pricingStrategy;
        this.driverMatchingStrategy = driverMatchingStrategy;

        this.tripStatus = TRIP_STATUS.DRIVER_ON_THE_WAY;
        this.tripId = Utility.nextTripId++;
    }

    int getTripId() {
        return tripId;
    }

    void displayTripDetails() {
        System.out.print("Trip Id " + tripId + "  Rider-" + rider.getName() + " (" + rider.getRating() + ")");
        System.out.println("Price " + price + "  Driver-" + driver.getName() + " (" + driver.getRating() + ")");
    }
}
