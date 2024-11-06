import java.util.Map;

public class FlatCostStrategy implements CostStrategy {
    private final Map<VechileType, Double> hourlyRates;

    public FlatCostStrategy(Map<VechileType, Double> rates) {
        this.hourlyRates = rates;
    }

    @Override
    public double calculateCost(VechileType type, long parkedDuration, CurrencyType currency) {
        double hours = parkedDuration / (1000.0 * 60 * 60);
        return hours * hourlyRates.get(type);
    }
}