package hackerrank.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;



public class minimumTimeRequired {
    static long minTimeOptimized(long[] machines, long goal){
                   TreeMap<Long, ArrayList<Long>> tm=new TreeMap<>();

                   for(int i=0;i<machines.length;i++){
                       ArrayList<Long> l=tm.get(machines[i]);
                       if(l==null){
                           l=new ArrayList<>();
                           l.add(machines[i]);
                           tm.put(machines[i],l);
                       }else{
                           l.add(machines[i]);
                           tm.put(machines[i],l);
                       }
                   }
                   //
                   long count=0,key=-1;
                   while(count!=goal){
                           key=tm.firstEntry().getKey();
                           ArrayList<Long> val=tm.firstEntry().getValue();
                           count+=val.size();
                           tm.remove(key);
                           for(int i=0;i<val.size();i++){
                               ArrayList<Long> l = tm.get(key+val.get(i));
                               if(l==null){
                                   l=new ArrayList<>();
                                   l.add(val.get(i));
                                   tm.put(key+val.get(i),l);
                               }else{
                                   l.add(val.get(i));
                                   tm.put(key+val.get(i),l);
                               }
                           }
                   }
                   return key;
    }
    ////  TC O(goal*no_of_machines) SC O(N)
    static long minTime(long[] machines, long goal){
                    //Arrays.sort(machines);
                    long[] copy=new long[machines.length];
                    for(int i=0;i<machines.length;i++)
                        copy[i]=machines[i];
                    int count=0;

                    long min=0;
                    while(count!=goal){
                        min=Integer.MAX_VALUE;
                        for(int i=0;i<machines.length;i++){
                            if(min>machines[i])
                                min=machines[i];
                        }
                        for(int i=0;i<machines.length;i++){
                            if(machines[i]==min){
                                machines[i]+=copy[i];
                                count=count+1;
                            }
                        }
                    }
                    return min;
    }

    public static void main(String[] args) {
        System.out.println(minTimeOptimized(new long[]{4,5,6},12));
        System.out.println(minTimeOptimized(new long[]{1,3,4},10));
    }
}
