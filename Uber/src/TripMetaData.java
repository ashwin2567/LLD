public class TripMetaData {
    Location srcLoc;
    Location desLoc;
    RATING riderRating;
    RATING driverRating;

    public TripMetaData(Location srcLoc, Location desLoc, RATING riderRating) {
        this.srcLoc = srcLoc;
        this.desLoc = desLoc;
        this.riderRating = riderRating;
        this.driverRating = RATING.UNASSIGNED;
    }

    public RATING getRiderRating() {
        return riderRating;
    }

    public void setDriverRating(RATING driverRating) {
        this.driverRating = driverRating;
    }

    public Location getSrcLoc() {
        return srcLoc;
    }
}
