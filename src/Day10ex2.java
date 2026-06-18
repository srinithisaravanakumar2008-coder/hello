public class Day10ex2 {
    static  void main(){
        String name="Srinithi";
        try{
            System.out.println(name.charAt (3));
            System.out.println(10/0);
        } catch(ArithmeticException e){
            System.out.println("Arithmetic Exception");
        } catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("Array Index Out OfBounds Exception");
        } finally {
            System.out.println("Executed Successfully");
        }
    }
}