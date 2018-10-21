package misc;

public class Bicycle extends Vehicle {

    /**
     * e.g. road, TT, MTB
     */
    private String bikeType;

    public Bicycle() {
        this.setType("Bicycle");
        this.setNumberOfWheels(2);
    }

    public String getBikeType() {
        return bikeType;
    }

    public void setBikeType(String bikeType) {
        this.bikeType = bikeType;
    }
}
