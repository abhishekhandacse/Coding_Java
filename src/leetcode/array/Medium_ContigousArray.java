package leetcode.array;

public class Medium_ContigousArray {
    public int findMaxLength(int[] nums) {
        if(nums==null || nums.length==0)return 0;
        int preCompute[]=new int[nums.length+1];
        int maxlen=0;
        for(int i=1;i<nums.length+1;i++){
            if(nums[i-1]==1)
                preCompute[i]=preCompute[i-1]+1;
            else preCompute[i]=preCompute[i-1];
           // System.out.print(preCompute[i]+"  ");
            int ones=preCompute[i]-preCompute[ (((i-(2*preCompute[i]))>0)?(i-(2*preCompute[i])):i)  ];
            int zeros=(2*preCompute[i])-ones;
            System.out.print(ones+" ");
            if(ones==zeros)
                maxlen=Math.max(maxlen,2*ones);
        }
        System.out.println();
        return maxlen;
    }

    public static void main(String[] args) {
        Medium_ContigousArray obj=new Medium_ContigousArray();
//        System.out.println(obj.findMaxLength(new int[]{0,1})) ;//2
//        System.out.println(obj.findMaxLength(new int[]{0,1,0}));//2
        System.out.println(obj.findMaxLength(new int[]{0,1,1,1,0,0}));//6
//        System.out.println(obj.findMaxLength(new int[]{0,1,1,0,0,0}));//4
//        System.out.println(obj.findMaxLength(new int[]{0,0,0,0,0}));//0
//        System.out.println(obj.findMaxLength(new int[]{0,0,1,0,0,0,1,1}));//6
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
*/