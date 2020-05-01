package LeetCode.dp;

public class Easy_IsSubsequence {
    /*
    //BruteForceSolution
    // TC O( |S| + |T|   )
    // SC O(1)
    public boolean isSubsequence(String s, String t) {
            int len_s=s.length();
            int len_t=t.length();

            if(len_s>len_t)return false;        // Can never be matched

            int i=0,j=0;

            while(i<len_s && j<len_t){
                if(s.charAt(i)==t.charAt(j)){
                    i++;
                    j++;
                }else{
                    j++;
                }
            }
            if(i==len_s)return true;
            return false;
    }
*/

    // Follow up solution
    static final int SIZE=26;          // this is the ascii range of vocablery I am considering although in this case 128 would also work
            // this would return index of the possible element just > index of lb // for unsuccessful search, this would return Integer.min
            int binary_search(final int[] arr,final int len,final int lb){

                if(arr==null || len<1)return Integer.MIN_VALUE;

                int low=0,high=len-1,mid;

                while(low<=high){   // basic binary search like loop
                    mid=low + (high-low)/2;
                    if(arr[mid]==lb){   // base case
                        if(mid<(len-1)){
                            return arr[mid+1];
                        }else{
                            return Integer.MIN_VALUE;
                        }
                    }
                    if(arr[mid]<lb)low=mid+1;
                    else high=mid-1;
                }

                if(low>(len-1) )         // low is already pointing to largest element of the current array and larger than this is not possible
                    return Integer.MIN_VALUE;// No suitable index can be found

                if(high<0){                     //  high is trying to find an element which is even less than smallest element of the array just return smallest element
                    return arr[0];// 0 index would be correct answer in this case
                }

                if(arr[high]<lb  && lb<arr[low])
                    return low;     // In case of unsuccessful in while loop, low would normally point to required index since high < low

                return Integer.MIN_VALUE;// This would not occur in sorted array

            }


    public boolean isSubsequence(final String s, final String t) {
            final int s_len=s.length();
            final int t_len=t.length();
            if(s_len>t_len)return false;

            int[][] lookup=new int[SIZE][t_len];     // worst case would occur like when t is aaaaaaaaaaaaa
            int[] indexes=new int[SIZE];

            // Preprocessing the String t
            for(int i=0;i<t_len;i++){
                int ascii=(int)t.charAt(i)-97;
                int index=indexes[ascii];
                lookup[ascii][index]=i;
                index++;
                indexes[ascii]=index;
            }

            // Now Iterating through s string and finding index of element > prev if possible
            int prev=-1;// Any index > than prev would work

            for(int i=0;i<s_len;i++){
                int ascii=(int)s.charAt(i)-97;
                int probable_index=binary_search(lookup[ascii],indexes[ascii],prev);
                System.out.println(probable_index);
                if(probable_index==Integer.MIN_VALUE){
                    // was unable to find index corresponding to this character
                    return false;   // Search unsuccessful
                }else{
                    prev=probable_index;
                }
            }

            return true;

    }






    // Some basic unit testing
    public static void main(String[] args) {
        Easy_IsSubsequence obj=new Easy_IsSubsequence();
        /*System.out.println(obj.isSubsequence("abc","abcdef"));  //true
        System.out.println(obj.isSubsequence("abz","abcdef"));  //false
        System.out.println(obj.isSubsequence("abf","abcdef"));  //true
        System.out.println(obj.isSubsequence("abc","bahbgdca"));  //true
        System.out.println(obj.isSubsequence("acb","ahbgdc"));  //false*/

        System.out.println(obj.isSubsequence("leeeeetcode","leeetcodeyy"));  //false


    }
}
