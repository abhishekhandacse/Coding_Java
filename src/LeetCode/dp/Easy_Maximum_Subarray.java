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

    // Approach 1   TC=O(N^3)       SC=O(N)
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

/*


    // Approach 2   TC=O(N^2)       SC=O(N)
    public int maxSubArray(final int[] nums) {
        if(nums==null || nums.length==0)return 0;// Invalid
        int max=Integer.MIN_VALUE;
        int[] prefix=new int[nums.length+1];
        // Generate the prefix sum
        for(int i=0;i<nums.length;i++){
            prefix[i+1]=prefix[i] + nums[i];
        }

        int sum=0;
        for(int i=0;i<nums.length;i++){
            for(int j=i;j< nums.length;j++){
                sum=prefix[j+1] - prefix[i];
                if(max<sum)
                    max=sum;
            }
        }
          return max;
    }
 */
/*

        // Approach 3   TC=O(NlogN)       SC=O(N)           // Quite Similer to merge sort
        private int Conquer(final int[] arr,int low,int mid,int high){

                    int left_contagious_sum=Integer.MIN_VALUE;
                    int right_contagious_sum=Integer.MIN_VALUE;

                    // Moving to left side from mid included to low included
                    int temp_left_sum=0;
                    for(int i=mid;i>=low;i--){
                        temp_left_sum+=arr[i];
                        if(left_contagious_sum<temp_left_sum)
                            left_contagious_sum=temp_left_sum;
                    }

                    // Moving to right side from mid excluded to high included
                    int temp_right_sum=0;
                    for(int i=mid+1;i<=high;i++){
                        temp_right_sum+=arr[i];
                        if(right_contagious_sum<temp_right_sum)
                            right_contagious_sum=temp_right_sum;
                    }

                    return left_contagious_sum+right_contagious_sum;
        }
        private int Divide(final int[] arr,int low,int high){
                    if(low==high)return arr[low];      // Single element is itself the maximum sum in that subarray

                    int mid=(low + (high-low)/2);

                    int left_sum=  Divide(arr,low,mid);        // Divide the array with left part containing extra element in case of total odd elements
                    int right_sum= Divide(arr,mid+1,high);
                    // Conquer step or merge step
                    int merged_sum=Conquer(arr,low,mid,high);// This step would provide their maximum sum considering them contagious
                    return Math.max(left_sum,Math.max(right_sum,merged_sum));
        }
        public int maxSubArray(final int[] nums) {
            if (nums == null || nums.length == 0) return 0;// Invalid
            return Divide(nums,0,nums.length-1);
        }


        */


        // Approach 4    kadanes Algorithm        TC(O(N))   SC(O(N))   // Basically sliding window approach
                                                                        // The Main idea is that, we should restart counting the sum, as soon as sum becomes -ve



    public int maxSubArray(final int[] nums) {
        if (nums == null || nums.length == 0) return 0;// Invalid
        int maxsum=Integer.MIN_VALUE;
        int currsum=0;

        for(int i=0;i<nums.length;i++){
            currsum+=nums[i];
            if(maxsum<currsum)
                maxsum=currsum;

            if(currsum<0)
                currsum=0;//Rest for fresh start

        }
        return maxsum;
    }





//    For Unit Testing
    public static void main(String[] args) {
        Easy_Maximum_Subarray obj=new Easy_Maximum_Subarray();
        int[] arr=new int[]{-2,1,-3,4,-1,2,1,-5,4};//6
        System.out.println(obj.maxSubArray(arr));
        arr=new int[]{-10,-20,-30,-40};//-10
        System.out.println(obj.maxSubArray(arr));
        arr=new int[]{-10,20,-30,40};//40
        System.out.println(obj.maxSubArray(arr));
        arr=new int[]{-1,40,-30,50};//60
        System.out.println(obj.maxSubArray(arr));
    }

}
