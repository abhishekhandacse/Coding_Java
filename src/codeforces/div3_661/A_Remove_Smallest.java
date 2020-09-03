package codeforces.div3_661;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class A_Remove_Smallest {

    //TC O(NLOGN) SC O(N)
    public static String compute(int[] arr){
        if(arr.length==1)return "YES";
        Arrays.sort(arr);// this is worst case n^2 use ruffle sort
        for(int i=0;i<arr.length-1;i++){
            if(arr[i+1]-arr[i]>1)return "NO";
        }
        return "YES";
    }

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
