package hackerrank.medium;

import java.util.Arrays;

public class MaxMin {
    static int maxMin(int k, int[] arr) {
        Arrays.sort(arr);
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<(arr.length-k+1);i++){
            if(ans> Math.abs(arr[i+k-1]-arr[i]))
                ans=Math.abs(arr[i+k-1]-arr[i]);
        }
        return ans;
    }
}
