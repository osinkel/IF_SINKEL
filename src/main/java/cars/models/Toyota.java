package cars.models;

import cars.Car;

public class Toyota extends Car {
    public Toyota(String model, Integer year, String color, Integer maxSpeed, Integer fuelCapacity, Integer power) {
        super(model, year, color, maxSpeed, fuelCapacity, power);
    }

    @Override
    public String getSlogan() {
        return super.getSlogan() + "Always a better way";
    }
}
