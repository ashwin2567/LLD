public class Ticket {
    private String ticketId;
    private Vehicle vehicle;
    private int floorNumber;
    private int slotNumber;
    Ticket(String parkingLotId, int floorNumber, int slotNumber, Vehicle vehicle){
        this.vehicle = vehicle;
        this.floorNumber = floorNumber;
        this.slotNumber = slotNumber;
        this.ticketId  = parkingLotId.concat("_").concat(String.valueOf(floorNumber+1)).concat("_").concat(String.valueOf(slotNumber+1));
    }

    public String getTicketId() {
        return ticketId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public int getSlotNumber() {
        return slotNumber;
    }
}
