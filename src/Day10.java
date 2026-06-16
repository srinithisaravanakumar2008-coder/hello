import java.util.ArrayList;
public class Day10 {
    static void main() {
        String[] StudentName = {"Srinithi", "Sanjana", "Gayathri", "Lasika", "Sajitha"};
        System.out.println(StudentName.length);

        ArrayList<String> StudentList = new ArrayList();
        StudentList.add("Srinithi");
        StudentList.add("Sanjana");
        StudentList.add("Gayathri");
        StudentList.add("Lasika");
        StudentList.add("Sajitha");
        for (String S : StudentList) {
            System.out.println(S);
        }
        StudentList.remove("Lasika");
        System.out.println();
        for (String S : StudentList) {
            System.out.println(S);
        }
    }
}