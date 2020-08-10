package hackerrank.medium;

import java.util.Scanner;
import java.util.Stack;

class MyQueue<T>{
    Stack<T> st1;
    Stack<T> st2;
    MyQueue(){
        st1=new Stack<>();
        st2=new Stack<>();
    }
    //// O(1) Time Complexity
    void enqueue(T val){
        st1.push(val);
    }
    //// O(1) On an average
    void dequeue(){
        if(st2.empty()==false){
            st2.pop();
            return;
        }
        while(st1.empty()==false){
            st2.push(st1.pop());
        }
        if(st2.empty()==false)
            st2.pop();
    }
    //// O(1) On an average
    T peek(){
        if(st2.empty()==false){
            return st2.peek();
        }
        while(st1.empty()==false){
            st2.push(st1.pop());
        }
        if(st2.empty()==false)
            return st2.peek();

        //Underflow case
        Object obj=new Object();
        return (T)obj;
    }
}


public class QueuesAtaleoftwoStacks {
    public static void main(String[] args) {

        MyQueue<Integer> queue = new MyQueue<Integer>();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
                queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
                queue.dequeue();
            } else if (operation == 3) { // print/peek
                System.out.println(queue.peek());
            }
        }
        scan.close();
    }
}
