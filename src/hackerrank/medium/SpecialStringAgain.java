package hackerrank.medium;

public class SpecialStringAgain {
    // Complete the substrCount function below.
    // TC O(N^2) SC O(N)  ===> Good Question Hackerrank Medium
    static long substrCount(int n, String s) {

        if(n==1)return 1;
        long count = 0;
        // Case 1 (Dealing with consecutive and same)
        int consecutive=0;
        int non_consecutive=0;
        int state=0;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)==s.charAt(i-1)){
                consecutive=consecutive+1;
                state=2;
            }else{
                if(consecutive!=0){
                    count += ((consecutive + 1) * (consecutive + 2) / 2);
                    consecutive = 0;
                }else{
                    non_consecutive=non_consecutive+1;
                }
                state=1;
            }
        }
        if(consecutive!=0)
            count+=((consecutive+1)*(consecutive+2)/2);
        if(state==1)
            non_consecutive=non_consecutive+1;
        count+=non_consecutive;


        // Case 2 (Dealing with centre different, rest same)
            // Consider i as centre
            for(int i=1;i<n-1;i++){
                if(n<3)break;
                int left_pointer=i-1,right_pointer=i+1,offset=1;
                char copy=s.charAt(i+1);
                char center=s.charAt(i);
                char left,right;
                while(left_pointer>=0 && (right_pointer<=(n-1)) ){
                    left=s.charAt(left_pointer);
                    right=s.charAt(right_pointer);
                    if(center!=copy && left==right && left==copy ){
                        count=count+1;
                        offset=offset+1;
                        left_pointer=i-offset;
                        right_pointer=i+offset;
                    }else break;
                }
            }
            return count;
    }

    public static void main(String[] args) {
                System.out.println(substrCount(3,"aba"));//4
                System.out.println(substrCount(3,"aaa"));//6
                System.out.println(substrCount(3,"aac"));//4
                System.out.println(substrCount(3,"caa"));//4
//              System.out.println(substrCount(4,"aaab"));//7
//              System.out.println(substrCount(4,"adda"));//5
//              System.out.println(substrCount(5,"asasd"));//7
//              System.out.println(substrCount(7,"abcbaba"));//10
//              System.out.println(substrCount(4,"aaaa"));//10
    }

}
