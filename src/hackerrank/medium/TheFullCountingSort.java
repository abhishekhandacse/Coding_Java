package hackerrank.medium;

import java.io.BufferedOutputStream;
import java.io.Console;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TheFullCountingSort {
//    TC -: O(N)    SC -: O(100)
    static void countSort(List<List<String>> arr){
        // Inplace implementation
        StringBuilder[] aux=new StringBuilder[100];

        int counter=0;

        int size=arr.size();
        for(List<String> iter:arr){
            StringBuilder temp=new StringBuilder();
            String x=iter.get(0);
            String y=iter.get(1);
            int index=Integer.parseInt(x);

            if(counter < size/2){
                temp.append("- ");
            }else{
                temp.append(y+" ");
            }

            if(aux[index]==null)
                aux[index]=temp;
            else
                aux[index]=aux[index].append(temp);
            counter++;
        }
        StringBuilder ans=new StringBuilder();
        for(StringBuilder iter:aux){
            if(iter!=null)
                ans.append(iter);
        }
        System.out.println(ans.toString());
    }

    public static void main(String[] args) {
        List<List<String>> l=new ArrayList<>();

        l.add(new ArrayList<>(){{
            add("0");
            add("a");
        }  });

        l.add(new ArrayList<>(){{
            add("1");
            add("b");
        }  });

        l.add(new ArrayList<>(){{
            add("0");
            add("c");
        }  });

        l.add(new ArrayList<>(){{
            add("1");
            add("d");
        }  });
        countSort(l);
    }
}
