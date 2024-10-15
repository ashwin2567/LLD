import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ParkingLotManager {
    List<ParkingLot> parkingLotList = new ArrayList<>();
    ParkingLot parkingLot;
    TicketManager ticketManager = new TicketManager();

    void createParkingLot(String parkingLotId, int numOfFloor, int numOfSlotsPerFloor){
        parkingLot = new ParkingLot(parkingLotId, numOfFloor, numOfSlotsPerFloor);
        parkingLotList.add(parkingLot);
        System.out.println("Created parking lot with " + numOfFloor  + " floors and " + numOfSlotsPerFloor + " slots per floor");
    }

    void parkVehicle(VehicleType vehicleType, String regNum, String color){
        int numOfFloor = parkingLot.getNumOfFloor();
        boolean flag = false;
        for(int i=0;i<numOfFloor;i++) {
            ParkingLotFloor parkingLotFloor = parkingLot.getParkingLotFloorList().get(i);
            List<ParkingSlot> parkingSlotList = parkingLotFloor.getParkingSlotList();
            for(int j=0;j<parkingSlotList.size();j++){
                ParkingSlot parkingSlot = parkingSlotList.get(j);
                if(!parkingSlot.isOccupied() && parkingSlot.getVehicleType() == vehicleType){
                    parkingSlot.setOccupied(true);
                    parkingLotFloor.getOccupiedSlotsMap().put(j, parkingSlot);
                    Ticket ticket = new Ticket(parkingLot.getParkingLotId(), i, j, new Vehicle(vehicleType, regNum, color));
                    String ticketId = ticket.getTicketId();
                    ticketManager.getTicketMap().put(ticketId, ticket);
                    System.out.println("Parked Vehicle. Ticket Id :" + ticketId);
                    flag = true;
                    break;
                }
            }
            if(flag){
                break;
            }
        }
        if(!flag) {
            System.out.println("All slots full, vehicle cannot be parked");
        }
    }

    void unparkVehicle(String ticketId){
        try {
            Ticket ticket = ticketManager.getTicketMap().get(ticketId);
            int floor = ticket.getFloorNumber();
            int slot = ticket.getSlotNumber();
            Vehicle vehicle = ticket.getVehicle();
            ParkingLotFloor parkingLotFloor = parkingLot.getParkingLotFloorList().get(floor);
            parkingLotFloor.getParkingSlotList().get(slot).setOccupied(false);
            parkingLotFloor.getOccupiedSlotsMap().remove(slot);
            ticketManager.getTicketMap().remove(ticketId);
            System.out.println("Unparked " + vehicle.getType()+" with regNum " + vehicle.getRegNumber() + " and color " + vehicle.getColor() + " from floor " + String.valueOf(floor+1) + " and slot " + String.valueOf(slot+1));
        }
        catch (Exception e){
            System.out.println("Invalid Ticket Id");
        }
    }

    void display(String displayType, VehicleType vehicleType){
        int numOfFloor = parkingLot.getNumOfFloor();
        if(Objects.equals(displayType, "free_count")){
            for(int i=0;i<numOfFloor;i++) {
                int count = 0;
                List<ParkingSlot> parkingSlotList = parkingLot.getParkingLotFloorList().get(i).getParkingSlotList();
                System.out.print("No. of free slots for " + vehicleType + " on floor " + String.valueOf(i+1) + ":");
                for(int j=0;j<parkingSlotList.size();j++){
                    ParkingSlot parkingSlot = parkingSlotList.get(j);
                    if(!parkingSlot.isOccupied() && Objects.equals(parkingSlot.getVehicleType(),vehicleType))
                        count++;
                }
                System.out.print(count);
                System.out.println();
            }
        }
        else if(Objects.equals(displayType, "free_slots")){
            for(int i=0;i<numOfFloor;i++) {
                List<ParkingSlot> parkingSlotList = parkingLot.getParkingLotFloorList().get(i).getParkingSlotList();
                System.out.print("Free slots for " + vehicleType + " on floor " + String.valueOf(i+1) + ":");
                for(int j=0;j<parkingSlotList.size();j++){
                    ParkingSlot parkingSlot = parkingSlotList.get(j);
                    if(!parkingSlot.isOccupied() && Objects.equals(parkingSlot.getVehicleType(),vehicleType))
                        System.out.print(String.valueOf(j + 1) + " ");
                }
                System.out.println();
            }
        }
        else if(Objects.equals(displayType, "occupied_slots")){
            for(int i=0;i<numOfFloor;i++) {
                Map<Integer, ParkingSlot> parkingSlotMap = parkingLot.getParkingLotFloorList().get(i).getOccupiedSlotsMap();
                System.out.print("Occupied slots for " + vehicleType + " on floor " + String.valueOf(i+1) + ":");
                for(Map.Entry<Integer, ParkingSlot> entry : parkingSlotMap.entrySet()){
                    if(entry.getValue().getVehicleType() == vehicleType){
                        System.out.print(String.valueOf(entry.getKey() + 1) + " ");
                    }
                }
                System.out.println();
            }
        }
    }
}
