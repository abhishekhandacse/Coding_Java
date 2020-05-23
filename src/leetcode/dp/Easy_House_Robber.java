package leetcode.dp;

public class Easy_House_Robber {
    // TC- O(N)   SC- (N)
    public int rob(int[] nums) {

        if(nums==null || nums.length==0)return 0;

        int[][] dp=new int[2][nums.length+1];

        int i;
        for(i=0;i<nums.length;i++){


            dp[0][i+1]=Math.max(dp[0][i],dp[1][i]); // If you are excluding current house, then it does not matter weather you included the prev one or not.

            dp[1][i+1]=dp[0][i]+nums[i];    // including the current element implies excluding the previous one and adding the current house robbery amount.

        }

        return Math.max(dp[0][i],dp[1][i]);     // Return the maximum irrespective of weather you included the last element or excluded it.

    }
    // TC- O(N)   SC- O(1)
    public int rob_space_optimized(int[] nums) {

        if(nums==null || nums.length==0)return 0;
        int excluded=0,included=0,prev_excl=0,prev_incl=0,i;
        for(i=0;i<nums.length;i++){
            included=prev_excl+nums[i];    // including the current element implies excluding the previous one and adding the current house robbery amount.
            excluded=Math.max(prev_excl,prev_incl); // If you are excluding current house, then it does not matter weather you included the prev one or not.

            prev_incl=included;
            prev_excl=excluded;
        }

        return Math.max(excluded,included);     // Return the maximum irrespective of weather you included the last element or excluded it.
    }
}
