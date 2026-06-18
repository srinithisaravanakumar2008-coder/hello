import java.util.LinkedList;

public class Day10Linked {

    static class Student {
        String name;
        int regNo;
        int marks;

        Student(String name, int regNo, int marks) {
            this.name = name;
            this.regNo = regNo;
            this.marks = marks;
        }
    }

    static void removeStudent(LinkedList<Student> students) {
        System.out.println("Removed : " + students.removeFirst().name);
    }

    static void updateStudent(LinkedList<Student> students) {
        for (Student s : students) {
            if (s.name.equals("Srinithi")) {
                s.marks = 95;
            }
        }
    }

    public static void main(String[] args) {

        LinkedList<Student> students = new LinkedList<>();
        students.add(new Student("Pooja", 2542, 80));
        students.add(new Student("Sanjana", 2552, 79));
        students.add(new Student("Thanyasri", 2565, 90));
        students.add(new Student("Gayathri", 2559, 75));
        students.add(new Student("Srinithi", 2560, 88));

        removeStudent(students);

        updateStudent(students);

        System.out.println("\nStudent Details");
        for (Student s : students) {
            System.out.println(s.name + " " +s.regNo + " " + s.marks);
        }
    }
}
