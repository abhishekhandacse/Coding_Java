package leetcode.array;

class MinHeap{
    int[] arr;
    int size;
    int index;
    MinHeap(int size){
        this.size=size;
        this.index=0;
        arr=new int[size];  // Size need to decided prior to using heap
    }
    int rootElement(){
        return arr[0];
    }
    void replaceRoot(int element){
        arr[0]=element;
        minHeapifyTopDown();
    }
    void addElement(int element){
        if(index==size){
            System.out.println("Maximum size of heap reached");
            return;
        }
        arr[index]=element;
        minHeapify(index);
        index++;
    }
    private void swap(int index1,int index2){
        int temp=arr[index1];
        arr[index1]=arr[index2];
        arr[index2]=temp;
    }
    private void minHeapify(int index) {
        if(index==0)return;// No need to heapify the root element
        if(arr[(index-1)/2]>arr[index]){
            swap(((index-1)/2),index);
        }
        minHeapify(((index-1)/2));
    }
    public void printHeap(){
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
    // Top down heapify
    void minHeapifyTopDown(){
         int root_index=0;
         while(root_index<size){
            int left=((2*root_index)+1);
            int right=((2*root_index)+2);
            int new_index=root_index;
            if(left<size && arr[root_index]>arr[left])
                new_index=left;
            if(right<size && arr[new_index]>arr[right])
                new_index=right;
            if(new_index==root_index)
                break;
             swap(root_index,new_index);
             root_index=new_index;
         }
    }
}


public class Medium_KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        MinHeap mh=new MinHeap(k);
        for(int i=0;i<k;i++){
            mh.addElement(nums[i]);
        }
//        mh.replaceRoot(nums[k]);
//        mh.printHeap();
//        mh.replaceRoot(nums[k+1]);
//        mh.printHeap();
        for(int i=k;i<nums.length;i++){
            if(nums[i]>mh.rootElement()){
                mh.replaceRoot(nums[i]);
            }
        }

        return mh.rootElement();
    }

    public static void main(String[] args) {
        Medium_KthLargestElementInAnArray obj=new Medium_KthLargestElementInAnArray();
//        System.out.println(obj.findKthLargest(new int[]{3,2,1,5,6,4},2));
        System.out.println(obj.findKthLargest(new int[]{3,2,3,1,2,4,5,5,6},4));

    }
}

// Give special attention to element repetition and