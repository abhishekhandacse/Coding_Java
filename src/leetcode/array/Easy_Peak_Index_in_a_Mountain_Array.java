package leetcode.array;

public class Easy_Peak_Index_in_a_Mountain_Array {
    public int peakIndexInMountainArray(int[] A) {
                int start=0,end=A.length-1,mid;

                while(start<=end){
                    mid=(start+(end-start)/2);
                    if(A[mid-1] < A[mid]  && A[mid]>A[mid+1])return mid;
                    if(A[mid-1] < A[mid]  && A[mid]<A[mid+1]){
                        start=mid+1;
                    }else{
                        end=mid-1;
                    }
                }
                return -1;//Search unsuccessful
    }
}
