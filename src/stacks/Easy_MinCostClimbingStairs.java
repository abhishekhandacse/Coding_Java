package stacks;

public class Easy_MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        if(cost.length==2)return Math.min(cost[0],cost[1]);
        //Now length will be >2 for sure


        int prev=cost[0];
        int curr=cost[1];
        int next =0;
        for(int i=2;i<cost.length;i++){
            next=cost[i] + Math.min(prev,curr);
            prev=curr;
            curr=next;
        }
        return Math.min(prev,curr);
    }
}
/*
Time Complexity--> O(N)
Space Complexity --> O(1)
Algorithmic Paradigm--> Dynamic Programming
*/