package LeetCode.dp;
/*
* When num of piles are given even then there is atleast one case in which if alex plays optimally, she is able to partition the array with more stones
* But if num of piles are odd, then no such mathamatical then there is no mathamatical solution exists in that case and we need to stick to our basics in following apprioches like
* 1) Brute Force Recursion
* 2) Brute Force Recursion + Memoization
* 3) Bottom up iterative DP (Difficult to reach in first go so be patient while solving this problem !)
* */

// Time Complexity - Exponential    // Space Complexity - O(N)
public class Medium_Stone_Game {
    // This solution will give time limit exceeded in leetcode and we can see that only 26/46 test cases were able to pass in the permitted time
    // We can optimize out brute force solution using memoization of states since this recursion clearly has Optimal substructure + Overlapping sub-problem
    private boolean Recursion(int[] arr,int start,int end,int alex_score,int lee_score,boolean alex_turn){

            if( (start+1)==end){    // Since both are playing optimally, they will try to maximise only there own reward only
                if(alex_turn){
                    alex_score+=Math.max(arr[start],arr[end]);
                    lee_score+=Math.min(arr[start],arr[end]);
                }else{
                    alex_score+=Math.min(arr[start],arr[end]);
                    lee_score+=Math.max(arr[start],arr[end]);
                }
                if(alex_score>lee_score)return true;
                return false;
            }
            int alex_score_copy=alex_score;
            int lee_score_copy=lee_score;
            // I am choosing left most element in this recursive call for alex or lee
            if(alex_turn){
                alex_score+=arr[start];
            }else{
                lee_score+=arr[start];
            }

            boolean left_recur=Recursion(arr,start+1,end,alex_score,lee_score,!alex_turn);

            // I am choosing right most element in this recursive call for alex or lee
            if(alex_turn){
                alex_score_copy+=arr[end];
            }else{
                lee_score_copy+=arr[end];
            }

            boolean right_recur=Recursion(arr,start,end-1,alex_score_copy,lee_score_copy,!alex_turn);

            return left_recur||right_recur;
    }

    // Bottom up DP solution is quite easier and intituive If you would give a deeper thought to the problem
    // Actually I was trying to apply memoization to above solution but instead derived new bottom up solution
    // The Main recurences happening are-:
    /*
    *   Alex[i][j]= Max(arr[i] + Lee[i+1][j] , arr[j] + Lee[i][j-1]
    *   Lee[i][j] = Min(Alex[i+1][j],Alex[i][j-1])
    *
    *   Base Conditions-: Alex[i][i]=arr[i]         // Since Alex gets first turn with the only pile to pick
    *                     Lee[i][i]=0;              // Leo won't get any chance to pick any pile if there is only 1 pile
    *
    * */

    // Time Complexity- O(N^2) Space Complexity- O(N^2)
    public boolean stoneGame_BottomUpDp(int[] arr){
            if(arr==null || arr.length==0)return false;
            // Minimum 1 pile garunteed
            if(arr.length==1)return true;

            int[][] Alex_Score=new int[arr.length][arr.length];
            int[][] Lee_Score=new int[arr.length][arr.length];
            // considering all piles individually as base case  (For Lee it would always be 0 so no need to do anything)

            for(int i=0;i<arr.length;i++)
                Alex_Score[i][i]=arr[i];

            // Now Procesing diagnol wise (First picking piles in pairs then triplets then so on and so forth)

            int i=0,j=1;

            while( ((i<arr.length) && (j<arr.length)) ){
                int row=i,col=j;

                for(;((row<arr.length) && (col<arr.length));row++,col++){
                    Alex_Score[row][col]=Math.max(arr[row] + Lee_Score[row+1][col],arr[col] + Lee_Score[row][col-1]);
                    Lee_Score[row][col]=Math.min(Alex_Score[row+1][col],Alex_Score[row][col-1]);
                }
                j++;
            }


            return ((Alex_Score[0][arr.length-1] - Lee_Score[0][arr.length-1])  >  0);
    }

    public boolean stoneGame(int[] arr) {

            // I am trying to do brute force recursion i:e
            // in first case I will choose the left side element in case of alex/lee and
            // in second case I will choose the right side element in case of alex/lee
            // Basically Trying all possible variations.
            // parameters are     (arr,start,end,alex_score,lee_score,alex_turn)
            // return Recursion(arr,0,arr.length-1,0,0,true);

            return stoneGame_BottomUpDp(arr);
    }

    public static void main(String[] args) {
        Medium_Stone_Game obj=new Medium_Stone_Game();
        System.out.println(obj.stoneGame(new int[]{1,2,10}));//true
        System.out.println(obj.stoneGame(new int[]{10,14,1}));//false
        System.out.println(obj.stoneGame(new int[]{1,4,10,20}));//true  // Always true in even num of piles (Can be proved mathematically)
        System.out.println(obj.stoneGame(new int[]{50,80,10,20,90,1}));//true  // Always true in even num of piles (Can be proved mathematically)
        System.out.println(obj.stoneGame(new int[]{2,80,10,20,90,1}));//true  // Always true in even num of piles (Can be proved mathematically)
        System.out.println(obj.stoneGame(new int[]{50,80,10,100,90,1}));//true  // Always true in even num of piles (Can be proved mathematically)
    }
}
