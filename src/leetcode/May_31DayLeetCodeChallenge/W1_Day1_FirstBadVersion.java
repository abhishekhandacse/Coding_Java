package LeetCode.May_31DayLeetCodeChallenge;

public class W1_Day1_FirstBadVersion {
    public boolean isBadVersion(int n){
        return true;
    }
    public int firstBadVersion(int n) {

        int low=1,high=n,mid;

        while(low<=high){
            mid = (low + (high-low)/2);
            if(isBadVersion(mid)==true)
                high=mid-1;
            else
                low=mid+1;

        }

        if(high<1)return 1;

        if(low>n)return n;

        return low;
    }

}
