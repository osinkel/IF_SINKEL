import cars.Car;
import cars.models.*;

import java.util.*;

public class Main {

    public static void printCarsAfter2006(List<Car> cars){
        for(Car car : cars){
            if(car.getYear() > 2006){
                System.out.println(car.getDescription());
            } else {
                System.out.println(car.getModel() + " of " + car.getYear() + " is an outdated car.");
            }
        }
    }

    public static Car changeColorIfGreen(Car car){
        String newColor = "Red";
        String searchColor = "Green";
        if(car.getColor().equalsIgnoreCase(searchColor)){
            car.changeColor(newColor);
            System.out.printf(car.getClass().getSimpleName()+" "+car.getModel()+ " color was changed from %s to %s\n", searchColor, newColor);
        }
        return car;
    }

    public static void printSloganOfFastestCar(List<Car> cars){
        System.out.println(Collections.max(cars, Comparator.comparing(Car::getMaxSpeed)).getSlogan());
    }

    public static void main(String[] args) {
        //it's Main origin

        List<Car> cars = new ArrayList<Car>();
        cars.add(new Audi("A4", 2000, "Red", 190, 54, 131));
        cars.add(new Audi("A6", 2004, "Black", 201, 54, 156));
        cars.add(new Toyota("Corolla XII", 2019, "Dark blue", 188, 60, 128));
        cars.add(new Toyota("Camry XV70", 2020, "White", 277, 64, 208));
        cars.add(new Suzuki("Alto", 1979, "Black", 110, 40, 109));
        cars.add(new Suzuki("SX4", 2006, "Red", 192, 54, 137));
        cars.add(new Nissan("GT-R", 2009, "Silver", 255, 58, 178));
        cars.add(new Nissan("300ZX", 1989, "Yellow", 210, 54, 164));
        cars.add(new Volkswagen("Sharan", 1994, "Grey", 160, 60, 137));
        cars.add(new Volkswagen("Passat", 2004, "Green", 180, 68, 134));

        cars.replaceAll(Main::changeColorIfGreen);

        printCarsAfter2006(cars);

        printSloganOfFastestCar(cars);


    }
}