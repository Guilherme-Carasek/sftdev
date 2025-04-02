package Domain;

public class Sale {
    private int attractionId;
    private String date;
    private boolean isAdult;

    public Sale(int attractionId, String date, boolean isAdult) {
        this.attractionId = attractionId;
        this.date = date;
        this.isAdult = isAdult;
    }

    public int getAttractionId() {
        return attractionId;
    }

    public String getDate() {
        return date;
    }

    public boolean isAdult() {
        return isAdult;
    }
}
