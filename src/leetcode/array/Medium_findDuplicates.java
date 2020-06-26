package leetcode.array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Medium_findDuplicates {

    public List<Integer> findDuplicates(int[] nums) {
            List<Integer> arrlist=new LinkedList<>();
            for(int i=0;i<nums.length;i++){
                if( nums[Math.abs(nums[i])-1]<0 ){
                    arrlist.add(Math.abs(nums[i]) );
                }
                nums[Math.abs(nums[i])-1]*=-1;
            }
            return arrlist;
    }

    public static void main(String[] args) {
            Medium_findDuplicates obj=new Medium_findDuplicates();
            List<Integer> ans=obj.findDuplicates(new int[]{4,3,2,7,8,2,3,1});
            for(int i:ans)
                System.out.print(i+" ");
    }
}
