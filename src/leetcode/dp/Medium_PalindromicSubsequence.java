package leetcode.dp;

import java.util.HashMap;

public class Medium_PalindromicSubsequence {
    // Naive Recursion Solution --> Passes 61/83 test cases
    // Time Compleixty -: Exponential
/*    private boolean isPalindrome(String str){
        if(str==null ||str.length()==0 )return false;
        if( str.length()==1)return true;
        int beg=0,end=str.length()-1;
        while (beg<end){
            if(str.charAt(beg)!=str.charAt(end)){
                return false;
            }
            beg++;
            end--;
        }
        return true;
    }
    private int lPSubseqAux(String str,int i,String subseq){
            if(i==str.length()){
                if(isPalindrome(subseq)){
                    return subseq.length();
                }
                return 0;
            }
        //  Inclusion
            int incl=lPSubseqAux(str,i+1,subseq+str.charAt(i));
        //  Exclusion
            int excl=lPSubseqAux(str,i+1,subseq);
            return Math.max(incl,excl);
    }
    public int longestPalindromeSubseq(String s) {
            return lPSubseqAux(s,0,"");

    }*/

    private boolean isPalindrome(String str){
        if(str==null ||str.length()==0 )return false;
        if( str.length()==1)return true;
        int beg=0,end=str.length()-1;
        while (beg<end){
            if(str.charAt(beg)!=str.charAt(end)){
                return false;
            }
            beg++;
            end--;
        }
        return true;
    }
    private int lPSubseqAux(String str,int i,String subseq,HashMap<String,Integer> hm){
        if(i==str.length()){
            if(isPalindrome(subseq)){
                if(hm.containsKey(subseq))
                    return hm.get(subseq);
                int len=subseq.length();
                hm.put(subseq,len);
                return len;
            }
            return 0;
        }

        //  Inclusion
        int incl=lPSubseqAux(str,i+1,subseq+str.charAt(i),hm);

        //  Exclusion
        int excl=lPSubseqAux(str,i+1,subseq,hm);

        int len= Math.max(incl,excl);
        hm.put(subseq,len);
        return len;
    }
    public int longestPalindromeSubseq(String s) {
        HashMap<String,Integer> Memo=new HashMap<>();
        return lPSubseqAux(s,0,"",Memo);
    }
    //// I was unable to find overlapping sub-problem so I think doing memoization wont do any benefit on the above naive recursive solution
/*
    // Time Complexity -: O(N^2)    Space Complexity  -: O(1)       //// this below solution is not related with this leet code problem
    public int longestPalindromeSubstring(String s) {
                if(s==null || s.length()==0)return 0;
                int max_len=1;
                // Checking odd palindromes
                int max_odd_len=1,max_even_len=1;
                for(int center=1;center<s.length()-1;center++){
                    int left_search=center-1,right_search=center+1;
                    int local_odd_max=1;
                    while (left_search>=0 && right_search<s.length()){
                        if(s.charAt(left_search)==s.charAt(right_search)){
                            local_odd_max+=2;
                        }else{
                            break;
                        }
                        left_search--;
                        right_search++;
                    }
                    max_odd_len=Math.max(max_odd_len,local_odd_max);
                }
                // Checking even palindromes
                for(int center=1;center<s.length()-1;center++){
                    int left_search=center-1,right_search=center;
                    int local_even_max=0;
                    while (left_search>=0 && right_search<s.length()){
                        if(s.charAt(left_search)==s.charAt(right_search)){
                            local_even_max+=2;
                        }else{
                            break;
                        }
                        left_search--;
                        right_search++;
                    }
                    max_even_len=Math.max(max_even_len,local_even_max);
                }
                return Math.max(max_odd_len,max_even_len);
    }*/

    public static void main(String[] args) {
        Medium_PalindromicSubsequence obj=new Medium_PalindromicSubsequence();

        System.out.println(obj.longestPalindromeSubseq("bbbab"));//4
        System.out.println(obj.longestPalindromeSubseq("cbbd"));//2
        System.out.println(obj.longestPalindromeSubseq("abcd"));//1
        System.out.println(obj.longestPalindromeSubseq("abbba"));//5
        System.out.println(obj.longestPalindromeSubseq("aabbb"));//3
    }
}
