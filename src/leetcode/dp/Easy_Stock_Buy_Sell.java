package leetcode.dp;

public class Easy_Stock_Buy_Sell {
    public int maxProfit(int[] prices) {
        int len=prices.length;
        if(len<2)return 0;


        int[] inc=new int[len];
        int[] dec=new int[len];
        inc[0]=prices[0];
        dec[len-1]=prices[len-1];
        int max=0;
        for(int i=1,j=len-2;i<len ; i++,j--){
            if(prices[i]<inc[i-1]){
                inc[i]=prices[i];
            }else{
                inc[i]=inc[i-1];
            }

            if(prices[j]>dec[j+1]){
                dec[j]=prices[j];
            }else{
                dec[j]=dec[j+1];
            }
            if(j<=i){
                if(max < dec[i]-inc[i])
                    max=dec[i]-inc[i];

                if(max < dec[j]-inc[j])
                    max=dec[j]-inc[j];
            }
        }

        return max;
    }

    // Optimum solution consumes O(N) time, O(1) space...
    /*
    * No need to maintain the inc and dec arrays, just maintain two points min and profit and try to maximise profit and minimize in the minimum point
    * */
}
