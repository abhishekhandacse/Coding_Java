package leetcode.stacks;

import java.util.Stack;

public class Hard_LongestValidParentheses {
    public int longestValidParenthesesdp(String s) {
        int maxans = 0;
        int dp[] = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxans = Math.max(maxans, dp[i]);
            }
        }
        return maxans;
    }


    // Normal stack based solution
        public int longestValidParentheses(String s) {
            // References geeks for geeks

            Stack<Integer> st=new Stack<>();
            st.add(-1);
            int result=0;
            for(int i=0;i<s.length();i++){

                if(s.charAt(i)=='('){
                    st.push(i);
                }else{
                    st.pop();
                    if(st.empty()){
                        st.push(i);
                    }else{
                        result=Math.max(result,i-st.peek());
                    }
                }

            }

            return result;
        }

}
