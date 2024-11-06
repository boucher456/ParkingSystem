import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

class ParkingSystemDemo{
	
	public static void main(String[]arg) {
		  try {
	            // Initialize ParkingLot
	            Map<VechileType, Integer> capacity = new HashMap<>();
	            capacity.put(VechileType.CAR, 5);
	            capacity.put(VechileType.TRUCK, 2);
	            ParkingLot parkingLot = new ParkingLot(3, capacity);

	            // Configure CostStrategy
	            Map<VechileType, Double> rates = new HashMap<>();
	            rates.put(VechileType.CAR, 20.0);
	            rates.put(VechileType.TRUCK, 30.0);
	            CostStrategy costStrategy = new FlatCostStrategy(rates);
	            parkingLot.setCostStrategy(costStrategy);

	            // Add vehicles
	            Vehicle car1 = new Vehicle(VechileType.CAR, "ABC123", "Red");
	            parkingLot.addVehicle(car1);

	            // Display status
	            parkingLot.displayStatus();

	            // Remove vehicle and calculate cost
	            long currentTime = System.currentTimeMillis();
	            Vehicle removedCar = parkingLot.removeVehicle("ABC123");
	            if (removedCar != null) {
	                long duration = currentTime - removedCar.getEntryTime();
	                double cost = costStrategy.calculateCost(removedCar.getType(), duration, CurrencyType.INR);
	                System.out.println("Total cost for " + removedCar.getRegistrationNumber() + ": ₹" + cost);
	            }

	            // Display final status
	            parkingLot.displayStatus();

	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	        }
	    
	}
}