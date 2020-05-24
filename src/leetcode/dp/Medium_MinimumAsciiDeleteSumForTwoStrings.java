package leetcode.dp;

public class Medium_MinimumAsciiDeleteSumForTwoStrings {
    /*

    Time Complexity -: Exponential  Space Complexity -: Linear*//*
    int Recursion(String s1,int i,String s2,int j){
        if(i==s1.length() && j==s2.length()){
            return 0;
        }
        if(i==s1.length()){
            return Recursion(s1,i,s2,j+1)  + (int)s2.charAt(j);//character at j deleted
        }
        if(j==s2.length()){
            return Recursion(s1,i+1,s2,j)  + (int)s1.charAt(i);//character at i deleted
        }

        if(s1.charAt(i)!=s2.charAt(j)){
            int option1=Recursion(s1,i+1,s2,j)  + (int)s1.charAt(i);//character at i deleted
            int option2=Recursion(s1,i,s2,j+1)  + (int)s2.charAt(j);//character at j deleted
            return Math.min(option1,option2);
        }else{
            int option1=Recursion(s1,i+1,s2,j+1) + 0 ;// Nothing deleted
            return option1;
        }
    }

    public int minimumDeleteSum(String s1, String s2) {
        return Recursion(s1,0,s2,0);
    }
    */
/*
    // Applying memoization with Naive Recursion
    //Time Complexity -: Quadratic  Space Complexity -: Quadratic *//*
    int Recursion(String s1,int i,String s2,int j,int[][] memo){
        if(i==s1.length() && j==s2.length()){
            return 0;
        }
        if(i==s1.length()){
            memo[i][j]= Recursion(s1,i,s2,j+1,memo)  + (int)s2.charAt(j);//character at j deleted
            return memo[i][j];
        }
        if(j==s2.length()){
            memo[i][j]= Recursion(s1,i+1,s2,j,memo)  + (int)s1.charAt(i);//character at i deleted
            return memo[i][j];
        }

        if(memo[i][j]!=0)return memo[i][j];

        if(s1.charAt(i)!=s2.charAt(j)){
            int option1=Recursion(s1,i+1,s2,j,memo)  + (int)s1.charAt(i);//character at i deleted
            int option2=Recursion(s1,i,s2,j+1,memo)  + (int)s2.charAt(j);//character at j deleted
            memo[i][j]= Math.min(option1,option2);
        }else{
            int option1=Recursion(s1,i+1,s2,j+1,memo) + 0 ;// Nothing deleted
            int option2=Recursion(s1,i+1,s2,j+1,memo) + (2*((int)s1.charAt(i))) ;    // Both the equal characters in both the strings removed
            memo[i][j]= Math.min(option1,option2);
        }
        return memo[i][j];
    }

    public int minimumDeleteSum(String s1, String s2) {
        int[][] memo=new int[s1.length()+1][s2.length()+1];
        return Recursion(s1,0,s2,0,memo);
    }
    */
    // Bottom-up DP solution
    //Time Complexity -: Quadratic  Space Complexity -: Quadratic *//*
    public int minimumDeleteSum(String s1, String s2) {
        int Memo[][]=new int[s1.length()+1][s2.length()+1];
        for(int i=0;i<s1.length()+1;i++){
            for(int j=0;j<s2.length()+1;j++){
                if(i==0){
                    if(j>0){
                        Memo[i][j]=Memo[i][j-1]+(int)s2.charAt(j-1);
                    }
                    continue;
                }
                if(j==0){
                    if(i>0){
                        Memo[i][j]=Memo[i-1][j]+(int)s1.charAt(i-1);
                    }
                    continue;
                }

                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    Memo[i][j]=Memo[i-1][j-1];//Retain both the equal characters and try to get the best possible ignoring both the current characters
                }else{
                    if(Memo[i-1][j]+(int)s1.charAt(i-1)<Memo[i][j-1]+(int)s2.charAt(j-1)){
                        Memo[i][j]=Memo[i-1][j]+(int)s1.charAt(i-1);
                    }else{
                        Memo[i][j]=Memo[i][j-1]+(int)s2.charAt(j-1);
                    }
                }
            }
        }
        return Memo[s1.length()][s2.length()];
    }
    public static void main(String[] args) {
        Medium_MinimumAsciiDeleteSumForTwoStrings obj=new Medium_MinimumAsciiDeleteSumForTwoStrings();
        System.out.println(obj.minimumDeleteSum("a","b"));//97+98
        System.out.println(obj.minimumDeleteSum("abc","def"));// a + b + c + d + e + f
        System.out.println(obj.minimumDeleteSum("abc","bcf"));// a + f
        System.out.println(obj.minimumDeleteSum("sea","eat"));// 231
        System.out.println(obj.minimumDeleteSum("delete","leet"));//403
        System.out.println(obj.minimumDeleteSum("ab","ba"));//194

    }

}
