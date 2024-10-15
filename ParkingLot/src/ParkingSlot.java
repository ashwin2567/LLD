public class ParkingSlot {
    private VehicleType vehicleType;
    private int floor;
    private boolean isOccupied;

    public ParkingSlot(VehicleType vehicleType, int floor) {
        this.vehicleType = vehicleType;
        this.floor = floor;
        this.isOccupied = false;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }
}
