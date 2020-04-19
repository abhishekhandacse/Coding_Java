package stacks;

public class Medium_DesignStackWithIncOpertation {
    CustomStack obj=new CustomStack(100);// This class is just for API testing purpose
}
/*
class CustomStack {
    private int[] arr;
    private int[] val;
    private int index;
    private int maxSize;
    public CustomStack(int maxSize) {
            this.maxSize=maxSize;
            arr=new int[maxSize];
            val=new int[maxSize];
            index=0;
    }

    public void push(int x) {
            if(index==maxSize)
                return;
            arr[index]=x;
            index++;
    }

    public int pop() {
            if(index==0)return -1;
            index--;
            if(val[index]==0){
                return arr[index];
            }else{
                int update=0;
                for(int i=index;i>=0;i--){
                    if(val[i]!=0){
                        update+=val[i];
                        val[i]=0;

                    }
                    arr[i]+=update;
                }
            }
            return arr[index];
    }

    public void increment(int k, int val) {
                if(k>maxSize) {
                    this.val[maxSize - 1] = val;
                    return;
                }
                this.val[k]=val;
    }
}
*/
/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */
// Lazy increment Optimzed Code
/*
class CustomStack {
    private int[] arr;
    private int[] val;
    private int index;
    private int maxSize;
    public CustomStack(int maxSize) {
        this.maxSize=maxSize;
        arr=new int[maxSize];
        val=new int[maxSize];
        index=0;
    }

    public void push(int x) {
        if(index==maxSize)
            return;
        arr[index]=x;
        index++;
    }

    public int pop() {
        if(index==0)return -1;
        index--;
        if(val[index]==0){
            return arr[index];
        }else{
            int update=0;
            for(int i=index;i>=0;i--){
                if(val[i]!=0){
                    update+=val[i];
                    val[i]=0;

                }
                arr[i]+=update;
            }
        }
        return arr[index];
    }

    public void increment(int k, int val) {
        if(index==0)
            return;
        if(k>index-1) {
            this.val[index-1] += val;
            return;
        }
        this.val[k-1]+=val;
    }
}
*/
// Further Optimization with pop also O(1) operation
class CustomStack {
    private int[] arr;
    private int[] val;
    private int index;
    private int maxSize;
    public CustomStack(int maxSize) {
        this.maxSize=maxSize;
        arr=new int[maxSize];
        val=new int[maxSize];
        index=0;
    }

    public void push(int x) {
        if(index==maxSize)
            return;
        arr[index]=x;
        index++;
    }

    public int pop() {
        if(index==0)return -1;


        index--;

        if(val[index]==0){
            return arr[index];
        }else{
            int ans=arr[index]+val[index];
            val[index-1]+=val[index];
            val[index]=0;
            return ans;
        }

    }

    public void increment(int k, int val) {
        if(index==0)
            return;
        if(k>index-1) {
            this.val[index-1] += val;
            return;
        }
        this.val[k-1]+=val;
    }
}