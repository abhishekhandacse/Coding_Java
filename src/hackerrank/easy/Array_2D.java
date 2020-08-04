package hackerrank.easy;

public class Array_2D {
    //  TC-: O(N)   SC-: O(1)
    static int hourglassSum(int[][] arr){
                int sum=0;
                int ans=0;
                for(int i=1;i<arr.length-1;i++){
                    for(int j=1;j<arr.length-1;j++){
                        sum=arr[i][j]+arr[i-1][j-1]+arr[i-1][j]+arr[i-1][j+1]+arr[i+1][j-1]+arr[i+1][j]+arr[i+1][j+1];
                        ans=Math.max(ans,sum);
                    }
                }
                return ans;
    }
}
