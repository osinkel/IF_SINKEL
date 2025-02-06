package cars.models;

import cars.Car;

public class Suzuki extends Car {
    public Suzuki(String model, Integer year, String color, Integer maxSpeed, Integer fuelCapacity, Integer power) {
        super(model, year, color, maxSpeed, fuelCapacity, power);
    }

    @Override
    public String getSlogan() {
        return super.getSlogan() + "Way of Life";
    }
}
