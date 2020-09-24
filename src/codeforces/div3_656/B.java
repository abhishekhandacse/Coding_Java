package codeforces.div3_656;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
 
 

public class B{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);    
        String testcases = br.readLine();
        int TC = Integer.parseInt(testcases);
        Set<Integer> st=new HashSet<>();
        for (int tc = 0; tc < TC; tc++){
            st.clear();
            String[] line = br.readLine().split(" ");// Use string tokenizer less time
            int len=Integer.parseInt(line[0]);
            line=br.readLine().split(" ");
            for(int i=0;i<2*len;i++){
                int d=Integer.parseInt(line[i]);
                if(st.contains(d)==false){
                    st.add(d);
                    pw.print(d+" ");
                }
            }   
            pw.println();
            pw.flush();
        }
        
    }
}