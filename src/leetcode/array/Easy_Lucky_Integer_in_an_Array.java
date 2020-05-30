package leetcode.array;

public class Easy_Lucky_Integer_in_an_Array {
    public int findLucky(int[] arr) {
                int[] hm=new int[501];
                int lucky=-1;
                for(int i:arr){
                    hm[i]+=1;
                }
                for(int i=500;i>=0;i--){
                    if(hm[i]!=0  && hm[i]==i)return i;
                }
                return -1;
    }
}
