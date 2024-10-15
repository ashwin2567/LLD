import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    String parkingLotId;
    int numOfFloor;
    int numOfSlotsPerFloor;
    List<ParkingLotFloor> parkingLotFloorList;

    public ParkingLot(String parkingLotId, int numOfFloor, int numOfSlotsPerFloor) {
        this.parkingLotId = parkingLotId;
        this.numOfFloor = numOfFloor;
        this.numOfSlotsPerFloor = numOfSlotsPerFloor;
        parkingLotFloorList = new ArrayList<>();

        for(int i=0;i<numOfFloor;i++){
            parkingLotFloorList.add(new ParkingLotFloor(i, numOfSlotsPerFloor));
        }
    }

    public int getNumOfFloor() {
        return numOfFloor;
    }

    public int getNumOfSlotsPerFloor() {
        return numOfSlotsPerFloor;
    }

    public List<ParkingLotFloor> getParkingLotFloorList() {
        return parkingLotFloorList;
    }

    public String getParkingLotId() {
        return parkingLotId;
    }
}
