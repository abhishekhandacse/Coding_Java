package leetcode.stacks;

import java.util.Stack;

// Implementation-->1 Expensive pop opertaion Not Recommended as involves double shiftings

public class Easy_QueueUsingStack {
    Stack<Integer> st1;
    Stack<Integer> st2;
    /** Initialize your data structure here. */
    public Easy_QueueUsingStack() {
           st1=new Stack<>();
           st2=new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
            st1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
           while(!st1.empty()){
               st2.push(st1.peek());
               st1.pop();
           }
           int ans=st2.peek();
           st2.pop();
           while(!st2.empty()){
               st1.push(st2.peek());
               st2.pop();
           }
           return ans;
    }

    /** Get the front element. */
    public int peek() {
        while(!st1.empty()){
            st2.push(st1.peek());
            st1.pop();
        }
        int ans=st2.peek();
        while(!st2.empty()){
            st1.push(st2.peek());
            st2.pop();
        }
        return ans;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
           return st1.empty();
    }
}
// Implementation 2
class Easy_QueueUsingStack2 {
    Stack<Integer> st1;
    Stack<Integer> st2;
    /** Initialize your data structure here. */
    public Easy_QueueUsingStack2() {
        st1=new Stack<>();
        st2=new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        st1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(st2.empty()==false){
            int ans=st2.peek();
            st2.pop();
            return ans;
        }
        while(!st1.empty()){
            st2.push(st1.peek());
            st1.pop();
        }
        int ans=st2.peek();
        st2.pop();
        return ans;
    }

    /** Get the front element. */
    public int peek() {
        if(st2.empty()==false){
            return st2.peek();
        }
        while(!st1.empty()){
            st2.push(st1.peek());
            st1.pop();
        }
        int ans=st2.peek();
        return ans;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
         return st1.empty()&&st2.empty();
    }
}