package leetcode.array;

public class Easy_RepetedElementInSize2NArray {

//    Approach-1 TC O(N) SC O(10000)
    /*public int repeatedNTimes(int[] A) {
        int[] hm=new int[10000];

        for(int i=0;i<A.length;i++){
            hm[A[i]]+=1;
            if(hm[A[i]]==(A.length/2) )
                return A[i];
        }
        return -1;// This won't happen under normal scenario
    }*/
//    Time Complexity O(N) Space Complexity O(1)
    public int repeatedNTimes(int[] A) {


        int front=0,rear=A.length-1;
        while(front<rear){
            if(A[front]==A[rear])return A[front];
            else{
                rear--;
            }
        }

        front=0;rear=A.length-1;
        while(front<rear){
            if(A[front]==A[rear])return A[front];
            else{
                front++;
            }
        }

        front=0;rear=A.length-1;
        while(front<rear){
            if(A[front]==A[rear])return A[front];
            else{
                front++;
                rear--;
            }
        }
        return -1;

    }

}
