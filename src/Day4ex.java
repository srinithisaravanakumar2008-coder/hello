public class day4_ex{
    void main(){
        //int[][] studentMarks=new int[5][3];
        int[][] studentMarks = {
                {33, 77, 88},
                {78, 90, 34},
                {86, 65, 89},
                {12, 34, 56},
                {66, 12, 88}
        };

        for ( int row = 0;row < studentMarks.length;row++){
            int total=0;
            for ( int col = 0;col < studentMarks.length;col++){
                total+=studentMarks[row][col];
            }
            double avg=total/3.0;
            System.out.println("Student"+(row+1));
            System.out.println("Total"+total);
            System.out.println("average"+avg);
        }
        System.out.println();
    }
}
