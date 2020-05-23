package leetcode.dp;

public class Medium_FillingBookcaseShelves {
    /*
    // Recursive Implementation
    private int Recursive(int[][] books,int i,int sw,int cw,int maxHeight){
        if(i<0)return 0;

        if(cw==0){// implies this is the first book of new row we need to include it, no other alternative
            return Math.max(Recursive(books,i-1,sw,cw+books[i][0],Math.max(maxHeight,books[i][1])),books[i][1]);
        }else{
            int heightInclusion=Integer.MAX_VALUE,heightExclusion=Integer.MAX_VALUE;

            //inclusion
            if(cw+books[i][0]<=sw){
                heightInclusion=Math.max(Recursive(books,i-1,sw,cw+books[i][0],Math.max(maxHeight,books[i][1])),books[i][1]);
            }
            //exclusion
            heightExclusion=Recursive(books,i,sw,0,0)+maxHeight;

            return Math.min(heightExclusion,heightInclusion);
        }
    }
    */
    // Recursive + Memoization
    private int Recursive(int[][] books,int i,int sw,int cw,int maxHeight,int[][] memo){
        if(i<0)return 0;
        if(memo[i][cw]!=0)
            return memo[i][cw];
        if(cw==0){// implies this is the first book of new row we need to include it, no other alternative
            memo[i][cw]= Math.max(Recursive(books,i-1,sw,cw+books[i][0],Math.max(maxHeight,books[i][1]),memo),books[i][1]);
        }else{
            int heightInclusion=Integer.MAX_VALUE,heightExclusion=Integer.MAX_VALUE;
            //inclusion
            if(cw+books[i][0]<=sw){
                heightInclusion=Math.max(Recursive(books,i-1,sw,cw+books[i][0],Math.max(maxHeight,books[i][1]),memo),books[i][1]);
            }
            //exclusion
            heightExclusion=Recursive(books,i,sw,0,0,memo)+maxHeight;

            memo[i][cw]= Math.min(heightExclusion,heightInclusion);//
        }
        return memo[i][cw];
    }
    public int minHeightShelves(int[][] books, int shelf_width) {
            int memo[][]=new int[books.length+1][shelf_width+1];   // i // cw // maxHeight
            return Recursive(books,books.length-1,shelf_width,0,0,memo);
    }

    public static void main(String[] args) {
        Medium_FillingBookcaseShelves obj=new Medium_FillingBookcaseShelves();
        System.out.println(obj.minHeightShelves(new int[][]{{1,10}},3));//10
        System.out.println(obj.minHeightShelves(new int[][]{{1,2},{2,1}},3));//2
        System.out.println(obj.minHeightShelves(new int[][]{{2,1},{1,2}},3));//2
        System.out.println(obj.minHeightShelves(new int[][]{{1,1},{2,3},{2,3},{1,1},{1,1},{1,1},{1,2}},4));//6
        System.out.println(obj.minHeightShelves(new int[][]{{1,1},{1,1},{3,1},{2,1},{2,1}},4));//3
    }
}