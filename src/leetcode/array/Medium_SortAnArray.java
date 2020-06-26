package leetcode.array;

public class Medium_SortAnArray {
    void print(int[] arr){
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
   /* public int[] sortArray(int[] nums) {
        int MINIMUM=Integer.MAX_VALUE;
        int MAXIMUM=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(MINIMUM>nums[i])
                MINIMUM=nums[i];
            if(MAXIMUM<nums[i])
                MAXIMUM=nums[i];
        }
        int arr[]=new int[100001];
        for(int i:nums){
            arr[i+MINIMUM]+=1;
        }
        int start=0;
        for(int i=0;i<(MAXIMUM+Math.abs(MINIMUM)+1);){
            if(arr[i]>0){
                nums[start]=i-MINIMUM;
                arr[i]--;
                start++;
                continue;
            }
            i++;
        }
        return nums;
    }*/
    // Time Complexity -: O(100001)  Space Complexity-: O(100001)
    public int[] sortArray(int[] nums) {
        final int MAX=100001;
        int arr[]=new int[MAX];
        for(int i:nums){
            arr[i+50000]+=1;
        }
        int start=0;
        for(int i=0;i<MAX;){
            if(arr[i]>0){
                nums[start]=i-50000;
                arr[i]--;
                start++;
                continue;
            }
            i++;
        }
        return nums;
    }
    public static void main(String[] args) {
        Medium_SortAnArray obj=new Medium_SortAnArray();
        obj.print(obj.sortArray(new int[]{5,2,3,1})); ;
        obj.print(obj.sortArray(new int[]{5,1,1,2,0,0}));
    }
}
