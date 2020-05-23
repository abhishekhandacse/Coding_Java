package leetcode.dp;

public class Medium_Palindromic_Substrings {
    // Time Complexity O(Len^2) Space Complexity   O(N^2)
    public int countSubstrings(final String str) {
                // Base cases
                if(str==null || str.length()==0)return 0;
                if(str.length()==1)return 1;
                boolean[][] isPalindrome=new boolean[str.length()][str.length()];
                int answer=0;    // Adding the cases corresponding to each single character
                int i=0,j=0;    // Moving from the principal diagonal to the each diagonal parallel to it

                while ( (i<str.length()) && (j<str.length()) ){

                    for(int row=i,col=j;  ((row<str.length()) && (col<str.length())) ;row++,col++){
                        if(row==col) {  // Corresponds to single individual character scenario
                            isPalindrome[row][col] = true;
                        }else{
                            if(str.charAt(row)==str.charAt(col)){
                                if( (row+1)>(col-1) ){// Corresponds to all substrings with len 2
                                    isPalindrome[row][col]=true;    // Implies they are palindrome
                                }else{
                                    if(isPalindrome[row+1][col-1]==true){
                                        isPalindrome[row][col]=true;
                                    }
                                }
                            }
                        }
                        if(isPalindrome[row][col]==true)
                            answer++;
                    }
                    j++;    // Moving to the next diagnol parallel to  principal diagonal each time
                }

                return answer;

    }
/*
*   Another solution which is sligtly better than above solution is brute force actually (Sounds strange right)
*   Let me give you explanation
*   we can stand at each index and compute all the pallindromes of odd len and even length and add the both
*   Its time Complexity is O(N^2) and space Complexity is O(1)
*
*   **** However the most optimized solution in this scenario is Manachers Algorithm which I will add soon  *** TC (O(N)) SC (O(N))
* */
    public static void main(String[] args) {
        Medium_Palindromic_Substrings obj=new Medium_Palindromic_Substrings();

        System.out.println(obj.countSubstrings("abcba"));//7
        System.out.println(obj.countSubstrings("aaaaa"));//15
        System.out.println(obj.countSubstrings("bab"));//4
        System.out.println(obj.countSubstrings("bbabb"));//9


    }
}
