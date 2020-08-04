package hackerrank.medium;

public class CommonChild {
    static int recursiveLCS(String s1,String s2,int[][] dp,int i,int j,int l1,int l2){
                if(i==l1 || j==l2)return 0;
                if(dp[i][j]!=-1)return dp[i][j];

                if(s1.charAt(i)==s2.charAt(j)){
                    dp[i][j]=recursiveLCS(s1,s2,dp,i+1,j+1,l2,l2)+1;
                }else{
                    dp[i][j]=Math.max(recursiveLCS(s1,s2,dp,i,j+1,l1,l2),recursiveLCS(s1,s2,dp,i+1,j,l1,l2));
                }
                return dp[i][j];
    }
    static int recursiveLCSOptimized(String s1,String s2){
        int l1=s1.length();
        int l2=s2.length();
        short dp[][] =new short[l1+1][l2+1];

        for(int i=1;i<l1+1;i++){
            for(int j=1;j<l2+1;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=(short)(dp[i-1][j-1]+(short)1);
                }else{
                    dp[i][j]=((short)Math.max(dp[i-1][j],dp[i][j-1]));
                }
            }
        }
        return dp[l1][l2];
    }
    static int commonChild(String s1, String s2) {
                int l1=s1.length(),l2=s2.length(),l3=100000;

                int[][] dp=new int[l3][l3];
                for(int i=0;i<l1;i++){
                    for(int j=0;j<l2;j++){
                        dp[i][j]=-1;
                    }
                }
                return recursiveLCS(s1,s2,dp,0,0,l1,l2);
    }

    public static void main(String[] args) {
        System.out.println(commonChild("HARRY","SALLY"));
    }
}
