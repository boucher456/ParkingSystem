public class Vehicle {
    private final VechileType type;
    private final String registrationNumber;
    private final String color;
    private final long entryTime;

    public Vehicle(VechileType type, String registrationNumber, String color) {
        this.type = type;
        this.registrationNumber = registrationNumber;
        this.color = color;
        this.entryTime = System.currentTimeMillis();
    }

    public VechileType getType() { return type; }
    public String getRegistrationNumber() { return registrationNumber; }
    public String getColor() { return color; }
    public long getEntryTime() { return entryTime; }
}