package codeforces.div2_668;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
 
 

public class A{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String testcases = br.readLine();
        int TC = Integer.parseInt(testcases);
        int arr[]=new int[105];
        for (int tc = 0; tc < TC; tc++){
            String[] line = br.readLine().split(" ");// Use string tokenizer less time
            int N=Integer.parseInt(line[0]);
            line=br.readLine().split(" ");
            int j=0;
            for(int i=N-1;i>=0;i--){
                arr[i]=Integer.parseInt(line[j++]);
            }
            for(int i=0;i<N;i++)
                System.out.print(arr[i]+" ");

            System.out.println();
        }
    }
}