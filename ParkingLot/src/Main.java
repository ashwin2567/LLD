public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        ParkingLotManager parkingLotManager = new ParkingLotManager();
        parkingLotManager.createParkingLot("PR1234",2,6);
        parkingLotManager.display("free_count", VehicleType.Car);
        parkingLotManager.display("free_count", VehicleType.Bike);
        parkingLotManager.display("free_count", VehicleType.Truck);
        parkingLotManager.display("free_slots", VehicleType.Car);
        parkingLotManager.display("free_slots", VehicleType.Bike);
        parkingLotManager.display("free_slots", VehicleType.Truck);
        parkingLotManager.display("occupied_slots", VehicleType.Car);
        parkingLotManager.display("occupied_slots", VehicleType.Bike);
        parkingLotManager.display("occupied_slots", VehicleType.Truck);
        parkingLotManager.parkVehicle(VehicleType.Car, "KA-01-DB-1234","black");
        parkingLotManager.parkVehicle(VehicleType.Car, "KA-02-CB-1334","red");
        parkingLotManager.parkVehicle(VehicleType.Car, "KA-01-DB-1133","black");
        parkingLotManager.parkVehicle(VehicleType.Car, "KA-05-HJ-8432","white");
        parkingLotManager.parkVehicle(VehicleType.Car, "WB-45-HO-9032","white");
        parkingLotManager.parkVehicle(VehicleType.Car, "KA-01-DF-8230","black");
        parkingLotManager.parkVehicle(VehicleType.Car, "KA-21-HS-2347","red");
        parkingLotManager.display("free_count", VehicleType.Car);
        parkingLotManager.display("free_count", VehicleType.Bike);
        parkingLotManager.display("free_count", VehicleType.Truck);
        parkingLotManager.unparkVehicle("PR1234_2_5");
        parkingLotManager.unparkVehicle("PR1234_2_5");
        parkingLotManager.unparkVehicle("PR1234_2_7");
        parkingLotManager.display("free_count", VehicleType.Car);
        parkingLotManager.display("free_count", VehicleType.Bike);
        parkingLotManager.display("free_count", VehicleType.Truck);
        parkingLotManager.display("free_slots", VehicleType.Car);
        parkingLotManager.display("free_slots", VehicleType.Bike);
        parkingLotManager.display("free_slots", VehicleType.Truck);
        parkingLotManager.display("occupied_slots", VehicleType.Car);
        parkingLotManager.display("occupied_slots", VehicleType.Bike);
        parkingLotManager.display("occupied_slots", VehicleType.Truck);
        parkingLotManager.parkVehicle(VehicleType.Bike, "KA-01-DB-1541","black");
        parkingLotManager.parkVehicle(VehicleType.Truck, "KA-32-SJ-5389","orange");
        parkingLotManager.parkVehicle(VehicleType.Truck, "KL-54-DN-4582","green");
        parkingLotManager.parkVehicle(VehicleType.Truck, "KL-12-HF-4542","green");
        parkingLotManager.display("free_count", VehicleType.Car);
        parkingLotManager.display("free_count", VehicleType.Bike);
        parkingLotManager.display("free_count", VehicleType.Truck);
        parkingLotManager.display("free_slots", VehicleType.Car);
        parkingLotManager.display("free_slots", VehicleType.Bike);
        parkingLotManager.display("free_slots", VehicleType.Truck);
        parkingLotManager.display("occupied_slots", VehicleType.Car);
        parkingLotManager.display("occupied_slots", VehicleType.Bike);
        parkingLotManager.display("occupied_slots", VehicleType.Truck);


    }
}