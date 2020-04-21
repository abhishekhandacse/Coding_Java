package geeksforgeeksimproved.binaryheap;

public class MinHeap {

        private int[] harr;
        private int maxsize;
        private int currsize;

    public MinHeap(int size) {
        this.maxsize = size;
        harr=new int[maxsize];
        currsize=0;
    }
    // It is assumed that new_val is smaller than harr[index]
    public void decreasekey(int index,int new_val){
        harr[index]=new_val;
        if(harr[index] < harr[(index-1)/2]){
            insert_aux(index);
        }
    }
   private void insert_aux(int index){
        if(index==0)return;// base condition
        int parent_index=   (int)Math.ceil(  (double) ((double) index/(double) 2)) -1;
        int min_index=parent_index;
        if((2*parent_index+1) <= index  && harr[(2*parent_index+1)] < harr[min_index] ){// left child exists and lesser than parent
            min_index=(2*parent_index+1);
        }

       if((2*parent_index+2) <= index  && harr[(2*parent_index+2)] < harr[min_index] ){// left child exists and lesser than parent
           min_index=(2*parent_index+2);
       }

       if(min_index!=parent_index){//Mean there is a smaller element below and we need to heapify after swapping
           int temp=harr[parent_index];
           harr[parent_index]=harr[min_index];
           harr[min_index]=temp;

           // Call heapify for the parent
           insert_aux(parent_index);
       }
    }
    public void insert(int element){
        if(currsize>=maxsize){
            System.out.println("Overflow");
        }
        harr[currsize]=element;

        if(currsize>0)
            insert_aux(currsize);
        currsize++;
    }

    private void MinHeapify(int index){
        if(index>=currsize)return;   //base condition

        int left_index=2*index + 1;
        int right_index=2*index + 2;
        int min_index=index;// Currently min is parent

        if((left_index) < currsize  && harr[left_index] < harr[min_index] ){// left child exists and lesser than parent
            min_index=left_index;
        }

        if((right_index) < currsize  && harr[(right_index)] < harr[min_index] ){// left child exists and lesser than parent
            min_index=right_index;
        }

        if(min_index!=index){//implies there is a smaller element below and we need to heapify after swapping
            int temp=harr[index];
            harr[index]=harr[min_index];
            harr[min_index]=temp;

            // Call heapify for the parent
            MinHeapify(min_index);
        }
    }
    public int extractMin(){
           if(currsize==0){
               System.out.println("Underflow");
               return Integer.MAX_VALUE;
           }
           int ans=harr[0];

           int last_index=currsize-1;
           //swapping first and last element
            int temp=harr[0];
            harr[0]=harr[last_index];
            harr[last_index]=temp;
            currsize--;
           MinHeapify(0);
           return ans;
    }
    void printHeap(){
        for(int i=0;i<currsize;i++){
            System.out.print(harr[i] + "  ");
        }
        System.out.println();
    }
/*
* Writing Unit Tests
* */
    public static void main(String[] args) {
        MinHeap mh=new MinHeap(11);

        mh.insert(20);
        mh.insert(15);
        mh.insert(10);
        mh.printHeap();

        mh.decreasekey(2,5);

        mh.printHeap();

        /*mh.insert(3);
        mh.insert(2);
        mh.insert(1);
        mh.insert(0);
        mh.insert(20);
        mh.insert(-1);
        mh.printHeap();
        System.out.println(mh.extractMin());
        mh.printHeap();
        System.out.println(mh.extractMin());
        mh.printHeap();
        System.out.println(mh.extractMin());
        mh.printHeap();
        System.out.println(mh.extractMin());
        mh.printHeap();
        System.out.println(mh.extractMin());*/
    }


}
