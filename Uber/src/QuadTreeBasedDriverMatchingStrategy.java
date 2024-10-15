public class QuadTreeBasedDriverMatchingStrategy implements DriverMatchingStrategy{
    @Override
    public Driver matchDriver(TripMetaData tripMetaData) {
        DriverManager driverManager = DriverManager.getDriverManager();
        if(driverManager.getDriverMap().isEmpty()){
            System.out.println("No Drivers available.");
        };
        System.out.println("Using Quad tree based strategy for driver");
        Driver driver = driverManager.getDriverMap().values().stream().toList().get(1);
        tripMetaData.setDriverRating(driver.getRating());
        System.out.println("Setting " + driver.getName() + " as driver1.");
        return driver;
    }
}
