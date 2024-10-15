import java.util.Map;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        Rider keertiRider = new Rider("Keerti", RATING.FIVE_STARS);
        Rider ashwinRider = new Rider("Ashwin", RATING.THREE_STARS);
        Rider pavanaRider = new Rider("Pavana", RATING.TWO_STARS);
        RiderManager riderManager = RiderManager.getRiderManager();
        riderManager.addRider("Keerti", keertiRider);
        riderManager.addRider("Ashwin", ashwinRider);
        riderManager.addRider("Pavana", pavanaRider);

        Driver kinjaldriver = new Driver("Kinjal", RATING.THREE_STARS);
        Driver ankitaDriver = new Driver("Ankita", RATING.FIVE_STARS);
        DriverManager driverManager = DriverManager.getDriverManager();
        driverManager.addDriver("Kinjal", kinjaldriver);
        driverManager.addDriver("Ankita", ankitaDriver);

        TripManager tripManager = TripManager.getTripManager();
        System.out.println("Creating trip for Ashwin from location(1,1)  to (2,2)");
        tripManager.createTrip(ashwinRider, new Location(1,1), new Location(2,2));

        System.out.println("Creating trip for Keerti from location(2,1)  to (2,2)");
        tripManager.createTrip(keertiRider, new Location(2,1), new Location(2,2));

        System.out.println("Creating trip for Pavana from location(5,1)  to (2,2)");
        tripManager.createTrip(pavanaRider, new Location(5,1), new Location(2,2));

        System.out.println("Creating trip for Keerti from location(1,1)  to (2,2)");
        tripManager.createTrip(keertiRider, new Location(1,1), new Location(2,2));


        Map<Integer, Trip> tripMap = tripManager.getTripMap();
        for(Map.Entry<Integer, Trip> entry : tripMap.entrySet()){
            entry.getValue().displayTripDetails();
        }
        System.out.println("Over");

    }
}