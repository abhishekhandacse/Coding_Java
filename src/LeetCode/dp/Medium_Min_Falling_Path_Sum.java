package LeetCode.dp;


// Time Complexity-: O(N^2) Space Complexity-: O(N^2)     // Space Complexity can be reduced further on the cost of modifying original matrix which is not a good practice
public class Medium_Min_Falling_Path_Sum {
        int minimum(int a,int b,int c){
            return Math.min(a,Math.min(b,c));
        }
        public int minFallingPathSum(final int[][] A) {

                    int[][] Aux=new int[A.length][A.length];    // Default initialized to 0
                    int min=Integer.MAX_VALUE;
                    for(int i=0;i<A.length;i++){
                        for(int j=0;j<A[0].length;j++){
                            if(i==0){
                                Aux[i][j]=A[i][j];
                                min=Aux[i][0];
                                continue;
                            }
                            int left_up=((j>0)?Aux[i-1][j-1]+A[i][j]:Integer.MAX_VALUE);
                            int up=Aux[i-1][j]+A[i][j];
                            int right_up=(( (j<(A[0].length-1)) )?Aux[i-1][j+1]+A[i][j]:Integer.MAX_VALUE);

                            Aux[i][j]=minimum(left_up,up,right_up);

                            if(j==0)
                                min=Aux[i][j];
                            if(min>Aux[i][j])
                                min=Aux[i][j];
                        }
                    }
                    return min;
        }

    // Just for unit testing
    public static void main(String[] args) {
        Medium_Min_Falling_Path_Sum obj=new Medium_Min_Falling_Path_Sum();

        System.out.println(obj.minFallingPathSum(
                new int[][]{
                        {1,2,3},
                        {4,5,6},
                        {7,8,9}
                }

        ));
    }//12
}
