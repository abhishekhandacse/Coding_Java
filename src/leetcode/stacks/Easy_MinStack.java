package LeetCode.stacks;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class Easy_MinStack {
    Stack<Integer> st;
    Stack<Integer> min;
    /** initialize your data structure here. */
    public Easy_MinStack() {
        st=new Stack<>();
        min=new Stack<>();
    }

    public void push(int x) {
            if(st.isEmpty()){
                st.add(x);
                min.add(x);
            }else{
                st.add(x);
                if(min.peek()<x)
                    min.push(min.peek());
                else
                    min.push(x);
            }
    }

    public void pop() {
                st.pop();
                min.pop();
    }

    public int top() {
                return st.peek();
    }

    public int getMin() {
                return min.peek();
    }
}
// Easy Min Stack Optimized for using single stack and modifying stack data structure
class Pair{
    int val;
    int minval;
    Pair(int val,int minval){
        this.val=val;
        this.minval=minval;
    }
}
 class Easy_MinStackOptimized {
    Deque<Pair> dq;
    /** initialize your data structure here. */
    public Easy_MinStackOptimized() {
        dq=new LinkedList<>();
    }

    public void push(int x) {
        if(dq.isEmpty()){
            dq.addFirst(new Pair(x,x));
        }else{
            Pair p=dq.getFirst();
            if(x<p.minval){
                dq.addFirst(new Pair(x,x));
            }else{
                dq.addFirst(new Pair(x,p.minval));
            }
        }
    }

    public void pop() {
           dq.removeFirst();
    }

    public int top() {
            Pair p=dq.peekFirst();
            return p.val;
    }

    public int getMin() {
                Pair p=dq.peekFirst();
                return p.minval;
    }
}

// More Optimzed solution
/*
Using Linked List Implementation

*/
class Node{
    int val;
    int minval;
    Node next;
    Node(int val,int minval,Node next){
        this.val=val;
        this.minval=minval;
        this.next=next;
    }
}
class MinStack {
    Node head;
    /** initialize your data structure here. */

    public MinStack() {
        head=null;
    }

    public void push(int x) {
            if(head==null){
                head=new Node(x,x,null);
            }else{
                if(head.minval<x){
                Node temp=new Node(x,head.minval,head);
                head=temp;
                }else{
                Node temp=new Node(x,x,head);
                head=temp;
                }
            }
    }

    public void pop() {
                head=head.next;
    }

    public int top() {
                return head.val;
    }

    public int getMin() {
                return head.minval;
    }
}

