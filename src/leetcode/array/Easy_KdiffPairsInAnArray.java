package leetcode.array;

import java.util.*;

public class Easy_KdiffPairsInAnArray{

    int findPairs(int[] arr, int k){

        HashMap<Integer,Integer> hm=new HashMap<>();
        for(Integer i:arr){
            Object obj=hm.get(i);
            if(obj==null){
                hm.put(i,1);
            }else{
                hm.put(i,(Integer)obj + 1);
            }
        }
        int count=0;
        for(Map.Entry<Integer,Integer> it:hm.entrySet()){
            if(k==0){
                int val= hm.get(it.getKey());
                if(val>1)
                    count+=1;
            }else if(hm.get(it.getKey()+k)!=null){
                count+=1;
            }
        }

        return count;
    }

    public static void main(String[] args){
        Easy_KdiffPairsInAnArray obj=new Easy_KdiffPairsInAnArray();
        System.out.println(obj.findPairs(new int[]{3,1,4,1,5},2));//2
        System.out.println(obj.findPairs(new int[]{1,2,3,4,5},1));//4
        System.out.println(obj.findPairs(new int[]{1,3,1,5,4},0));//1
        System.out.println(obj.findPairs(new int[]{1,2,3,4,5},1));//4
    }
}
