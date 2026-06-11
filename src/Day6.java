/*public class Day6 {
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
}*/
public class Day6_part {
    static class Student {
        String Name;
        int RegNo;
        String Department;
        int MathsMark;
        int PhysicsMark;
        int CSEMark;
        void StudentInfo(String Name, int RegNo) {
            this.Name = Name;
            this.RegNo = RegNo;
        }
        void information(String Name, int RegNo, String Department) {
            this.Name = Name;
            this.RegNo = RegNo;
            this.Department = Department;
        }
        int getMathsMark() {
            return MathsMark;
        }
        int getPhysicsMark() {
            return PhysicsMark;
        }
        int getCSEMark() {
            return CSEMark;
        }
        void StudentMarks(int MathsMark) {
            this.MathsMark = MathsMark;
            System.out.println("Updating Maths Mark : " + MathsMark);
        }
        void StudentMarks(int PhysicsMark, int CSEMark) {
            this.PhysicsMark = PhysicsMark;
            this.CSEMark = CSEMark;
            System.out.println("Updating Physics Mark : " + PhysicsMark);
            System.out.println("Updating CSE Mark : " + CSEMark);
        }
        void display() {
            System.out.println("Name : " + Name);
            System.out.println("Reg No : " + RegNo);
            System.out.println("Department : " + Department);
            System.out.println("Maths Mark : " + MathsMark);
            System.out.println("Physics Mark : " + PhysicsMark);
            System.out.println("CSE Mark : " + CSEMark);
        }
    }
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.StudentInfo("Srinithi", 252860);
        s1.information("Sanjana", 252852, "AIDS");
        s1.StudentMarks(90);
        s1.StudentMarks(85, 95);
        s1.display();
    }
}
