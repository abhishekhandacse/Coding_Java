package codeforces.div2_668;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
 
 

public class B{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);    
        String testcases = br.readLine();
        int TC = Integer.parseInt(testcases);
        for (int tc = 0; tc < TC; tc++){
            String[] line = br.readLine().split(" ");// Use string tokenizer less time
            int N=Integer.parseInt(line[0]);
            line=br.readLine().split(" ");
            long answer=0;
            long prefix_sum=0;
            for(int i=0;i<N;i++){
                prefix_sum+=Integer.parseInt(line[i]);
                answer=Math.min(answer,prefix_sum);
            }
            
            writer.println(-answer);//Math.abs is expensive then simple multiplication with -1
        }
        writer.flush();
        //writer.close();
    }
}