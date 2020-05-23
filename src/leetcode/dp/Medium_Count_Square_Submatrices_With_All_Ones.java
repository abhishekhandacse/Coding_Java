package leetcode.dp;

public class Medium_Count_Square_Submatrices_With_All_Ones {
    // Time Complexity O(N^3)  Space Complexity O(R*C)
    final static boolean DEBUG=false;
    public int countSquares(final int[][] matrix) {
        if(matrix==null || (matrix.length==0 && matrix[0].length==0) )return 0; // Base case

        final int Rows=matrix.length,Cols=matrix[0].length;

        final int[][] SubmatrixSum=new int[Rows+1][Cols+1];
        // Populating the submatrix sum ( Using this I can get any Submatrix sum in O(1) time)
        for(int i=1;i<Rows+1;i++){
            for(int j=1;j<Cols+1;j++){
                SubmatrixSum[i][j]=SubmatrixSum[i][j-1]+SubmatrixSum[i-1][j]-SubmatrixSum[i-1][j-1] + matrix[i-1][j-1];
            }
        }
        if(DEBUG){
            for(int i=0;i<Rows+1;i++){
                for(int j=0;j<Cols+1;j++){
                    System.out.print(SubmatrixSum[i][j]+" ");
                }
                System.out.println();
            }
        }


        // Calculating square of various sizes from side == 1 to side == min(Rows,Cols)
        int Total_Submatrices_with_All_ones=0;
        for(int i=0;i<Rows+1;i++){
            for(int j=0;j<Cols +1;j++){
                for(int side=1;side<Math.min(Rows+1 -i ,Cols+1 -j );side++){
                   // I need to calculate the sum of the submatrix from (i,j)   ---->       (i+side,j+side)
                    Total_Submatrices_with_All_ones+=((SubmatrixSum[i+side][j+side] -SubmatrixSum[i][j+side]-SubmatrixSum[i+side][j]+SubmatrixSum[i][j])==(side*side)) ? 1:0;
                }
            }
        }
        return Total_Submatrices_with_All_ones;
    }
    // Optimization Possible  (This DP solution is little hard to imagine on first shot, but I will explain why the above solution is doing redundant computations)
    // In the a
    public int countSquares_optimized(final int[][] matrix) {
        if(matrix==null || (matrix.length==0 && matrix[0].length==0) )return 0; // Base case

        final int Rows=matrix.length,Cols=matrix[0].length;

        int[][] TotalSquares=new int[Rows+1][Cols+1];   // Remeber this is for increasing unserstanding only otherwise is redundant since a single variable would also serve the purpose
        // Also number at any position of this matrix denotes the maximum size square possibly we can get and the number of possible squares including this element.
        int All_Squares_Sum=0;
        for(int i=1;i<(Rows+1);i++){
            for(int j=1;j<(Cols+1);j++){
                if(matrix[i-1][j-1]==1){        // We can construct square considering this 1
                    /*
                    *   We are taking minimum of the Sum at left , above, diagonal previous
                    *   This is because The maximum size square I can carve out including current element is the their min value (because the min size neighbour would become bottleneck)  +1  (This would be the limiting factor)
                    *   You can verify this fact by imagining scenarios like
                    *   [
                    *       [0,0,0,0,0]
                    *       [0,0,1,1,1]
                    *       [0,1,1,1,1]
                    *       [0,1,1,1,?]         left 3  , digonal 2, up 3
                    *       You can se the bottleneck is diagonally upward element to ?  (Just grab a pen and paper and try to draw squares corresponding their size)
                    *   ]
                    *
                    *   Other case is
                    * [
                     *       [0,0,1,1,1]
                     *       [0,0,1,1,1]
                     *       [0,0,1,1,1]
                     *       [0,0,0,1,?]    left 1  , digonal 2, up 3
                     *       You can se the bottleneck is left element = 1 to ?  (Just grab a pen and paper and try to draw squares corresponding their size)
                     * ]
                     *
                     *
                     * Similarly you can carve out example where min element is up
                    */
                    TotalSquares[i][j]=Math.min(TotalSquares[i-1][j-1],Math.min(TotalSquares[i][j-1],TotalSquares[i-1][j]))+1;
                    All_Squares_Sum+=TotalSquares[i][j];
                }
            }
        }

        return All_Squares_Sum;
    }

    //    Unit testing
    public static void main(String[] args) {
        Medium_Count_Square_Submatrices_With_All_Ones obj=new Medium_Count_Square_Submatrices_With_All_Ones();
        System.out.println(obj.countSquares_optimized(new int[][]{
                {0, 1, 1, 1},
                {1, 1, 1, 1},
                {0, 1, 1, 1}
        }));//15

        System.out.println(obj.countSquares_optimized(new int[][]{
                        {1, 0, 1},
                        {1, 1, 0},
                        {1, 1, 0}
                }
        ));//7


    }

}
