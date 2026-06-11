public class Day6 {
    static class Car {
        String brand;
        String model;
        int price;
        int fuel;
        Car() {
            System.out.println("Car Constructor Called");
        }
        Car(String brand, String model, int price) {
            this.brand = brand;
            this.model = model;
            this.price = price;
        }
        void refuel(int litres) {
            fuel += litres;
            System.out.println(litres + " litres added");
        }
        void drive(int litresUsed) {
            if (fuel >= litresUsed) {
                fuel -= litresUsed;
                System.out.println("Car driven successfully");
            }
            else {
                System.out.println("Not enough fuel");
            }
        }
        void showFuel() {
            System.out.println("Current Fuel: " + fuel + " litres");
        }
        void printDetails() {
            System.out.println("Brand: " + brand);
            System.out.println("Model: " + model);
            System.out.println("Price: " + price);
        }
    }
    public static void main(String[] args) {
        Car car = new Car("Toyota", "Fortuner", 450000);
        car.printDetails();
        car.refuel(50);
        car.showFuel();
        car.drive(20);
        car.showFuel();
        car.drive(40);
    }
}