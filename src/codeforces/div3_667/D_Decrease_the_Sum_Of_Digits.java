package codeforces.div3_667;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class D_Decrease_the_Sum_Of_Digits {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String testcases = br.readLine();
        int tc = Integer.parseInt(testcases);
        for (int ii = 0; ii < tc; ii++){
            String[] line = br.readLine().split(" ");// Use string tokenizer less time
            long n;
            final int s;
            n=Long.parseLong(line[0]);
            s=Integer.parseInt(line[1]);
            String str=Long.toString(n);
            int sum=0,i;
            int totalSum=0;
            for(i=0;i<str.length();i++){
                totalSum+=str.charAt(i)-'0';
            }
            if(totalSum<=s){
                System.out.println(0);
                continue;
            }
            for(i=0;i<str.length();i++){
                sum+=str.charAt(i)-'0';
                if(sum>=s){
                    i--;
                    break;
                }
            }
            String ans="";
            boolean first=true;
            for(int j=str.length()-1;j>i;j--){
                if(first && str.charAt(j)=='0'){
                    ans="0"+ans;
                }else if ( first ){
                    ans=  (char)(10-(str.charAt(j)-'0') + 48)  + ans;
                    first=false;
                }else{
                    ans = (char)(9-(str.charAt(j)-'0') + 48) + ans;
                    first = false;
                }
            }
            //remove leading zeros
            first=true;
            for(int j=0;j<ans.length();j++){
                if(first==true && ans.charAt(j)=='0'){
                    //System.out.print(ans.charAt(j));
                }else{
                    System.out.print(ans.charAt(j));
                    first=false;
                }
            }
            System.out.println();
        }
    }
}