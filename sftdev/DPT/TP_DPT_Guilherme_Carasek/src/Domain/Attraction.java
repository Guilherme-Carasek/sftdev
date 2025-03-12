package Domain;

public class Attraction {
    private int id;
    private String name;
    private double adultPrice;
    private double childPrice;
    private int durationSeconds;

    public Attraction(int id, String name, double adultPrice, double childPrice, int durationSeconds) {
        this.id = id;
        this.name = name;
        this.adultPrice = adultPrice;
        this.childPrice = childPrice;
        this.durationSeconds = durationSeconds;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getAdultPrice() {
        return adultPrice;
    }

    public double getChildPrice() {
        return childPrice;
    }

    public int getDurationSeconds() {
        return durationSeconds;
    }
}
