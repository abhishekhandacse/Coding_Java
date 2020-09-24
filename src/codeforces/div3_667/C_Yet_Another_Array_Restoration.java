package codeforces.div3_667;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
//TC O(N^2)
public class C_Yet_Another_Array_Restoration {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String testcases = br.readLine();
        int tc = Integer.parseInt(testcases);
        for (int ii = 0; ii < tc; ii++){
            String[] line = br.readLine().split(" ");// Use string tokenizer less time
            final int n, a, b;
            n=Integer.parseInt(line[0]);
            a=Integer.parseInt(line[1]);
            b=Integer.parseInt(line[2]);
            final int d=b-a;
            int[] ans=new int[n];
            int[] copy=new int[n];
            int prev_max=Integer.MAX_VALUE;
            for(int i=d;i>0;i-- ){
                int count=1;
                if( (d%i) == 0 ){
                    int maximum=b;
                    int index=n-1;
                    for(int j=n-1 ; j>=0 ; j--){
                        if( j == n-1 ){
                            ans[j]=b;
                        }else if(count >1 || ans[j+1] - i <= 0 ){
                            ans[j]=ans[n-1] + count*i;
                            maximum=ans[j];
                            count+=1;
                        }else{
                            ans[j]=ans[j+1]-i;
                            index=j;
                        }
                    }
                    if( ans[index]<=a && prev_max > maximum ){
                        for(int j=0;j<n;j++)
                            copy[j]=ans[j];
                        prev_max=maximum;
                    }
                }
            }
            for(int i:copy)
                System.out.print(i+" ");
            System.out.println();
        }
        pw.close();
    }
}
