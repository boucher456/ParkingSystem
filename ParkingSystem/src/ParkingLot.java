import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class ParkingLot {
    private final List<Floor> floors;
    private CostStrategy costStrategy;

    public ParkingLot(int numberOfFloors, Map<VechileType, Integer> capacityPerType) {
        floors = new ArrayList<>();
        for (int i = 0; i < numberOfFloors; i++) {
            floors.add(new Floor(i + 1, capacityPerType));
        }
    }

    public void setCostStrategy(CostStrategy strategy) {
        this.costStrategy = strategy;
    }

    public VehicleSpace addVehicle(Vehicle vehicle) throws Exception {
        for (Floor floor : floors) {
            if (floor.hasAvailableSpace(vehicle.getType())) {
                return floor.parkVehicle(vehicle);
            }
        }
        throw new Exception("Parking lot is full for vehicle type: " + vehicle.getType());
    }

    public Vehicle removeVehicle(String registrationNumber) {
        for (Floor floor : floors) {
            Vehicle removed = floor.removeVehicle(registrationNumber);
            if (removed != null) return removed;
        }
        return null;
    }

    public void displayStatus() {
        for (Floor floor : floors) {
            floor.displayStatus();
        }
    }
}