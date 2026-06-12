/*public class Day6 {
    /*public class Day6 {
        static class Car {
            String brand;
            String model;
    public static void main(String[] args) {
            car.showFuel();
            car.drive(40);
        }
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