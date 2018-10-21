package misc;

public class Truck extends Vehicle {

    /**
     * e.g. mini truck, with trailer
     */
    private String truckType;

    public Truck() {
        this.setType("Truck");
        this.setNumberOfWheels(10);
    }

    public String getTruckType() {
        return truckType;
    }

    public void setTruckType(String truckType) {
        this.truckType = truckType;
    }
}
