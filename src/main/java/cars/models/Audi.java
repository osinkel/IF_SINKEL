package cars.models;

import cars.Car;

public class Audi extends Car {
    public Audi(String model, Integer year, String color, Integer maxSpeed, Integer fuelCapacity, Integer power) {
        super(model, year, color, maxSpeed, fuelCapacity, power);
    }

    @Override
    public String getSlogan() {
        return super.getSlogan() + "Vorsprung durch Technik";
    }

}
