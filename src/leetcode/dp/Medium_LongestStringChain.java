package leetcode.dp;




import org.w3c.dom.ls.LSOutput;

import java.util.HashMap;
import java.util.HashSet;

public class Medium_LongestStringChain {

    void print(int[][] arr){
        System.out.println(); System.out.println();
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                System.out.print(arr[i][j]+ "  " );
            }
            System.out.println();
        }

        System.out.println(); System.out.println();

    }
    private boolean isPrefix(String first,String second){
        if((second.length()-first.length())!=1)return false;

        int[] hm=new int[26];
        for(int i=0;i<second.length();i++){
            hm[(int)second.charAt(i)-'a']+=1;
        }
        for(int i=0;i<first.length();i++){
            int ascii=(int)first.charAt(i)-'a';
            if(hm[ascii]==0)return false;
            else{
                hm[ascii]-=1;
            }
        }
        return true;
    }
    public int longestStrChain(String[] words) {

        int[][] DP=new int[words.length+1][words.length+1];

        for(int i=0;i<words.length+1;i++){

            for(int j=0;j<words.length+1;j++){
                if(j==0){
                    DP[i][j]=0;
                    continue;
                }
                if(i==0){
                    DP[i][j]=1;
                    continue;
                }
                if(i==j){
                    DP[i][j]=1;
                    continue;
                }
                if(isPrefix(words[i-1],words[j-1])){
                    DP[i][j]=DP[i-1][j-1]+1;
                }else{
                    DP[i][j]=Math.max(DP[i-1][j],DP[i][j-1]);
                }


            }

        }
        //print(DP);
        return DP[words.length-1][words.length];
    }

    public static void main(String[] args) {
        Medium_LongestStringChain obj=new Medium_LongestStringChain();
        System.out.println(obj.longestStrChain(new String[]{
                "ab","bc","abc","abcd"
        }));//3
        System.out.println(obj.longestStrChain(new String[]{
                "a","b","ba","bca","bda","bdca"
        }));//4

    }
}
