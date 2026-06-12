/*void main(){
    String name = "Srinithi";
    System.out.println(name.toUpperCase());
 */
void main(){
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter your name:");
    String name = sc.nextLine();
    System.out.println("Enter your department:");
    String dept = sc.nextLine();
    System.out.println("Enter your age:");
    int age = sc.nextInt();
    System.out.println("\nDetails:");
    System.out.println("Name : "+ name);
    System.out.println("Dept : "+ dept);
    System.out.println("Age : "+ age);
}