package leetcode.array;

public class Easy_NonDecreasingArray {
    public boolean checkPossibility(int[] nums) {
                    if(nums==null || nums.length==0 || nums.length==1)return true;

                    int voilationCount=0;
                    int index=-1;

                    for(int i=1;i<nums.length;i++){
                        if(nums[i-1]>nums[i]){
                            voilationCount+=1;
                            index=i-1;
                        }
                    }

                    if(voilationCount==0)return true;
                    if(voilationCount>=2)return false;

                    if(index==0)return true;
                    if(index==nums.length-2)return true;
                    if( nums[index+1] - nums[index-1] >=0 )return true;

                    if( (index+2)<nums.length && nums[index + 2] - nums[index] >=0 )return true;
                    return false;

    }
}
