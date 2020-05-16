package LeetCode.stacks;
import java.util.ArrayList;
import java.util.List;
public class Medium_CircularPermutationInBinaryRepresentation {
    public static void main(String[] args) {
        Solution1 sol = new Solution1();
        System.out.println(sol.circularPermutation(3, 2));
//        System.out.println(sol.circularPermutation(2, 1));
//        System.out.println(sol.circularPermutation(3, 2));
    }
}


/*class Solution1 {
            int ParseStringtoInt(String str){
                int ans=0;
                int mult=1;
                for(int i=str.length()-1;i>=0;i--){
                    ans+=(str.charAt(i)-'0')*mult;
                    mult=mult*2;
                }
                return ans;
            }
    public List<Integer> circularPermutation(int n, int start) {
        List<Integer> ans=new ArrayList<>();
        if(n==1){
            if(start==0){
                ans.add(0);
                ans.add(1);
            }else{
                ans.add(1);
                ans.add(0);
            }
            return ans;
        }
        ArrayList<String> obj=new ArrayList<>();
        obj.add("0");
        obj.add("1");
        int size=(int)Math.pow((double)2,(double)n);
        int objsize=2;
        int indexofstart=0;
        while(objsize<size){
            int i=objsize-1;
            while(i>=0){
                obj.add("1"+obj.get(i));
                obj.set(i,"0"+obj.get(i));
                i--;
            }
            objsize+=objsize;
        }
        for(int i=0;i<obj.size();i++){
            if(ParseStringtoInt(obj.get(i))==start){
                indexofstart=i;
                break;
            }
        }
        for(int i=0;i<size;i++){
            ans.add(  ParseStringtoInt( obj.get( (indexofstart%size) )  )  );
            indexofstart++;
        }
        return ans;
    }
}*/

//Cache Optimization using static

/*
class Solution1 {
    static ArrayList<String> obj=new ArrayList<>(){{
        add("0");
        add("1");
    }};
    int ParseStringtoInt(String str){
        int ans=0;
        int mult=1;
        for(int i=str.length()-1;i>=0;i--){
            ans+=(str.charAt(i)-'0')*mult;
            mult=mult*2;
        }
        return ans;
    }
    public List<Integer> circularPermutation(int n, int start) {
        List<Integer> ans=new ArrayList<>();
        if(n==1){
            if(start==0){
                ans.add(0);
                ans.add(1);
            }else{
                ans.add(1);
                ans.add(0);
            }
            return ans;
        }
        int size=(int)Math.pow((double)2,(double)n);
        int objsize=obj.size();
        int indexofstart=0;
        while(objsize<size){
            int i=objsize-1;
            while(i>=0){
                obj.add("1"+obj.get(i));
                obj.set(i,"0"+obj.get(i));
                i--;
            }
            objsize+=objsize;
        }
        for(int i=0;i<size;i++){
            if(ParseStringtoInt(obj.get(i))==start){
                indexofstart=i;
                break;
            }
        }
        for(int i=0;i<size;i++){
            ans.add(  ParseStringtoInt( obj.get( (indexofstart%size) )  )  );
            indexofstart++;
        }
        return ans;
    }
}*/

// Further Optimization by Making another class
/*
class Myclass{
    String str;
    int val;
    Myclass(String str,int val){
        this.str=str;
        this.val=val;
    }
}
class Solution1 {
    static ArrayList<Myclass> obj=new ArrayList<Myclass>(){{
            add(new Myclass("0",0));
            add(new Myclass("1",1));
    }};
    int ParseStringtoInt(String str){
        int ans=0;
        int mult=1;
        for(int i=str.length()-1;i>=0;i--){
            ans+=(str.charAt(i)-'0')*mult;
            mult=mult*2;
        }
        return ans;
    }
    public List<Integer> circularPermutation(int n, int start) {
        List<Integer> ans=new ArrayList<>();
        if(n==1){
            if(start==0){
                ans.add(0);
                ans.add(1);
            }else{
                ans.add(1);
                ans.add(0);
            }
            return ans;
        }
        int size=(int)Math.pow((double)2,(double)n);
        int objsize=obj.size();
        int indexofstart=0;
        while(objsize<size){
            int i=objsize-1;
            while(i>=0){
               obj.add(new Myclass("1"+obj.get(i).str,ParseStringtoInt("1"+obj.get(i).str) ) );
               obj.set(i,new Myclass("0"+obj.get(i).str,obj.get(i).val ));
                i--;
            }
            objsize+=objsize;
        }
        for(int i=0;i<size;i++){
            if(obj.get(i).val==start){
                indexofstart=i;
                break;
            }
        }
        for(int i=0;i<size;i++){
//            ans.add(  ParseStringtoInt( obj.get( (indexofstart%size) )  )  );
            ans.add(  obj.get(indexofstart%size).val);
            indexofstart++;
        }
        return ans;
    }
}*/

/*
*  Most Optimized code
*  I reffered this solution https://leetcode.com/problems/circular-permutation-in-binary-representation/discuss/414153/Java-AC-solution%3A-generate-%22one-bit-diff%22-list-then-make-it-start-from-%22start%22
*
* */

class Solution1 {
    List<Integer> l=new ArrayList<>();
    void populate(int n){
        l.add(0);
        int size=l.size();

        for(int i=0;i<n;i++){
            for(int j=l.size()-1;j>=0;j--){
                l.add(l.get(j)+ (1<<i) );               // This is pure Mathmatics man
            }
        }

    }
    public List<Integer> circularPermutation(int n, int start) {
                        List<Integer> ans=new ArrayList<>();
                        int val= ((int)Math.pow((double)2,(double)n));
                        if(l.size()< val)
                             populate(n);


                        int indexstart=0;
                        for(int i=0;i<val;i++){
                            if(start==l.get(i)) {
                                indexstart = i;
                                break;
                            }

                        }

                        for(int i=0;i<val;i++){
//                            System.out.println(l.get(i));
                            ans.add(l.get( (indexstart%val) ));
                            indexstart++;
                        }

                        return ans;

    }
}