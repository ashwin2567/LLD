public class RatingBasedPricingStrategy implements PricingStrategy{

    @Override
    public double calculatePrice(TripMetaData tripMetaData){
        double price = RATING.isHighRating(tripMetaData.getRiderRating()) ? 55.0 : 75.0;
        System.out.println("Based on Rider Rating of " + RATING.ratingToString(tripMetaData.getRiderRating()) + " the price of the trip is " + price);
        return price;
    }
}
