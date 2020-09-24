package codeforces.div3_667;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;


public class A_Yet_Another_Two_Integer_Problem {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String testcases = br.readLine();
        int tc = Integer.parseInt(testcases);
        for (int i = 0; i < tc; i++) {
            String[] line = br.readLine().split(" ");// Use string tokenizer less time
            int a=Integer.parseInt(line[0]);
            int b=Integer.parseInt(line[1]);
            if(a>b){
                int temp=a;
                a=b;
                b=temp;
            }
            int q=(b-a)/10;
            int r=(b-a)%10;
            if(r!=0)
                q=q+1;
            pw.println(q);
        }
        pw.close();
    }
}
