package misc;

public class Car extends Vehicle {

    /**
     * e.g. racing car, van, hatch-back ...
     */
    private String carType;

    public Car() {
        this.setType("Car");
        this.setNumberOfWheels(4);
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }
}
