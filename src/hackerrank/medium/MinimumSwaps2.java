package hackerrank.medium;

public class MinimumSwaps2 {
    static int minimumSwaps(int[] arr) {

                int count=0;
                for(int i=0;i<arr.length;i++){
                    if( arr[i]==(i+1) ){
                        count++;
                    }
                }
                return arr.length-count;
    }
}
