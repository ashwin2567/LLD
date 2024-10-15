public class LeastTimeBasedDriverMatchingStrategy implements DriverMatchingStrategy{
    @Override
    public Driver matchDriver(TripMetaData tripMetaData) {
        DriverManager driverManager = DriverManager.getDriverManager();
        if(driverManager.getDriverMap().isEmpty()){
            System.out.println("No Drivers available.");
        };
        System.out.println("Using least time based strategy for driver");
        Driver driver = driverManager.getDriverMap().values().iterator().next();
        tripMetaData.setDriverRating(driver.getRating());
        System.out.println("Setting " + driver.getName() + " as driver0.");
        return driver;
    }
}
