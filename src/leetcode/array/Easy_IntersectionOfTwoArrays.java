package leetcode.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class Easy_IntersectionOfTwoArrays {

    // Time Complexity -: O(N)  Space Complexity -: O(N)
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> hs=new HashSet<>();
        HashSet<Integer> ans=new HashSet<>();
        for(int i:nums1){
            hs.add(i);
        }

        for(int i:nums2){
            if(hs.contains(i))
                ans.add(i);
        }
        int len=ans.size();

        int index=0;
        int[] arr=new int[len];
        for(Integer i:ans){
            arr[index]=i;
            index++;
        }
        return arr;
    }
}
