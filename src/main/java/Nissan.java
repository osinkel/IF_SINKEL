public class Nissan extends Car{
    public Nissan(String model, Integer year, String color, Integer maxSpeed, Integer fuelCapacity, Integer power) {
        super(model, year, color, maxSpeed, fuelCapacity, power);
    }

    @Override
    public String getSlogan() {
        return super.getSlogan() + "shift_expectations";
    }
}
