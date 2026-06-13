public class Day8{
    record CourseRecord(String coursename,String dept){

    }
   static void main() {
       CourseRecord courseRecord = new CourseRecord("Java", "II BSC.CS(AI&DS)");
       System.out.println(courseRecord.coursename());
       System.out.println(courseRecord.dept());
   }
}