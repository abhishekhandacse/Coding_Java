package leetcode.array;

public class Easy_RotateArray {

    // Time Complexity O(nums * k) SC O(1)
    public void rotate(int[] nums, int k) {
        if(nums.length==1)return;
        while (k>0){
            int temp=nums[0];
            nums[0]=nums[nums.length-1];

            for(int i=nums.length-2;i>0;i--){
                nums[i+1]=nums[i];
            }

            nums[1]=temp;

            k--;
        }
    }
    // Could be optimized to TC O(1) SC O(2*nums)
}
