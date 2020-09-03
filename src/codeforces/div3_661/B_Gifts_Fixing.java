package codeforces.div3_661;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B_Gifts_Fixing{
    //TC O(2*N) SC O(1)
    public static long compute(int[] arr1,int[] arr2){
                    int min1=Integer.MAX_VALUE;
                    int min2=Integer.MAX_VALUE;
                    for(int i=0;i<arr1.length;i++){
                        if(min1>arr1[i])
                            min1=arr1[i];
                        if(min2>arr2[i])
                            min2=arr2[i];
                    }
                    int moves1=0,moves2=0;
                    long ans=0;
                    for(int i=0;i<arr1.length;i++){
                        moves1=arr1[i]-min1;
                        moves2=arr2[i]-min2;
                        ans+=Math.max(moves1,moves2);
                    }
                return ans;
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
            int arr1[]=new int[n];
            int arr2[]=new int[n];
            array=br.readLine().split(" ");
            for(int j=0;j<n;j++){
                arr1[j]=Integer.parseInt(array[j]);
            }
            array=br.readLine().split(" ");
            for(int j=0;j<n;j++){
                arr2[j]=Integer.parseInt(array[j]);
            }
            System.out.println(compute(arr1,arr2));
        }
    }
}
