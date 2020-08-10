package hackerrank.medium;

import java.util.Arrays;

public class GreedyFlorist {
    static int getMinimumCost(int k, int[] c) {
        Arrays.sort(c);
        int aux[]=new int[k];
        int j=0,cost=0;
        for(int i=c.length-1;i>=0;i--){
            cost+=(aux[j]+1)*(c[i]);
            aux[j]=aux[j]+1;
            j=j+1;
            if(j==k)
                j=0;
        }
        return cost;
    }
}
