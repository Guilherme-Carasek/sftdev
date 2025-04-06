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

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Attraction){
            Attraction attraction = (Attraction) obj;
            if (this.name.equals(attraction.name) && this.adultPrice == attraction.adultPrice &&
                    this.childPrice == attraction.childPrice && this.durationSeconds == attraction.durationSeconds){
                return true;
            }
        }
        return false;
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
