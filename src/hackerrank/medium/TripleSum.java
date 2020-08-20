package hackerrank.medium;

import java.util.ArrayList;
import java.util.Arrays;

public class TripleSum{

    static ArrayList<Integer> unique(int[] arr){
            ArrayList<Integer> temp=new ArrayList<>();
            temp.add(arr[0]);
            int i=0,j=1;
            for(;j<arr.length;j++){
                if(arr[j]==arr[i]){
                    continue;
                }else{
                    temp.add(arr[j]);
                    i=j;
                }
            }
            return temp;
    }
    static int binary_search_floor(ArrayList<Integer> arr, int key){
            int low=0,high=arr.size()-1;
            while(low<=high){
                int mid=(low+(high-low)/2);
                if(arr.get(mid)==key)return mid;
                else if(key < arr.get(mid)){
                    high=mid-1;
                }else{
                    low=mid+1;
                }
            }
            if(high<0)return -1;    // No floor exist in this case
            return high;
    }
    static long triplets(int[] a, int[] b, int[] c){
                Arrays.sort(a);
                Arrays.sort(b);
                Arrays.sort(c);

                ArrayList<Integer> arr1=unique(a);
                ArrayList<Integer> arr2=unique(b);
                ArrayList<Integer> arr3=unique(c);


                int i=0,j=0,k=0;
                long count=0;
                while(j<arr2.size()){

                    i=binary_search_floor(arr1,arr2.get(j));
                    k=binary_search_floor(arr3,arr2.get(j));

                    if(i==-1 || k==-1){
                        count+=0;
                    }else{
                        count+=( (long)(i+1)*(long)(k+1) );
                    }
                    j++;
                }
            return count;
    }

    public static void main(String[] args) {
        //Unit testing
        System.out.println(triplets(new int[]{1,3,5},new int[]{2,3},new int[]{1,2,3}));//8
        System.out.println(triplets(new int[]{1,4,5},new int[]{2,3,3},new int[]{1,2,3}));//5
        System.out.println(triplets(new int[]{1,3,5,7},new int[]{5,7,9},new int[]{7,9,11,13}));//12
    }
}
