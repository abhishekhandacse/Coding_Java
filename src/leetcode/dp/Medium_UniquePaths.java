package leetcode.dp;

public class Medium_UniquePaths {
    public int uniquePaths(int m, int n) {
            int[][] DP=new int[m][n];

            for(int i=0;i<m;i++){

                for(int j=0;j<n;j++){
                    if(i==0 || j==0){
                        DP[i][j]=1;
                        continue;
                    }

                    DP[i][j]=DP[i-1][j]+DP[i][j-1];


                }
            }
            return DP[m-1][n-1];

    }

    public static void main(String[] args) {
        Medium_UniquePaths obj=new Medium_UniquePaths();
        System.out.println(obj.uniquePaths(3,2));//3
        System.out.println(obj.uniquePaths(7,3));//28
    }

}
