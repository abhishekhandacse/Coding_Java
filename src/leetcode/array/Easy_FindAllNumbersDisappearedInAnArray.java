package leetcode.array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Easy_FindAllNumbersDisappearedInAnArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
                         // using the given nums input array
                         for(int i=0;i<nums.length;i++){
                             if(nums[Math.abs(nums[i])-1]>0){
                                 nums[Math.abs(nums[i])-1]=(-(nums[Math.abs(nums[i])-1]));
                             }
                         }
                         List<Integer> missing=new LinkedList<>();
                         for(int i=0;i<nums.length;i++){
                             if(nums[i]>0){
                                 missing.add(i+1);
                             }
                         }
                         return missing;
    }

    public static void main(String[] args) {
        Easy_FindAllNumbersDisappearedInAnArray obj=new Easy_FindAllNumbersDisappearedInAnArray();

        List<Integer> arr=obj.findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1});
    }
}
