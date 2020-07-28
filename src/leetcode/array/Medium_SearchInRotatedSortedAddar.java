package leetcode.array;

public class Medium_SearchInRotatedSortedAddar {
    int bs(int[] arr,int target,int low,int high){
        if(low>high)return -1;
        int mid=low+((high-low)/2);
        if(arr[mid]==target)return mid;
        if(arr[low]<=arr[mid]){
            if(arr[low]<=target && target<arr[mid])
                return bs(arr, target, low, mid-1);
            else return bs(arr,target,mid+1,high);
        }else{
            if(arr[mid]<target && target<=arr[high])
                return bs(arr,target,mid+1,high);
            else return bs(arr,target,low,mid-1);
        }
    }
    public int search(int[] nums, int target){
        return bs(nums,target,0,nums.length-1);
    }
}
