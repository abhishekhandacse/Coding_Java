package hackerrank.medium;

public class ArrayManipulation {
    // TC O(N) SC(N)
    static long arrayManipulation(int n, int[][] queries){

        int[] arr=new int[n+2];

        for(int i=0;i<queries.length;i++){

            int start=queries[i][0];
            int end= queries[i][1];
            int price=queries[i][2];

            arr[start]+=price;
            arr[end+1]-=price;
        }

        long curr_ans=0;
        long max_ans=0;

        for(int i=1;i<n+2;i++){
            curr_ans+=arr[i];
            max_ans=Math.max(max_ans,curr_ans);
        }
        return max_ans;
    }

}
