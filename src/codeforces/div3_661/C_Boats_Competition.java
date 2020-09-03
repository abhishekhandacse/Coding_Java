package codeforces.div3_661;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class C_Boats_Competition {


    public static int no_of_pairs(int[] arr, int s){
        int low=0,high=arr.length-1;
        int count=0;
        while(low<high){
            if(arr[low]+arr[high]==s){
                count+=1;
                low+=1;
                high-=1;
            }else if(arr[low]+arr[high]<s){
                low+=1;
            }else{
                high-=1;
            }
        }
        return count;
    }
    public static int compute(int[] arr){
        if(arr.length==1)return 0; // Not possible to pair at all
        if(arr.length==2)return 1;// 1 pair possible
        Arrays.sort(arr);
        int min_s=arr[0]+arr[1],max_s=arr[arr.length-1]+arr[arr.length-2];
        int optimal_s_val=0;
        for(int i=min_s;i<=max_s;i++){
               optimal_s_val=Math.max(optimal_s_val,no_of_pairs(arr,i));
        }
        return optimal_s_val;
    }
    // Time Complexity -: nlogn    Space Complexity -: n
    public static void main(String[] args) throws Exception {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String testcases=br.readLine();
        String num;
        String[] array;
        int tc=Integer.parseInt(testcases);
        int n;
        for(int i=0;i<tc;i++){
            num=br.readLine();
            n=Integer.parseInt(num);
            int arr[]=new int[n];
            array=br.readLine().split(" ");
            for(int j=0;j<n;j++){
                arr[j]=Integer.parseInt(array[j]);
            }
            System.out.println(compute(arr));
        }
    }
}
