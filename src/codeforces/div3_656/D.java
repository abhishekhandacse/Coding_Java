package codeforces.div3_656;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
 
 
// TC O(NlogN) Similer to merge sort  2T(N/2) + O(N)   === O(NlogN) master theorem result
public class D{
    static int aGoodStringRecursive(String str,int low,int high,int c){
        if(low>high)return 0;
        if( high == low ){
            if( (int)str.charAt(low) == ('a' + c) ){
                return 0;
            }else return 1;
        }
        // Making left half c good and 
        int mid=low+(high-low)/2;
        int edits=0;
        for(int i=low;i<=mid;i++)
            if( (int)str.charAt(i)!='a'+c)
                edits+=1;

        int leftEdit=  edits + aGoodStringRecursive(str,mid+1,high,c+1);

        // Making right half c good 
        edits=0;
        for(int i=mid+1;i<=high;i++)
            if( (int)str.charAt(i)!='a'+c)
                edits+=1;


        int rightEdit= edits + aGoodStringRecursive(str,low,mid,c+1);

        return Math.min(leftEdit,rightEdit);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);    
        String testcases = br.readLine();
        int TC = Integer.parseInt(testcases);
        String str;
        for (int tc = 0; tc < TC; tc++){
            int N=Integer.parseInt(br.readLine());
            str=br.readLine();
            pw.println(aGoodStringRecursive(str,0,N-1,0));
        }
        pw.flush(); 
    }
}