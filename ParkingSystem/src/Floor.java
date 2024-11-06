import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Floor {
	 private final int floorNumber;
	    private final Map<VechileType, List<VehicleSpace>> vehicleSpaces;

	    public Floor(int floorNumber, Map<VechileType, Integer> capacityPerType) {
	        this.floorNumber = floorNumber;
	        this.vehicleSpaces = new HashMap<>();

	        for (VechileType type : capacityPerType.keySet()) {
	            List<VehicleSpace> spaces = new ArrayList<>();
	            for (int i = 1; i <= capacityPerType.get(type); i++) {
	                spaces.add(new VehicleSpace(i));
	            }
	            vehicleSpaces.put(type, spaces);
	        }
	    }

	    public boolean hasAvailableSpace(VechileType type) {
	        return vehicleSpaces.containsKey(type) &&
	               vehicleSpaces.get(type).stream().anyMatch(VehicleSpace::isAvailable);
	    }

	    public VehicleSpace parkVehicle(Vehicle vehicle) {
	        List<VehicleSpace> spaces = vehicleSpaces.get(vehicle.getType());
	        for (VehicleSpace space : spaces) {
	            if (space.isAvailable()) {
	                space.parkVehicle(vehicle);
	                return space;
	            }
	        }
	        return null;
	    }

	    public Vehicle removeVehicle(String registrationNumber) {
	        for (List<VehicleSpace> spaces : vehicleSpaces.values()) {
	            for (VehicleSpace space : spaces) {
	                if (!space.isAvailable() && space.getVehicle().getRegistrationNumber().equals(registrationNumber)) {
	                    return space.removeVehicle();
	                }
	            }
	        }
	        return null;
	    }

	    public void displayStatus() {
	        System.out.println("Floor " + floorNumber);
	        for (VechileType type : vehicleSpaces.keySet()) {
	            long occupied = vehicleSpaces.get(type).stream().filter(space -> !space.isAvailable()).count();
	            long available = vehicleSpaces.get(type).size() - occupied;
	            System.out.println("Type: " + type + ", Occupied: " + occupied + ", Available: " + available);
	        }
	    }
}
