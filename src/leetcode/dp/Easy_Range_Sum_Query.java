package LeetCode.dp;

public class Easy_Range_Sum_Query {

    int[] prefix;

    public Easy_Range_Sum_Query(int[] nums) {
        // Generate the prefix sum
        prefix=new int[nums.length+1];
        for(int i=0;i<nums.length;i++){
            prefix[i+1]=prefix[i] + nums[i];
        }

    }

    public int sumRange(int i, int j) {
        return prefix[j+1]-prefix[i];
    }

}
