package misc;

public class VehicleParking {

    public static void main(String[] args) {
        Vehicle car = new Car();
        Vehicle bicycle = new Bicycle();
        Vehicle truck = new Truck();

        try {
            CarLot.parkVehicle(bicycle);
            CarLot.parkVehicle(car);
        } catch (CarLotFullException e) {
            System.out.println(e.getMessage());
        }

        try {
            CarLot.getVehicle();
        } catch (CarLotEmptyException e) {
            System.out.println(e.getMessage());
        }

        try {
            CarLot.getVehicle();
        } catch (CarLotEmptyException e) {
            System.out.println(e.getMessage());
        }
    }
}
