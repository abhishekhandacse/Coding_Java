package leetcode.dp;

public class Medium_Minimum_Cost_For_Tickets {


    private int Recur(int MaxDays,boolean[] willTravel,int[] costs,int[] DP){
        if(MaxDays<=0)return 0;

        if(DP[MaxDays]>0)return DP[MaxDays];
        int daily;
        if(willTravel[MaxDays]==true){
            daily=Recur(MaxDays-1,willTravel,costs,DP)+costs[0];
        }else{
            daily=Recur(MaxDays-1,willTravel,costs,DP)+0;
        }

        int weekly=Recur(MaxDays-7,willTravel,costs,DP)+costs[1];
        int monthly=Recur(MaxDays-30,willTravel,costs,DP)+costs[2];

        DP[MaxDays]=Math.min(daily,Math.min(weekly,monthly));
        return DP[MaxDays];
    }
    // Time Complexity-: O(N)  Space Complexity -: O(366)
    public int mincostTickets(int[] days, int[] costs) {
               boolean[] willTravel=new boolean[366];
               for(int i=0;i<days.length;i++){
                   willTravel[days[i]]=true;
               }

               int[] DP=new int[366];
               Recur(days[days.length-1],willTravel,costs,DP);
               return DP[days[days.length-1]];
    }


    public static void main(String[] args) {
        Medium_Minimum_Cost_For_Tickets obj=new Medium_Minimum_Cost_For_Tickets();
        System.out.println(obj.mincostTickets(new int[]{1,4,6,7,8,20},new int[]{2,7,100}));
        System.out.println(obj.mincostTickets(new int[]{1,2,3,4,5,6,7,8,9,10,30,31},new int[]{2,7,15}));
        System.out.println(obj.mincostTickets(new int[]{1,4,6,8},new int[]{2,3,8}));
    }

}
