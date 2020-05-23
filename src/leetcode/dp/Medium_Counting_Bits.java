package leetcode.dp;

public class Medium_Counting_Bits {


    /*
    * I am using the fact that continous binary numbers can be produced by appending
    * 0 and 1 to the respective binary numbers in from 1 onwards
    * like 1 --> 1
    *      2 --> 10     Appending 0 to Binary representation of 1 produces 2
    *      3 --> 11     Appending 1 to Binary representation of 1 produces 3
    *      4 --> 100    Now pick Binary Representation of 2 and repeat the process
    *      5 --> 101
    *      6 --> 110
    * */
    // TC O(num)  SC O(num)
    public int[] countBits(final int num) {
        int[] arr=new int[num+1];
        if(num==0)return arr;
        arr[1]=1;
        int count=1;
        int iter=2;
        while(iter<(num+1)){
          arr[iter]=(arr[count]+0);
          iter++;
          if(iter>num)break;
          arr[iter]=(arr[count]+1);
          iter++;
          count++;
        }
        return arr;
    }


    // Unit Testing
    public static void main(String[] args) {
        Medium_Counting_Bits obj=new Medium_Counting_Bits();

        int[] temp=obj.countBits(10);
        for(int i:temp)
            System.out.print(i+" ");
        System.out.println();
        temp=(obj.countBits(20));
        for(int i:temp)
            System.out.print(i+" ");
    }
}
