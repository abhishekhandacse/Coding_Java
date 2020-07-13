package leetcode.array;

import java.util.Arrays;
import java.util.HashMap;


public class Medium_ContigousArray {
    //Time Complexity-: O(N)
    //Space Complexity-: O(2*N+1)
    public int findMaxLengthopt(int[] nums) {
        if(nums==null || nums.length==0)return 0;
        int ans=0,sum=0;
        int[] aux=new int[2*nums.length+1];
        Arrays.fill(aux,Integer.MAX_VALUE);
        final int center=nums.length;
        aux[center]=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0)
                sum-=1;
            else
                sum+=1;
            if(aux[center+sum]==Integer.MAX_VALUE){
                aux[center+sum]=i+1;
            }else{
                ans=Math.max(ans,i+1-aux[center+sum]);
            }
        }
        return ans;
    }
    //Time Complexity-: O(NLogN)
    //Space Complexity-: O(N)
    public int findMaxLength(int[] nums) {
        if(nums==null || nums.length==0)return 0;
        HashMap<Integer,Integer> hm=new HashMap<>();
        hm.put(0,0);
        int sums=0;
        int ans=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0)
                sums-=1;
            else sums+=1;
            Object obj=hm.get(sums);
            if(obj==null){
                hm.put(sums,i+1);
            }else{
                ans=Math.max(ans,i+1-(int)obj);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Medium_ContigousArray obj=new Medium_ContigousArray();
        System.out.println(obj.findMaxLengthopt(new int[]{0,1})) ;//2
        System.out.println(obj.findMaxLengthopt(new int[]{0,1,0}));//2
        System.out.println(obj.findMaxLengthopt(new int[]{0,1,1,1,0,0}));//6
        System.out.println(obj.findMaxLengthopt(new int[]{0,1,1,0,0,0}));//4
        System.out.println(obj.findMaxLengthopt(new int[]{0,0,0,0,0}));//0
        System.out.println(obj.findMaxLengthopt(new int[]{0,0,1,0,0,0,1,1}));//6
    }
}
//  ones  zeros
/*
*   0       0
*   1       1
*   2       1
*   3       1
*   3       2
*   3       3
*

***This question can be done by 4 approches Actually***
Approach-1
	* Iteratre and pick all contigous subarrays
	* Iterate and pick the sum in between the indexes i->j
Time Complexity-: O(N^3) Space Complexity-: O(1)

Approach-2
	* Do optimization over approach 1 and maintain a prefix sum based array for pre-computing the sum
	Time Complexity-: O(N^2) Space Complexity-: O(N)

Approach-3
	* Use a hashmap as a smart optimization for storing already encountered sum
	* Remember a zero sum contigous subarray would not change the prefix sum .
	```

    ```

	Time Complexity-: O(NlogN) Space Complexity-: O(N)

Approach-4
	* Do optimization over approach 1 and maintain a prefix sum based array for pre-computing the sum
	```

    ```
	Time Complexity-: O(N) Space Complexity-: O(2*N + 1)



*/