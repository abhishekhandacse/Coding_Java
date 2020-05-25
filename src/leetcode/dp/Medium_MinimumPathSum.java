package leetcode.dp;

public class Medium_MinimumPathSum {
    public int minPathSum(int[][] grid) {

        int[][] DP=new int[grid.length][grid[0].length];

        for(int i=0;i<DP.length;i++){
            for(int j=0;j<DP[0].length;j++){
                if(i==0 && j==0){
                    DP[i][j]=grid[i][j];
                    continue;
                }
                if(i==0){
                    DP[i][j]=DP[i][j-1]+grid[i][j];
                    continue;
                }
                if(j==0){
                    DP[i][j]=DP[i-1][j]+grid[i][j];
                    continue;
                }

                DP[i][j]=Math.min(DP[i-1][j],DP[i][j-1])+grid[i][j];
            }
        }
        return DP[grid.length-1][grid[0].length-1];
    }
    public static void main(String[] args) {

    }
}
