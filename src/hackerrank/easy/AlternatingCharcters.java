package hackerrank.easy;

public class AlternatingCharcters {
    //TC-: O(N) SC-:O(1)
    static int alternatingCharacters(String s){
                int l=s.length();
                if(l==1)return 0;
                int count1=0,count2=0;
                int prev1=-1,prev2=-1;
                for(int i=0;i<l;i++){
                    if(s.charAt(i)=='A'){
                        if(prev1==-1){
                            prev1=i;
                        }else{
                            if(s.charAt(prev1)=='A')
                                count1++;
                            else
                                prev1=i;
                        }
                    }else{
                        if(prev1==-1){
                            count1++;
                        }else{
                            if(s.charAt(prev1)=='B')
                                count1++;
                            else
                                prev1=i;
                        }

                    }
                }
            for(int i=0;i<l;i++){
                if(s.charAt(i)=='B'){
                    if(prev2==-1){
                        prev2=i;
                    }else{
                        if(s.charAt(prev2)=='B')
                            count2++;
                        else
                            prev2=i;
                    }
                }else{
                    if(prev2==-1){
                        count2++;
                    }else{
                        if(s.charAt(prev2)=='A')
                            count2++;
                        else
                            prev2=i;
                    }

                }
            }
        return Math.min(count1,count2);
    }
    public static void main(String[] args) {
        System.out.println(alternatingCharacters("AAAA"));//3
        System.out.println(alternatingCharacters("BBBB"));//3
        System.out.println(alternatingCharacters("ABAB"));//0
        System.out.println(alternatingCharacters("BABA"));//0
        System.out.println(alternatingCharacters("ABBA"));//1
        System.out.println(alternatingCharacters("BAAB"));//1
    }
}
