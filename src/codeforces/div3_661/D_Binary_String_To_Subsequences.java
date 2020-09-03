package codeforces.div3_661;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class D_Binary_String_To_Subsequences{

    //TC O(N) SC O(N)
    public static void compute(String str){
            Stack<Integer> zs = new Stack<>();//zeros
            Stack<Integer> os = new Stack<>();//ones
            int length=str.length();
            int[] ans=new int[length];
            int piles=0;
            for(int i=0;i<length;i++){
                Character c = str.charAt(i);

                if(c=='0'){
                    if(os.size()==0){
                        piles+=1;
                        zs.push(piles);
                        ans[i]=piles;
                    }else{
                        int popped_pile=os.pop();
                        zs.push(popped_pile);
                        ans[i]=popped_pile;
                    }
                }else{
                    if(zs.size()==0){
                        piles+=1;
                        os.push(piles);
                        ans[i]=piles;
                    }else{
                        int popped_pile=zs.pop();
                        os.push(popped_pile);
                        ans[i]=popped_pile;
                    }
                }
            }
        System.out.println(piles);
        for(int i:ans)
            System.out.print(i+" ");
        System.out.println();


    }

    public static void main(String[] args)  {
        try{
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            String testcases=br.readLine();
            int tc=Integer.parseInt(testcases);
            String num;
            String array;
            int n;
            for(int i=0;i<tc;i++){
                num=br.readLine();
                //n=Integer.parseInt(num);
                array=br.readLine();
                compute(array);
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
