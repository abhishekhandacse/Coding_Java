package leetcode.array;

public class Easy_Sort_Array_By_Parity {
    // Time Complexity-: O(N)   Space Complexity-: O(N)
    public int[] sortArrayByParity(int[] A) {
               int front=0,rear=A.length-1;

               while(front<rear){
                   if(A[front]%2!=0 && A[rear]%2==0 ){
                       int temp=A[front];
                       A[front]=A[rear];
                       A[rear]=temp;
                       front++;
                       rear--;
                   }else if(A[front]%2==0){
                       front++;
                   }else if(A[rear]%2!=0){
                       rear--;
                   }else{
                       front++;
                       rear--;
                   }
               }
               return A;
    }
}
