package Domain;

public class Costs {
    private int attraction;
    private double maintenanceCostPerTicket;
    private double maintenanceCostPerMonth;

    public Costs(int attraction, double maintenanceCostPerTicket, double maintenanceCostPerMonth) {
        this.attraction = attraction;
        this.maintenanceCostPerTicket = maintenanceCostPerTicket;
        this.maintenanceCostPerMonth = maintenanceCostPerMonth;
    }

    public int getAttraction() {
        return attraction;
    }

    public double getMaintenanceCostPerTicket() {
        return maintenanceCostPerTicket;
    }

    public double getMaintenanceCostPerMonth() {
        return maintenanceCostPerMonth;
    }
}
