package hackerrank.medium;

import java.util.HashMap;

public class SparseArrays {
    int[] matchingStrings(String[] strings, String[] queries) {
        HashMap<String,Integer> hm=new HashMap<>();
        for(int i=0;i<strings.length;i++){
            Object obj=hm.get(strings[i]);
            if(obj==null){
                hm.put(strings[i],1);
            }else{
                int count=(int)obj;
                count++;
                hm.remove(strings[i]);
                hm.put(strings[i],count);
            }
        }
        int arr[]=new int[queries.length];
        for(int i=0;i<queries.length;i++){
            Object obj=hm.get(queries[i]);
            if(obj!=null)
                arr[i]=(int)obj;
        }
        return arr;
    }

}
