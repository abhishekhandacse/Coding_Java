package leetcode.dp;

import java.util.Stack;

public class Medium_Minimum_cost_tree_from_leaf_values {
            // Time Complexity = O(Len ^ 3)         Space Complexity = O(Len ^ 2)
            static final boolean DEBUG=false;
    public int mctFromLeafValues(int[] arr) {
                if(arr==null || arr.length==0)return Integer.MIN_VALUE; // This is not possible as mentioned in constraints
                int[][] Maximum_Matrix=new int[arr.length][arr.length];// This will store the maximum value in array range from i-->j (both included)
                int[][] DP=new int[arr.length][arr.length];// This will store the answer to sub-problem (Remember if we are trying to partition the arr with a single leaf node on one side then its contribution would be 0)
                //Populating the Maximum_Matrix from arr
                for(int i=0;i<arr.length;i++){
                    int max=arr[i];
                    for(int j=i;j<arr.length;j++){
                        if(max<arr[j])
                            max=arr[j];
                        Maximum_Matrix[i][j]=max;
                    }
                }
                if(DEBUG){
                    for(int i=0;i<arr.length;i++){
                        for(int j=0;j<arr.length;j++){
                            System.out.print(Maximum_Matrix[i][j]+ " ");
                        }
                        System.out.println();
                    }
                }
                // Populating the DP matrix from smaller sub-problems already evaluated and stored in dp arr
                // I am populating the DP matrix from principal diagonal towards the right top edge of the matrix
                // The principal value of DP matrix is 0 because I can't make internal node out of it
                int i,j,Row=0,Col=1;    // Minimum 2 elements are present in the arr is ensured
                int iterations=(arr.length-1);  // populating all the diagonals just after principal diagonal

                while(iterations!=0){
                    i=Row;j=Col;    // Starting diagnol type traversal from Row , Col
                    while ( (i!=arr.length) && (j!=arr.length) ){
                        int min_sum=Integer.MAX_VALUE;  // This is minimum possible sum of internal nodes
                        for(int partition=i;partition<j;partition++){   // This loop considers all partitions possible without making one side as null
                            // This is computing the so formed root node using maximum from left and right sub-trees respective maximum
                            // I already know the internal nodes in left subtree is DP[i][partition] and right subtree is DP[partition+1][j]
                            // justing adding the root node to left sub tree internal sum and right sub tree internal sum would give me sum for this sub-problem
                            int curr_sum=Maximum_Matrix[i][partition]*Maximum_Matrix[partition+1][j] + DP[i][partition] + DP[partition+1][j];
                            if(min_sum>curr_sum)
                                min_sum=curr_sum;
                        }
                        DP[i][j]=min_sum;

                        i++;
                        j++;
                    }
                    Col++;
                    iterations--;
                }


                return DP[0][arr.length-1];
    }





    /*
    * Greedy solution inspiration is taken from https://leetcode.com/problems/minimum-cost-tree-from-leaf-values/discuss/339959/One-Pass-O(N)-Time-and-Space
    * Franky speaking, I was unable to trace the greedy algorithm even after spending entire day of brain-storming.
    * I also believe before attempting to solve a question with dp algorithm, we need to thoroughly ensure ourselves that greedy solution is not possible. If greedy solution is possible than generally speaking it would be more efficient than dp solution in terms of both space and time complexity.
    */




    // TC is O(N^2)  SC is O(1)
    // The innermost while loops will run atmost 40 times in the worst case and could be ignored in this case **Better Alternative could be -->** You can use doubly linkedlist where you can delete smaller element in O(1) time and no need of skipping values
    public int mctFromLeafValues_Optimized(int[] arr) {
        if(arr==null || arr.length==0)return Integer.MAX_VALUE; // This is not possible as mentioned in constraints
        if(arr.length==1)return Integer.MAX_VALUE;
        int num_of_elements=arr.length;
        int cost=0;
        while(num_of_elements>1){
            int i=0,j=0;
            int min_index=0;
            int min_prod=Integer.MAX_VALUE;
            for(int k=0;k<num_of_elements-1;k++){
                if(i==j){
                    j++;
                }
                while(arr[i]==Integer.MAX_VALUE)            // This while loop is for skipping already deleted nodes    (These would not be there if you are using linkedlist implementation)
                    i++;
                while(arr[j]==Integer.MAX_VALUE || (i==j))  // This while loop is for skipping already deleted nodes.
                    j++;
                if(min_prod>(arr[i]*arr[j]) ){
                    min_prod=(arr[i]*arr[j]);
                    min_index=((arr[i]<arr[j])?i:j);
                }
                i=i+1;
                j=i+1;
            }
            cost+=min_prod;
            arr[min_index]=Integer.MAX_VALUE;
            num_of_elements--;
        }
        return cost;
    }

    /*
    *   The above approach could be optimized using LinkedList to store all the elements
    *   Now we can save the precious while loop skipping the deleted values since we are directly deleting the element :)
    *   Time Complexity -: O(N^2) Space Complexity -: O(N)
    */

    public int mctFromLeafValues_LinkedList_Optimized(int[] arr) {
        if(arr==null || arr.length==0)return Integer.MAX_VALUE; // This is not possible as mentioned in constraints
        if(arr.length==1)return Integer.MAX_VALUE;

        int num_of_elements=arr.length;

        int cost=0;
        while(num_of_elements>1){
            int i=0,j=0;
            int min_index=0;
            int min_prod=Integer.MAX_VALUE;
            for(int k=0;k<num_of_elements-1;k++){
                if(i==j){
                    j++;
                }
                while(arr[i]==Integer.MAX_VALUE)
                    i++;
                while(arr[j]==Integer.MAX_VALUE || (i==j))
                    j++;
                if(min_prod>(arr[i]*arr[j]) ){
                    min_prod=(arr[i]*arr[j]);
                    min_index=((arr[i]<arr[j])?i:j);
                }
                i=i+1;
                j=i+1;
            }
            cost+=min_prod;
            arr[min_index]=Integer.MAX_VALUE;
            num_of_elements--;
        }
        return cost;

    }
    /*  This solution is very tricky
    *   References
    *   https://leetcode.com/problems/minimum-cost-tree-from-leaf-values/discuss/339959/One-Pass-O(N)-Time-and-Space
    *   I am just trying to give an explanation for better understanding and have copied the code from above link.
    */
    public int mctFromLeafValues_Most_Optimized(int[] A) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(Integer.MAX_VALUE);  // This is just a sentinal value to avoid keep checking the stack emptiness condition (Using this he is ensuring himself that no matter what stack would never be empty)
        for (int a : A) {
            while (stack.peek() <= a) {
                int mid = stack.pop();// This is just like picking the smallest element
                res += mid * Math.min(stack.peek(), a);// since current element is >=top implies the second min element could either be the element present in the top of the stack or incoming array element.
            }
            stack.push(a);// Doing similer to next greater element problem in which stack with descending values is maintained.
        }
        while (stack.size() > 2) {
            res += stack.pop() * stack.peek();//Just doing last pass in case some elements are still no processed i:e we have delayed their processing by putting them into stack
        }
        return res;
    }
    // Unit testing
    public static void main(String[] args) {
        Medium_Minimum_cost_tree_from_leaf_values obj=new Medium_Minimum_cost_tree_from_leaf_values();
        int[] arr=new int[]{6,2,4};
        System.out.println(obj.mctFromLeafValues_Optimized(arr));//32
        arr=new int[]{6,2,4,8};
        System.out.println(obj.mctFromLeafValues_Optimized(arr));//80
        arr=new int[]{15,13,5,3,15};
        System.out.println(obj.mctFromLeafValues_Optimized(arr));//500
    }
}
