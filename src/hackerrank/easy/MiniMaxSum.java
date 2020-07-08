package hackerrank.easy;

public class MiniMaxSum {
    void miniMaxSum(int[] arr) {
        long sum=0;
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++) {
            sum += arr[i];
            if(max<arr[i])
                max=arr[i];
            if(min>arr[i])
                min=arr[i];
        }
        System.out.println( (sum-max) +" "+ (sum-min) );
    }
}
