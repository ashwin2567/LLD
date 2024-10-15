public enum RATING {
    UNASSIGNED,
    ONE_STAR,
    TWO_STARS,
    THREE_STARS,
    FOUR_STARS,
    FIVE_STARS;

    static boolean isHighRating(RATING rating){
        return rating == RATING.FOUR_STARS || rating == RATING.FIVE_STARS;
    }

    static String ratingToString(RATING pRating) {
        if (pRating == RATING.ONE_STAR)
            return "one star";
        if (pRating == RATING.TWO_STARS)
            return "two stars";
        if (pRating == RATING.THREE_STARS)
            return "three stars";
        if (pRating == RATING.FOUR_STARS)
            return "four stars";
        if (pRating == RATING.FIVE_STARS)
            return "five stars";
        return "invalid rating";
    }
};
