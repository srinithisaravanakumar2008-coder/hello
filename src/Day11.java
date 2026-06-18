/*import java.util.HashSet;
import java.util.Set;
public class Day11 {
    static void main(){
        Set<String> set = new HashSet<>();
        set.add("Class4");
        set.add("Class3");
        set.add("Class2");
        set.add("Class1");
        set.add("Class4");
        set.add("Class3");
        set.add("Class2");
        set.add("Class1");
        System.out.println("Set:");
        for (String S:set){
            System.out.println(S);
        }
    }
}*/
import java.util.HashMap;
import java.util.Map;
public class Day11_{
    static void main(){
        Map <String,Integer> m = new HashMap<>();
        m.put("Srinithi",89);
        m.put("Sanjana",86);
        m.put("Gayathri",86);
        m.put("Thanya",98);
        m.entrySet().forEach(entry ->{
            System.out.println(entry.getKey() + " : " + entry.getValue());
        });
    }
}
