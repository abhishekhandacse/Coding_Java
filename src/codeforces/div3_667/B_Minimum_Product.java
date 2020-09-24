package codeforces.div3_667;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class B_Minimum_Product {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String testcases = br.readLine();
        int tc = Integer.parseInt(testcases);
        for (int i = 0; i < tc; i++) {
            String[] line = br.readLine().split(" ");// Use string tokenizer less time
            int a=Integer.parseInt(line[0]);
            int b=Integer.parseInt(line[1]);
            int x=Integer.parseInt(line[2]);
            int y=Integer.parseInt(line[3]);
            int n=Integer.parseInt(line[4]);
            int n1=a-x;
            int n2=b-y;
            long ans1=0,ans2=0;
            if(n>(n1+n2))
                n=n1+n2;
            //Case 1 Start from x
            int acopy=a,bcopy=b;
            if(n1>=n){
                acopy=a-n;
            }else{
                acopy=a-n1;
                bcopy=b-(n-n1);
            }
            ans1=(long)acopy*(long)bcopy;
            //Case 2 Start from y
            acopy=a;bcopy=b;
            if(n2>=n){
                bcopy=b-n;
            }else{
                bcopy=b-n2;
                acopy=a-(n-n2);
            }
            ans2=(long)acopy*(long)bcopy;
            //Minimum of both cases should be ans;
            pw.println(Math.min(ans1,ans2));
        }
        pw.close();
    }
}
