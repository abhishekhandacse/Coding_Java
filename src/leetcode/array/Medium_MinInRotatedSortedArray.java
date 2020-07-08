package leetcode.array;

public class Medium_MinInRotatedSortedArray {
    public int findMin(int[] arr) {
        int left=0,right=arr.length-1,mid;
        while(left<=right){
            mid=left+((right-left)/2);
            if( (left==mid) && (mid==right) )return arr[mid];
            if( mid!=0 && arr[mid]<arr[mid-1] && mid!=(arr.length-1) && arr[mid]<arr[mid+1] ){
                return arr[mid];
            }else if(arr[mid]<arr[right]){
                if(mid>0)
                    right=mid-1;
                else right=mid;
            }else{
                if(mid<arr.length-1)
                    left=mid+1;
                else left=mid;
            }
        }
        return -1;// Search Unsuccessful
    }
    public static void main(String[] args) {
        Medium_MinInRotatedSortedArray obj=new Medium_MinInRotatedSortedArray();
        System.out.println(obj.findMin(new int[]{4,5,6,7,0,1,2}));//0
        System.out.println(obj.findMin(new int[]{0,1,2,3,4,5}));//0
        System.out.println(obj.findMin(new int[]{2,1}));//1
        System.out.println(obj.findMin(new int[]{0,2}));//0
        System.out.println(obj.findMin(new int[]{3,2,1}));//1
    }
}
