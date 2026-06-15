/*public class Day8{
    record CourseRecord(String coursename,String dept){

    }
   static void main() {
       CourseRecord courseRecord = new CourseRecord("Java", "II BSC.CS(AI&DS)");
       System.out.println(courseRecord.coursename());
       System.out.println(courseRecord.dept());
   }
}*/
   /* enum LANGUAGE{
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
    }*/
public class LoginExample{

// login
// Success, Failure, loading
sealed interface LoginResult permits LoginSuccess, LoginFailure, LoginLoading {

}
record LoginSuccess(String time) implements LoginResult {

}
record LoginFailure(String reason)  implements LoginResult {

}

record LoginLoading(String expectedTime)  implements LoginResult {

}

record Random(String reason){

}
static void handleLogin(LoginResult result) {
    switch (result) {
        case LoginSuccess success -> System.out.println("Login Success at : " + success.time());
        case LoginFailure failure -> System.out.println("Login Failure because of " + failure.reason());
        case LoginLoading loading -> System.out.println("Login Loading, " + loading.expectedTime());
    }
}
static void main() {
    LoginResult  LoginSuccess = new LoginSuccess("2026-06-15:05:07:25");
    LoginResult LoginFailure = new LoginFailure("Network issue");
    LoginResult LoginLoading= new LoginLoading("Please wait for few minutes");

    handleLogin(LoginSuccess);
    handleLogin(LoginFailure);
    handleLogin(LoginLoading);
}
}
