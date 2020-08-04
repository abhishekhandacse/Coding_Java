package hackerrank.easy;

public class ArraysLeftRotation{
    // Time Complexity -: O(N) Space Complexity -: O(2*N)
    // If no of queries are really large then this is good approach
    static int[] rotLeft(int[] arr, int d){
                 int l=arr.length;
                 int[] aux=new int[2*l];
                 for(int i=0;i<(2*l);i++){
                     aux[ (i%l) ] = arr[ (i%l) ];
                 }

                 for(int i=d;i<(d+l);i++){
                     arr[i-d]=aux[i];
                 }

                 return arr;
    }
}
