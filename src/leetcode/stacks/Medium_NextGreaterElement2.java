package leetcode.stacks;

import java.util.Stack;

class node{
    int element;
    int index;
    node(int element,int index){
        this.element=element;
        this.index=index;
    }
}
// Time Complexity O(N)     Space Complexity O(N)
public class Medium_NextGreaterElement2 {
    public int[] nextGreaterElements(int[] arr) {
        int len=arr.length;
        if(arr==null)return null;
        if(arr.length==0)return new int[0];
        int ans[]=new int[len];
        for(int i=0;i<len;i++)ans[i]=-1; // Initializing ans with -1

        Stack<node> st=new Stack<>();
        st.push(new node(arr[0],0));

        for(int i=1;i<((2*len)-1);i++){

            while(!st.isEmpty() && (arr[i%len]>st.peek().element)){
                ans[st.peek().index]=arr[(i%len)];
                st.pop();
            }
            st.push(new node(arr[(i%len)],(i%len)));
        }
        return ans;
    }
//  For Unit testing
    public static void main(String[] args) {
        Medium_NextGreaterElement2 obj=new Medium_NextGreaterElement2();

        int arr[]=obj.nextGreaterElements(new int[]{1,2,1});
        for(int i:arr)
            System.out.print(i+" ");
        System.out.println();

        arr=obj.nextGreaterElements(new int[]{2,2,2});
        for(int i:arr)
            System.out.print(i+" ");
        System.out.println();

        arr=obj.nextGreaterElements(new int[]{10,15,0,20});
        for(int i:arr)
            System.out.print(i+" ");
        System.out.println();

        arr=obj.nextGreaterElements(new int[]{15,12,10,8});
        for(int i:arr)
            System.out.print(i+" ");
        System.out.println();

        arr=obj.nextGreaterElements(new int[]{1,2,3,4});
        for(int i:arr)
            System.out.print(i+" ");
        System.out.println();

        arr=obj.nextGreaterElements(new int[]{1,2,3,2,1});
        for(int i:arr)
            System.out.print(i+" ");
        System.out.println();


    }

}


