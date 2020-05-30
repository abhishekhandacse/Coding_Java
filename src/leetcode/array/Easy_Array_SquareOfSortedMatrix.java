package leetcode.array;

public class Easy_Array_SquareOfSortedMatrix {

    public int[] sortedSquares(int[] A) {

               int partition=0;
               for(int i=0;i<A.length;i++){
                   partition=i;
                   if(A[i]>=0){
                       break;
                   }
               }
               int back_iter=partition-1,forw_iter=partition;

               int[] solution=new int[A.length];
               int sol_index=0;
               while(back_iter>=0 && forw_iter<A.length){
                   if((-1*A[back_iter])<A[forw_iter]){
                       solution[sol_index]=A[back_iter]*A[back_iter];
                       back_iter--;
                   }else{
                       solution[sol_index]=A[forw_iter]*A[forw_iter];
                       forw_iter++;
                   }
                   sol_index++;
               }

               while(back_iter>=0){
                   solution[sol_index]=A[back_iter]*A[back_iter];
                   back_iter--;
                   sol_index++;
               }

               while(forw_iter<A.length){
                   solution[sol_index]=A[forw_iter]*A[forw_iter];
                   forw_iter++;
                   sol_index++;
               }

               return solution;
    }
    void print(int[] arr){
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i]+"   ");
        System.out.println();
    }
    public static void main(String[] args) {
        Easy_Array_SquareOfSortedMatrix obj=new Easy_Array_SquareOfSortedMatrix();
        obj.print(obj.sortedSquares(new int[]{-4,-1,0,3,10}));
        obj.print(obj.sortedSquares(new int[]{-7,-3,2,3,11}));
    }
}
