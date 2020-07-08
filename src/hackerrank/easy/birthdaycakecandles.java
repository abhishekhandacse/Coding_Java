package hackerrank.easy;

public class birthdaycakecandles {
    int birthdayCakeCandles(int[] ar) {
        int MAX=Integer.MIN_VALUE;
        int count=1;
        for(int i=0;i<ar.length;i++){
            if(MAX<ar[i]){
                MAX=ar[i];
                count=1;
            }else if(MAX==ar[i]){
                count++;
            }
        }
        return count;


    }
}
