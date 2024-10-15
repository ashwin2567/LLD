public class DefaultPricingStrategy implements PricingStrategy{

    @Override
    public double calculatePrice(TripMetaData tripMetaData) {
        System.out.println("Based on default pricing strategy, the price is 100.");
        return 100;
    }
}
