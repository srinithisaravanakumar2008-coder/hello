/*public class Day8{
    record CourseRecord(String coursename,String dept){

    }
   static void main() {
       CourseRecord courseRecord = new CourseRecord("Java", "II BSC.CS(AI&DS)");
       System.out.println(courseRecord.coursename());
       System.out.println(courseRecord.dept());
   }
}*/
    enum LANGUAGE{
        EN("English"),
        GR("German"),
        JP("Japanese"),
        TA("Tamil");

        String description;

        LANGUAGE(String description){
            this.description = description;
        }
    }

    static void main() {
        System.out.println(LANGUAGE.EN.description);
        System.out.println(LANGUAGE.GR.description);
        System.out.println(LANGUAGE.JP.description);
        System.out.println(LANGUAGE.TA.description);
    }
