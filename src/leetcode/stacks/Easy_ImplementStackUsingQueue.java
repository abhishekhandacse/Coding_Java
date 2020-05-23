package leetcode.stacks;

import java.util.LinkedList;
import java.util.Queue;

public class Easy_ImplementStackUsingQueue {
    Queue<Integer> q1;
    Queue<Integer> q2;
    public Easy_ImplementStackUsingQueue () {
        q1=new LinkedList<>();
        q2=new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {

        q1.add(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        while(q1.size()>1){
            q2.add(q1.peek());
            q1.remove();
        }
        int ans=q1.peek();
        q1.remove();
        Queue<Integer> temp=q1;
        q1=q2;
        q2=temp;
        return ans;
    }

    /** Get the top element. */
    public int top() {
        while(q1.size()>1){
            q2.add(q1.peek());
            q1.remove();
        }
        int ans=q1.peek();
        q2.add(q1.peek());
        q1.remove();
        Queue<Integer> temp=q1;
        q1=q2;
        q2=temp;
        return ans;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty();
    }
}
