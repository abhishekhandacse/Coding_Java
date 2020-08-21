package leetcode.array;

public class Medium_FineTheWinnerOfAnArrayGame {
    // Time Complexity-: O(N) Space Complexity -: O(1)
    public int getWinner(int[] arr, int k) {

                int n=arr.length;
                if( k>=n-1)
                    k=n-1;
                int head=1;
                int count=0;

                while(count!=k){
                    if(arr[0]>arr[head]){
                        count=count+1;
                        head=head + 1;
                    }else{
                        int temp=arr[0];
                        arr[0]=arr[head];
                        arr[head]=temp;
                        head=head+1;
                        count=1;
                    }

                    if(head==n)
                        head=1;
                }

                return arr[0];
    }

    public static void main(String[] args) {
        Medium_FineTheWinnerOfAnArrayGame obj=new Medium_FineTheWinnerOfAnArrayGame();
        System.out.println(obj.getWinner(new int[]{2,1,3,5,4,6,7},2));
        System.out.println(obj.getWinner(new int[]{3,2,1},10));
        System.out.println(obj.getWinner(new int[]{1,9,8,2,3,7,6,4,5},7));
        System.out.println(obj.getWinner(new int[]{1,11,22,33,44,55,66,77,88,99},1000000000));
    }
}
