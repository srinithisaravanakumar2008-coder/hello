/*void main (){
    int n=5;
    //row
   for(int row  = 1;row <= n;row++){
        //column
       for(int column  = 1;column <= row;column++){
           System.out.print(column);
       }
        System.out.println ();
    }
  }
 */
void main() {
    int[] marks = {87, 32, 44, 89, 23};
    System.out.print("Pass marks:");
    for (int i = 0; i < marks.length; i++) {
        if (marks[i] >= 40) {
            System.out.print(marks[i] + " ");
        }
    }
    System.out.println();

    System.out.print("Fail marks: ");
    for (int i = 0; i < marks.length; i++) {
        if (marks[i] < 40) {
            System.out.print(marks[i] + " ");
        }
    }
                                          }