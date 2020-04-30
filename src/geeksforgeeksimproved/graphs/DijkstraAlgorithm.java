package geeksforgeeksimproved.graphs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;


/*
 *    Map here stores mapping between vertex number and actual index in of that corresponding vertex in MinHeap array
 */
class MyMinHeap{
    private Pair<Integer>[] harr;               // arr of Pair<Distance,Vertex No>
    private int maxsize;                        // Maxsize of elements that heap can handle
    private int currsize;                       // Curr size of the heap
    Map<Integer,Integer> hm;                    // Used to store mapping of <Vertex no , index of this vertex in  min heap>
    public MyMinHeap(int size) {
        this.maxsize = size;
        harr=new Pair[maxsize];
        for(int i=0;i<maxsize;i++){
            harr[i]=new Pair<Integer>(0,0);
        }
        currsize=0;
        hm=new HashMap<>();
    }
    boolean isEmpty(){                          //Confirms weather heap is empty or not
        return currsize==0;
    }
    boolean isPresent(int v){                   //Confirms weather this particualar Vertex No is present in the heap or not
        return hm.containsKey(v);
    }
    public void decreasekey(int vertex_no,int new_val){         // My Assumption that val would only be decreased since we are propagating the change up the tree
        if(hm.containsKey(vertex_no)==false){
            System.out.println("Decrease Key not possible since vertex not present in graph");
        }
        int index=hm.get(vertex_no);                            // Gets the index of corresponding vertex no in the min heap array
        harr[index].key=new_val;
        if(harr[index].key < harr[(index-1)/2].key){
            insert_aux(index);                                  // This is just heapify and propagating the change towards root
        }
    }
    private void insert_aux(int index){                         // This function performs heapify by propagating the smaller element towards the root of the tree
        if(index==0)return;// base condition
        int parent_index=   (int)Math.ceil(  (double) ((double) index/(double) 2)) -1;
        int min_index=parent_index;
        if((2*parent_index+1) <= index  && harr[(2*parent_index+1)].key < harr[min_index].key ){// left child exists and lesser than parent
            min_index=(2*parent_index+1);
        }

        if((2*parent_index+2) <= index  && harr[(2*parent_index+2)].key < harr[min_index].key ){// right child exists and lesser than parent
            min_index=(2*parent_index+2);
        }

        if(min_index!=parent_index){//Mean there is a smaller element below and we need to heapify after swapping

            hm.put(harr[parent_index].val , min_index );
            hm.put(harr[min_index].val,parent_index);
            Pair<Integer> temp=new Pair<Integer>(harr[parent_index].key , harr[parent_index].val);      // Storing index of vertex no and its corresponding position in the map for easy reference
            harr[parent_index].key = harr[min_index].key;
            harr[parent_index].val=harr[min_index].val;
            harr[min_index].key=temp.key;
            harr[min_index].val=temp.val;

            insert_aux(parent_index);
        }else{
            hm.put(harr[index].val,index);
        }
    }
    public void insert(int vertex_no,int key){      // This function inserts the key corresponding to a particualar vertex no in the min heap
        if(currsize>=maxsize){
            System.out.println("Overflow");
        }
        harr[currsize].key=key;
        harr[currsize].val=vertex_no;
        if(currsize==0) {
            hm.put(vertex_no,0);        // HeapIndex for the first node would obviously be 0
        }else{
            insert_aux(currsize);           // Propagating the change in the heap
        }
        currsize++;
    }

    private void MinHeapify(int index){     //This function performs heapify from that elements towards the leaves of the tree (heap)
        if(index>=currsize)return;   //base condition

        int left_index=2*index + 1;
        int right_index=2*index + 2;
        int min_index=index;// Currently min is parent

        if((left_index) < currsize  && harr[left_index].key < harr[min_index].key ){// left child exists and lesser than parent
            min_index=left_index;
        }

        if((right_index) < currsize  && harr[(right_index)].key < harr[min_index].key ){// left child exists and lesser than parent
            min_index=right_index;
        }

        if(min_index!=index){//implies there is a smaller element below and we need to heapify after swapping

            hm.put(  harr[min_index].val , index  );        // I can guarantee that node at min_index is at least at its correct position
            hm.put(  harr[index].val,min_index);
            Pair<Integer> temp=new Pair<Integer>(harr[index].key,harr[index].val);
            harr[index].key=harr[min_index].key;
            harr[index].val=harr[min_index].val;
            harr[min_index].key=temp.key;
            harr[min_index].val=temp.val;

            MinHeapify(min_index);
        }else{
            hm.put(  harr[index].val , index   );   //Already at correct position
        }
    }
    public Pair extractMin(){                               // Performs Extract Min operation by extracting first element of the array and calling heapify
        if(currsize==0){
            System.out.println("Underflow");
            return new Pair(Integer.MAX_VALUE,Integer.MAX_VALUE);
        }
        hm.remove(harr[0].val);
        Pair<Integer> ans=new Pair<Integer>(harr[0].key,harr[0].val);

        int last_index=currsize-1;
        //swapping first and last element
        Pair<Integer> temp=new Pair<Integer>(harr[0].key , harr[0].val);
        harr[0].key=harr[last_index].key;
        harr[0].val=harr[last_index].val;
        harr[last_index].key= temp.key;
        harr[last_index].val=temp.val;

        currsize--;
        MinHeapify(0);
        return ans;
    }

    void printHeap(){
        for(int i=0;i<currsize;i++){
            System.out.println( " HeapIndex-> " + i + "  Key-> " + harr[i].key + "  Vertex_No-> " + harr[i].val);
        }
        System.out.println();
    }
    void printMap(){
         for(Map.Entry iter:hm.entrySet()){
             System.out.println( " Vertex No " + iter.getKey() +  " ----   " + " hm position  "  + iter.getValue());
         }
    }
}
// This Pair just expands to Pair<distance , vertex no> just for making distance to a vertex
class Pair<T>{
    T key;
    T val;
    public Pair(T key, T val) {
        this.key = key;
        this.val = val;
    }
}
class Dijkstra_Graph{
    int V;
    LinkedList<Pair<Integer> > adj[];           // This stores the graph in the form of < source,< destination,weight > >

    public Dijkstra_Graph(int v) {
        V = v;
        adj=new LinkedList[V];
        for(int i=0;i<V;i++){
            adj[i]=new LinkedList<>();
        }
    }
    void addEdge(int u,int v,int w){
        adj[u].add(new Pair(v,w));
        adj[v].add(new Pair(u,w));                          // This is a undirected graph
    }
    void dijkstra(int source){                              // Method for performing dijkstra algorithm
        int V=this.V;
        MyMinHeap mh=new MyMinHeap(V);                      // Taking min heap of size V vertices
        int dist[]=new int[V];                              // Distance vertex tells the distance from the source to all other vertices
        for(int i=0;i<V;i++){
            dist[i]=Integer.MAX_VALUE;
            mh.insert(i,dist[i]);
        }
        mh.decreasekey(source,0);                   // Making the source vertex to be extracted first
        dist[source]=0;

        while(! mh.isEmpty()){                               // Till heap does not becomes empty
            Pair<Integer> p=mh.extractMin();
            int u=p.val;
            int distance=p.key;
            for(Pair<Integer> iter:adj[u]){                  // Iterating the adjacancy list of the current vertex

                int v=iter.key;// this is adj vertex
                int weight=iter.val;

                if(mh.isPresent(v) && distance!=Integer.MAX_VALUE   && distance + weight < dist[v]   ){
                    // if destination vertex is present in the min heap and its own distance is finite and
                    // distance through it less than destination orignal distance
                    dist[v]=distance + weight;      // Update the distance to smaller distance
                    mh.decreasekey(v,dist[v]);      // Update the distance in the min heap also
                }
            }
        }
        /*Print the distances to all respective vertices*/
        System.out.println( "\nVertex" +  "           " + "Distance");
        System.out.println();
        for(int i=0;i<V;i++){
            System.out.println("  " + i + "      -->        " + dist[i]);
        }
        System.out.println();

    }
}

public class DijkstraAlgorithm {
    public static void main(String[] args) {
        Dijkstra_Graph g=new Dijkstra_Graph(5 );
        g.addEdge( 0, 1, 3);
        g.addEdge( 1, 2, 1);
        g.addEdge( 2, 3, 2);
        g.addEdge( 1, 3, 4);
        g.addEdge( 0, 3, 7);
        g.addEdge( 0, 4, 8);
        g.addEdge( 4, 3, 3);

        g.dijkstra( 0);

        /*<-----------For Debugging min heap----->*/
        /*MyMinHeap obj=new MyMinHeap(7);
        obj.insert(0,0);
        obj.insert(1,5);
        obj.insert(2,6);
        obj.insert(3,-1);
        obj.decreasekey(2,-10);
        obj.printHeap();
        obj.printMap();*/
    }

}
