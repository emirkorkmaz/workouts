package misc;

import java.util.Stack;

public class CarLot {

    private static Stack<Vehicle> carLot = new Stack<>();

    private CarLot() {}

    public static void parkVehicle(Vehicle vehicle) throws CarLotFullException {
        if(carLot.isEmpty()) {
            carLot.push(vehicle);
            System.out.println("Successfully parked!");
        } else {
            throw new CarLotFullException("Car lot is full");
        }
    }

    public static Vehicle getVehicle() throws CarLotEmptyException {
        if(!carLot.isEmpty()) {
            System.out.println("Successfully get the car!");
            return carLot.pop();
        } else {
            throw new CarLotEmptyException("Car lot is empty");
        }
    }
}
