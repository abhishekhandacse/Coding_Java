package hackerrank.medium;

import java.util.Arrays;
import java.util.HashSet;

public class Pairs {
    static int binary_search(int[] arr, int key){
        int low=0,mid, high=arr.length-1;
        while(low<=high){
            mid = (low + ((high-low)/2));
            if(key<arr[mid]){
                high=mid-1;
            }else if( key > arr[mid]){
                low=mid+1;
            }else{
                return mid;
            }
        }
        return -1;
    }
    // TC O(NlogN) SC O(N)  ///// This will work even if unique constraint is removed
    static int pairs(int k, int[] arr){
                Arrays.sort(arr);
                int count=0;
                for(int i=0;i<arr.length;i++){
                    if(arr[i]+k > arr[arr.length-1]){
                        break;//No benefit of search beyond this
                    }

                    if(binary_search(arr,arr[i]+k)!=-1){
                        count=count+1;
                    }

                }
                return count;
    }
    //TC O(N) SC O(N)   //// This would not work if all elements are not unique
    static int pairs_optimized(int k, int[] arr){
        HashSet<Integer> hs=new HashSet<>();
        for(int i=0;i<arr.length;i++)
            hs.add(arr[i]);
        int count=0;
        for(int i=0;i<arr.length;i++) {
            if (hs.contains(arr[i] + k)) {
                count = count + 1;
            }
        }
        return count;
    }


    public static void main(String[] args) {
        System.out.println(pairs_optimized(2,new int[]{1,5,3,4,2}));//3
        System.out.println(pairs_optimized(1,new int[]{1,2,3,4,5,6,7,8,9}));//8
    }
}
