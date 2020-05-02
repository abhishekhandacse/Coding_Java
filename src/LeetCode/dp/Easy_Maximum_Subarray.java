package LeetCode.dp;
/*
*   There are almost 4 methods to do this problem with varying Time Complexity
* 1) Brute force by making 2 nested loops for picking all subarrays and third nested loop for calculating sum from i-->j    TC O(N^3)
* 2) Better Approch is to Maintain a prefix sum from index i->j and use only outer two loops for calculting sum   TC O(N^2)
* 3) Using Divide and Conquer based approach with Recurence similer to merge sort Algorithm  TC O(NlogN)
* 4) Using Some Sliding window based approach or better known as Kadanes Algorithm
*
*/
public class Easy_Maximum_Subarray{
/*

    // Approach 1   TC=O(N^3)
    public int maxSubArray(final int[] nums) {
              if(nums==null || nums.length==0)return 0;
              int max=Integer.MIN_VALUE;
              int sum=0;
              for(int i=0;i<nums.length;i++){
                   for(int j=i;j< nums.length;j++){
                       //Compute sum b/w i-->j
                       sum=0;
                       for(int k=i;k<=j;k++){
                           sum+=nums[k];
                       }
                       if(max<sum)
                           max=sum;
                   }
               }
              return max;
    }

*/


    // Approach 2   TC=O(N^2)
    public int maxSubArray(final int[] nums) {
        if(nums==null || nums.length==0)return 0;// Invalid
        int max=Integer.MIN_VALUE;
        int sum=0;
        int[] prefix=new int[nums.length+1];
        // Generate the prefix sum
        for(int i=0;i<nums.length;i++){
            for(int j=i;j< nums.length;j++){
                //Compute sum b/w i-->j
                sum=0;
                for(int k=i;k<=j;k++){
                    sum+=nums[k];
                }
                if(max<sum)
                    max=sum;
            }
        }
        return max;
    }





//    For Unit Testing
    public static void main(String[] args) {
        Easy_Maximum_Subarray obj=new Easy_Maximum_Subarray();
        int[] arr=new int[]{-2,1,-3,4,-1,2,1,-5,4};//6
        System.out.println(obj.maxSubArray(arr));
        arr=new int[]{-10,-20,-30,-40};//0
        System.out.println(obj.maxSubArray(arr));
        arr=new int[]{-10,20,-30,40};//40
        System.out.println(obj.maxSubArray(arr));
        arr=new int[]{-1,40,-30,50};//60
        System.out.println(obj.maxSubArray(arr));
    }

}
