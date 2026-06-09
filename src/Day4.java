 /*
void main(){
    int[][] marks = new int[5][3];
    int[][] studentMarks = {
            {33, 77, 88},
            {78, 90, 34},
            {86, 65, 89},
            {12, 34, 56},
            {66, 12, 89},
    };
    for(int row = 0;row < studentMarks.length;row++){
        for(int col = 0;col < studentMarks[row].length;col++){
            System.out.print(studentMarks[row][col] +" ");
        }
        System.out.println();
    }
}*/
 void main(){
     int[][] attendance = {
             {0,1,0},
             {1,0,0},
             {1,1,1},
             {1,0,1},
             {0,0,0}
     };
     for (int row = 0;row < attendance.length;row++){
         System.out.println("Student "+(row+1)+":");
         for(int col = 0;col < attendance[row].length;col++){
             if(attendance[row][col]== 1){
                 System.out.println("Class"+(col+1)+": Present");
             }
             else {
                 System.out.println("Class"+(col+1)+": Absent");

             }
         }
         System.out.println();
     }
 }