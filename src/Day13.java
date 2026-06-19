/*import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Day13 {
    static void main() {
        Path path = Path.of("files","report.txt");

        try{
            List<String> data = Files.readAllLines(path);

            for (String line : data) {
                System.out.println(line);
            }

            List<String> newData = new ArrayList<>();
            newData.add("Cat1");
            newData.add("Cat2");
            newData.add("Cat3");
            newData.add("Cat4");
            newData.add("Cat5");

            Files.write(path,newData);


        } catch (IOException io){
               io.printStackTrace();
        }
    }
}*/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Day13_ {
    static void main() {
        Path path = Path.of("Files", "student.csv");
        try {
            List<String> student = Files.readAllLines(path);

            for (String v : student) {
                String[] row = v.split(",");
                for (int i = 0; i < row.length; i++) {
                    System.out.print(row[i] + "|");
                }
                System.out.println();

            }
          /*  List<String> m = new ArrayList<>();
            m.add("Puppy1");
            m.add("Puppy2");
            m.add("Puppy3");
            m.add("Puppy4");
            m.add("Puppy5");

            Files.write(path, m);*/
        } catch (IOException io) {
            io.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array Index Out Of Bounds Exception");
        }
    }
}