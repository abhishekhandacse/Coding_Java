package stacks;


import java.util.HashSet;

public class Easy_HappyNumbers {
    public static void main(String[] args) {
        Solution obj=new Solution();
        System.out.println(obj.isHappy(7));
        Solution obj1=new Solution();
        System.out.println(obj.isHappy(6));
    }
}
class Solution {

    static HashSet<Integer> yes=new HashSet<>(){{
        add(1);
        add(7);
        add(10);
        add(100);
    }};
    static HashSet<Integer> no=new HashSet<>(){{
        add(2);
        add(3);
        add(4);
        add(5);
        add(6);
        add(8);
        add(9);
    }};
    HashSet<Integer> localno;

    Solution(){
        localno=new HashSet<>();
    }

    int SqSum(int num){
        int sum=0;
        while(num>0){
            int digit=num%10;
            sum+=(digit*digit);
            num=num/10;
        }
        return sum;
    }

    public boolean isHappy(int n) {
        System.out.println(this.no);
        System.out.println(this.yes);
        if(n==1){
            yes.add(1);
            return true;
        }
        if(yes.contains(n))return true;
        if(no.contains(n))return false;
        localno.clear();

        int sqsum=n;

        while(sqsum!=1 && localno.contains(sqsum)==false && no.contains(sqsum)==false){
            System.out.println(sqsum);
            localno.add(sqsum);
            sqsum=SqSum(sqsum);
        }
        if(no.contains(sqsum)){
            no.addAll(localno);
            return false;
        }
        if(sqsum==1){
            yes.addAll(localno);
            return true;
        }else{
            no.addAll(localno);
            return false;
        }

    }

}