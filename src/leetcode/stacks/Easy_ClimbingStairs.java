package leetcode.stacks;

public class Easy_ClimbingStairs {
    public int climbStairs(int n) {
        // this problem is eqvt to nth fibonachi number

        if(n==1 || n==2 || n==3)return n;

        int prev=2;
        int curr=3;
        int next=0;
        for(int i=4;i<=n;i++){
            next=prev+curr;
            prev=curr;
            curr=next;
        }
        return next;
    }
}
