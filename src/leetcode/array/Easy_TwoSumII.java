package leetcode.array;

public class Easy_TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
                int start=0,end=numbers.length-1;

                while(start<end){
                    if( (numbers[start]+numbers[end])==target){
                        break;
                    }else if((numbers[start]+numbers[end])<target){
                        start++;
                    }else{
                        end--;
                    }
                }
                int[] arr=new int[2];
                arr[0]=start;
                arr[1]=end;
                return arr;
    }
}
