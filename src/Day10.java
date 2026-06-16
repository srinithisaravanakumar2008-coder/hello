/*import java.util.ArrayList;
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
}*/
import java.util.LinkedList;
public class Day10 {
    static void process(LinkedList<String> queue) {
        System.out.println("Removed:" + queue.removeFirst());
    }

    static void main() {
        LinkedList<String> queue = new LinkedList<>();
        queue.add("A");
        queue.add("B");
        queue.add("C");
        queue.add("D");
        queue.add("E");

        while (queue.size() > 1) {
            process(queue);
        }
    }
}