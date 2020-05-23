package leetcode.dp;

public class Medium_LongestCommonSubsequence {
    /*
    //Recursive brute force solution Time Complexity -: (Exponential), SpaceComplexity -: O(N)
    //Note-: Brute Force solution is so computationally expensive that it gives Time Limit Exceeded
    private int recursiveBruteForce(String text1,int i,String text2,int j){
       // base condition to prevent overflow
        if(i==text1.length() || j==text2.length()){
            return 0;// End of the string reached
        }

        if(text1.charAt(i)==text2.charAt(j)){// first character of both the strings matches
            return 1+recursiveBruteForce(text1,i+1,text2,j+1);// increment this probable subsequence length by 1
        }else{
            int possibility1=recursiveBruteForce(text1,i+1,text2,j);// explore by removing first character of text1

            int possibility2=recursiveBruteForce(text1,i,text2,j+1);// explore by removing first character of text2

            return Math.max(possibility1,possibility2);//return the Maximum overall possibility
        }
    }
    public int longestCommonSubsequence(String text1, String text2) {
                return recursiveBruteForce(text1,0,text2,0);
    }
    */



    /*
    *//*Trying to Optimise the brute Force recursive solution by keeping and maintaining a 2D memo*//*
    //Recursive  solution Time Complexity -: ~ N^2 , SpaceComplexity -: N^2
    private int recursiveBruteForce(String text1,int i,String text2,int j,int[][] memo){
        // base condition to prevent overflow
        if(i==text1.length() || j==text2.length()){
            return 0;// End of the string reached
        }
        if(memo[i][j]!=0){// No need to re-compute the already computed value
            return memo[i][j];
        }
        if(text1.charAt(i)==text2.charAt(j)){// first character of both the strings matches
            memo[i][j]= 1+recursiveBruteForce(text1,i+1,text2,j+1,memo);// increment this probable subsequence length by 1
        }else{
            int possibility1=recursiveBruteForce(text1,i+1,text2,j,memo);// explore by removing first character of text1

            int possibility2=recursiveBruteForce(text1,i,text2,j+1,memo);// explore by removing first character of text2

            memo[i][j]= Math.max(possibility1,possibility2);//return the Maximum overall possibility
        }
        return memo[i][j];
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] memo=new int[text1.length()][text2.length()];// Just for keeping the already computed solution to sub-problems
        return recursiveBruteForce(text1,0,text2,0,memo);
    }

*/


    // Bottom up DP solution
    // Time-Complexity -: O(N^2)  Space-Complexity -: O(N^2)
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] memo=new int[text1.length()+1][text2.length()+1];// Just for keeping the already computed solution to sub-problems

        for(int i=1;i<text1.length()+1;i++){
            for(int j=1;j<text2.length()+1;j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    memo[i][j]=memo[i-1][j-1]+1;
                }else{
                    memo[i][j]=Math.max(memo[i-1][j],memo[i][j-1]);
                }
            }
        }

        return memo[text1.length()][text2.length()];
    }
    public static void main(String[] args) {
        Medium_LongestCommonSubsequence obj=new Medium_LongestCommonSubsequence();
        //Few testcases for unit testing
        System.out.println(obj.longestCommonSubsequence("abc","agbdc"));//3
        System.out.println(obj.longestCommonSubsequence("agbdc","abc"));//3
        System.out.println(obj.longestCommonSubsequence("abc","def"));//0
        System.out.println(obj.longestCommonSubsequence("abc","cde"));//1
    }
}
