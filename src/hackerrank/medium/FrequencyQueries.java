package hackerrank.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FrequencyQueries{
    // TC O(1) On An Average    // SC O(N) for HashMaps

    static List<Integer> freqQuery(List<List<Integer>> queries) {
                HashMap<Integer,Integer> hm1=new HashMap<>();
                HashMap<Integer,Integer> hm2=new HashMap<>();
                Object obj1,obj2,obj3;
                List<Integer> ans= new ArrayList<>();
                int freq;
                for(int i=0;i<queries.size();i++){
                    int X=queries.get(i).get(0);
                    int Y=queries.get(i).get(1);

                    switch (X){
                        case 1://Insert
                            freq=0;
                            obj1=hm1.get(Y);
                            if(obj1==null){
                                hm1.put(Y,1);
                                freq=1;
                                obj2=hm2.get(freq);
                                if(obj2==null){
                                    hm2.put(freq,1);
                                }else{
                                    hm2.put(freq,(Integer)obj2+1);
                                }
                            }else{
                                hm1.put(Y,(Integer)obj1 +1);
                                freq=(Integer)obj1 +1;
                                obj2=hm2.get(freq);
                                if(obj2==null){
                                    hm2.put(freq,1);
                                    obj3=hm2.get(freq-1);
                                    if(obj3==null){

                                    }else if((Integer)obj3==1){
                                        hm2.remove(freq-1);
                                    }else{
                                        hm2.put(freq-1,(Integer)obj3-1);
                                    }
                                }else {
                                    hm2.put(freq, (Integer)obj2+1);
                                    obj3=hm2.get(freq-1);
                                    if(obj3==null){

                                    }else if((Integer)obj3==1){
                                        hm2.remove(freq-1);
                                    }else{
                                        hm2.put(freq-1,(Integer)obj3-1);
                                    }
                                }
                            }
                            break;
                        case 2://Delete
                            freq=0;
                            obj1=hm1.get(Y);
                            if(obj1==null){
                                //Item does not exist in hm1 and hence can be deleted :)
                            }else{
                                freq=(Integer)obj1;
                                if(freq==1){
                                    hm1.remove(Y);
                                    obj2=hm2.get(freq);
                                    if(obj2==null){}
                                    else if((Integer)obj2==1){
                                        hm2.remove(freq);
                                    }else{
                                        hm2.put(freq,(Integer)obj2-1);
                                    }
                                }else{
                                    hm1.put(Y,freq-1);
                                    obj2=hm2.get(freq);
                                    if(obj2==null){}
                                    else if((Integer)obj2==1){
                                        hm2.remove(freq);
                                        obj3=hm2.get(freq-1);
                                        if(obj3==null){
                                            hm2.put(freq-1,1);
                                        }else{
                                            hm2.put(freq-1, (Integer)obj3+1);
                                        }
                                    }else{
                                        hm2.put(freq,(Integer)obj2-1);
                                        obj3=hm2.get(freq-1);
                                        if(obj3==null){
                                            hm2.put(freq-1,1);
                                        }else{
                                            hm2.put(freq-1, (Integer)obj3+1);
                                        }
                                    }
                                }
                            }
                            break;
                        case 3://Check
                            if(hm2.get(Y)!=null)
                                ans.add(1);
                            else ans.add(0);
                            break;
                    }
                }
                return ans;
    }
}
