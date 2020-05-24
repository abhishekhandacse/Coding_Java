package leetcode.dp;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class Medium_LongestStringChain {


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

        int[] Aux=new int[words.length];
        for(int i=0;i<Aux.length;i++)
            Aux[i]=1;

        int max=1;
        Arrays.sort(words, (a, b)->a.length() - b.length()); // Sorted the strings length wise // The question misses to mention that the longest chain could be found in any order
        for(int i=0;i<words.length-1;i++){
            for(int j=i+1;j<words.length;j++){
                if(isPrefix(words[i],words[j])){
                    Aux[j]=Math.max(Aux[j],Aux[i]+1);
                    if(max<Aux[j])
                        max=Aux[j];
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        Medium_LongestStringChain obj=new Medium_LongestStringChain();
        System.out.println(obj.longestStrChain(new String[]{
                "ab","bc","abc","abcd"
        }));//3
        System.out.println(obj.longestStrChain(new String[]{
                "a","b","ba","bca","bda","bdca"
        }));//4
        System.out.println(obj.longestStrChain(new String[]{
                "ksqvsyq","ks","kss","czvh","zczpzvdhx","zczpzvh","zczpzvhx","zcpzvh","zczvh","gr","grukmj","ksqvsq","gruj","kssq","ksqsq","grukkmj","grukj","zczpzfvdhx","gru"
        }));//7

    }
}
