import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLotFloor {
    private List<ParkingSlot> parkingSlotList;
    private int floorId;
    private Map<Integer,ParkingSlot> occupiedSlotsMap;

    ParkingLotFloor(int floor, int numOfSlotsPerFloor){
        this.floorId = floor;
        this.occupiedSlotsMap = new HashMap<>();
        this.parkingSlotList = new ArrayList<>();
        for(int i=0;i<numOfSlotsPerFloor;i++){
            if(i == 0) {
                parkingSlotList.add(new ParkingSlot(VehicleType.Truck, floor));
            }
            else if(i == 1 || i == 2){
                parkingSlotList.add(new ParkingSlot(VehicleType.Bike, floor));
            }
            else{
                parkingSlotList.add(new ParkingSlot(VehicleType.Car, floor));
            }
        }
    }

    public List<ParkingSlot> getParkingSlotList() {
        return parkingSlotList;
    }

    public Map<Integer,ParkingSlot> getOccupiedSlotsMap() {
        return occupiedSlotsMap;
    }
}
