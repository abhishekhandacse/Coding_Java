package hackerrank.medium;

import java.util.Stack;

public class BalancedBrackets {
    static String isBalanced(String s) {
        Stack<Character> st=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(' || s.charAt(i)=='{' || s.charAt(i)=='[' )
                st.push(s.charAt(i));
            else if(s.charAt(i)==')'){
                if(st.size()!=0){
                    Character c=st.pop();
                    if(c!='('){
                        return "NO";
                    }
                }else return "NO";
            }else if(s.charAt(i)=='}'){
                if(st.size()!=0){
                    Character c=st.pop();
                    if(c!='{'){
                        return "NO";
                    }
                }else return "NO";
            }else if(s.charAt(i)==']'){
                if(st.size()!=0){
                    Character c=st.pop();
                    if(c!='['){
                        return "NO";
                    }
                }else return "NO";
            }else{
                //Invalid character as per problem statement
            }
        }
        if(st.size()==0)return "YES";
        else return "NO";
    }
}
