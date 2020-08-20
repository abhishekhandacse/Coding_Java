package leetcode.array;

public class Easy_MinOperationsToMakeArrayEqual {
    // TC - O(1) SC - O(1)
    public int minOperations(int n) {
                if( (n%2)==0)return ((n/2)*(n/2));
                else return ((n/2)*((n/2)+1));
    }
    // This is why mathmatics is so so important
}
