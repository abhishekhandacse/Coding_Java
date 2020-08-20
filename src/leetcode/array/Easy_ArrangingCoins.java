package leetcode.array;

public class Easy_ArrangingCoins {
    // TC O(N)
    public int arrangeCoins(int n) {
                if(n==0)return 0;
                long sum=0;
                for(int i=1;i<=n;i++){
                    sum+=i;
                    if(sum==n)return i;
                    else if( sum > n)return i-1;
                }
                return -1;
    }
    // TC O(logN)

    public int arrangeCoinsAux(int n) {
        if(n==0)return 0;

        long low=1,high=n,mid;
        long Sn;

        while(low<=high){
            mid = (low+(high-low)/2);
            Sn = ((mid)*(mid+1)/2);
            if(Sn==n)return (int)mid;
            else if ( Sn < n ){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }

        return (int)high;
    }

    public static void main(String[] args) {
        Easy_ArrangingCoins obj=new Easy_ArrangingCoins();

        System.out.println(obj.arrangeCoinsAux(5));
        System.out.println(obj.arrangeCoinsAux(8));
        System.out.println(obj.arrangeCoinsAux(13));
    }

}
