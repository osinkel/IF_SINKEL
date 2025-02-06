package cars;

public abstract class Car {

    private Integer year;
    private String color;
    private String model;
    private Integer maxSpeed;
    private Integer fuelCapacity;
    private Integer power;

    public Car(String model, Integer year, String color, Integer maxSpeed, Integer fuelCapacity, Integer power){
        this.model = model;
        this.year = year;
        this.color = color;
        this.maxSpeed = maxSpeed;
        this.fuelCapacity = fuelCapacity;
        this.power = power;
    }

    public Integer getYear() { return year; }

    public String getColor() { return color; }

    public Integer getMaxSpeed() { return maxSpeed; }

    public String getModel() { return model; }

    public void changeColor(String newColor) {
        color = newColor;
    }

    public String getDescription(){
        return String.format("""
                         ---- %s ----
                        Model: %s
                        Year of production: %s
                        Color: %s
                        Max speed: %d
                        Fuel capacity: %d
                        Power: %d
                        """,
                        this.getClass().getSimpleName(), model, year, color, maxSpeed, fuelCapacity, power);
    }

    public String getSlogan() {
        return this.getClass().getSimpleName()+" slogan --- ";
    }
}
