package codeforces.div3_656;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
 
 

public class A{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);    
        String testcases = br.readLine();
        int TC = Integer.parseInt(testcases);
        for (int tc = 0; tc < TC; tc++){
            String[] line = br.readLine().split(" ");// Use string tokenizer less time
            int a,b,c;
            a=Integer.parseInt(line[0]);
            b=Integer.parseInt(line[1]);
            c=Integer.parseInt(line[2]);
            if(a!=b  && b!=c  && a!=c){
                writer.println("NO");
            }else if(a==b && b==c && a==c){
                writer.println("YES");
                writer.println(a+" "+a+" "+a);
            }else if( (a==b && a>c && c!=0)||(b==c && b>a && a!=0) ||(c==a && c>b && b!=0 )){
                writer.println("YES");
                if(a==b){
                    writer.println(a+" "+(c)+" "+(c) );
                }else if(b==c){
                    writer.println(b+" "+(a)+" "+(a) );                    
                }else if(a==c){
                    writer.println(a+" "+(b)+" "+(b) );
                }
            }else{
                 writer.println("NO");
            }
        }
        writer.flush();
        //writer.close();
    }
}