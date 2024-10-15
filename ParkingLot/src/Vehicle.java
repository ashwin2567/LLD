public class Vehicle {
    VehicleType type;
    String regNumber;
    String color;

    public Vehicle(VehicleType type, String regNumber, String color) {
        this.type = type;
        this.regNumber = regNumber;
        this.color = color;
    }

    public VehicleType getType() {
        return type;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public String getColor() {
        return color;
    }
}
