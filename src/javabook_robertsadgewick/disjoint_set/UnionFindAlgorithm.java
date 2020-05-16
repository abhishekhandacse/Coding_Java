package JavaBook_RobertSadgewick.disjoint_set;
/*
* This Algorithm Implements Disjoint set data structure with Union find algorithm with Rank and Path Compression
* */
public class UnionFindAlgorithm {

    // This function will return representative of a particular set
    // Also this would do path compression
    public int find(Set[] sets,int index){
        if(sets==null)return -1;
        if(sets[index].parent==index)return index;// Returning the representative

        sets[index].parent=find(sets,sets[index].parent);
        return sets[index].parent;// This would do path compression by directly attaching the all nodes in the path of representative to directly representative
    }
    // Amortized TC= O(1)

    // This function would do union with Ranking
    public void union(Set[] sets,int first,int second){
        // Find the representative of each set
        int repr_first=find(sets,first);
        int repr_second=find(sets,second);
        if(repr_first==repr_second){return;}// Already in same set
        if(sets[repr_first].rank > sets[repr_second].rank){
            sets[repr_second].parent=repr_first;
        }else if(sets[repr_first].rank < sets[repr_second].rank){
            sets[repr_first].parent=repr_second;
        }else{
            // Lets make second representative in this case
            sets[repr_first].parent=repr_second;
            sets[repr_second].rank+=1;
        }
    }
    // Amortizec Time Complexity O(1)
    void print_set(Set[] sets, int index){
        if(sets==null)return;
        System.out.print(index + " ");
        while(sets[index].parent!=index){
            index=sets[index].parent;
            System.out.print(index + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Set sets[]=new Set[6];
        for(int i=0;i<6;i++){
            sets[i]=new Set(0,i);
        }

        UnionFindAlgorithm obj=new UnionFindAlgorithm();

        obj.union(sets,0,1);
        obj.union(sets,0,2);

//        obj.print_set(sets,2);


        obj.union(sets,3,4);
        obj.union(sets,4,5);

//        obj.print_set(sets,5);

        obj.union(sets,1,4);
        obj.print_set(sets,0);
        System.out.println(obj.find(sets,0));
        obj.print_set(sets,0);//This time, Path got shortened due to find


    }
}
