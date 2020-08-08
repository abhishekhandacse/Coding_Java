package hackerrank.easy;

import java.util.HashMap;
import java.util.Map;

public class RansomNotes {
    static void checkMagazine(String[] magazine, String[] note) {
        HashMap<String, Integer> hm=new HashMap<>();

        for(int i=0;i<magazine.length;i++){
            Object obj=hm.get(magazine[i]);
            if(obj==null){
                hm.put(magazine[i],1);
            }else{
                int freq=(Integer)obj;
                hm.put(magazine[i], freq+1 );
            }
        }

        HashMap<String, Integer> hm1=new HashMap<>();

        for(int i=0;i<note.length;i++){
            Object obj=hm1.get(note[i]);
            if(obj==null){
                hm1.put(note[i],1);
            }else{
                int freq=(Integer)obj;
                hm1.put(note[i], freq+1 );
            }
        }


        if( hm1.size() > hm.size() ){
            System.out.println("No");
        }else{
            for(Map.Entry me:hm1.entrySet()){
                String Key= (String)me.getKey();
                int Value= (Integer)me.getValue();
                Object obj=hm.get(Key);
                if(obj==null){
                    System.out.println("No");
                    return;
                }
                else{
                    int val=(Integer)obj;
                    if(val<Value){
                        System.out.println("No");
                        return;
                    }
                }
            }
            System.out.println("Yes");
        }
    }
}
