package geeksforgeeksimproved.graphs;

import javafx.util.Pair;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;


/*
*   References -:  https://www.geeksforgeeks.org/prims-mst-for-adjacency-list-representation-greedy-algo-6/
*/
class UndirectedGraph{
    int V;
    LinkedList<Pair<Integer,Integer>> adj[];

    UndirectedGraph(){}
    public UndirectedGraph(int v) {
        V = v;
        adj=new LinkedList[V];
        for(int i=0;i<V;i++){
            adj[i]=new LinkedList<Pair<Integer,Integer>>();
        }
    }

    public int getV() {
        return V;
    }

    public LinkedList<Pair<Integer, Integer>>[] getAdj() {
        return adj;
    }

    void addEdge(int u, int v, int w){
        adj[u].add(new Pair(v,w));
        adj[v].add(new Pair(u,w)); // Graph is undirected
    }
}

class comparator implements Comparator<Pair<Integer, Pair<Integer,Integer>>> {
    @Override
    public int compare(Pair<Integer, Pair<Integer, Integer>> p1, Pair<Integer, Pair<Integer, Integer>> p2) {
                if(p1.getKey()<p2.getKey())return -1;   //Criteria for minHeap
                else return 1;
    }
}

public class PrimsAlgorithmsUsingLibrary {
   void PrimsMST_Using_Heaps(UndirectedGraph g, int source){
       int V=g.getV();
       int Key[]=new int[V];// To identify weather a vertex is present in min heap
       int Parent[]=new int[V];
       // <Key,< Vertex,Parent > >
       PriorityQueue<Pair<Integer, Pair<Integer,Integer>>> pq=new PriorityQueue<>(new comparator());

       for(int i=0;i<V;i++){
           if(i==source) {
               pq.add(new Pair(0, new Pair(i, null)));
               Key[i]=0;
           }
           else {
               pq.add(new Pair(Integer.MAX_VALUE, new Pair(i, null)));
               Key[i]=Integer.MAX_VALUE;
           }
           Parent[i]=-1;
       }
       int wt=0;
       while(! pq.isEmpty()){
           //   Key          Vertex   Parent
           Pair<Integer,Pair<Integer,Integer>> p= pq.poll(); //Extract Min in heap
           int vertex_number=p.getValue().getKey();
           Key[vertex_number]=-1;//Removed from the heap

           for(Pair pair:g.getAdj()[vertex_number]){    // Explore the adjacancy list of this current vertex
               // explore all the adjacent elements
               int curr_vertex=(Integer) pair.getKey();
               int curr_wt=(Integer) pair.getValue();

               if(Key[curr_vertex]!=-1 && ( curr_wt < Key[curr_vertex]) ){  // If current vertex is present in heap and has key greater than
                   pq.remove(curr_wt);
                   pq.add(new Pair(curr_wt,new Pair(curr_vertex,vertex_number)));
                   Key[curr_vertex]=curr_wt;
                   Parent[curr_vertex]=vertex_number;
               }
           }
       }

       // Printing Parent arr

       for(int i=0;i<V;i++){
           System.out.println(Parent[i] + " -- " +i);
       }
    }


    public static void main(String[] args) {
        UndirectedGraph g=new UndirectedGraph(9);

        g.addEdge(0, 1, 4);
        g.addEdge( 0, 7, 8);
        g.addEdge( 1, 2, 8);
        g.addEdge( 1, 7, 11);
        g.addEdge( 2, 3, 7);
        g.addEdge( 2, 8, 2);
        g.addEdge( 2, 5, 4);
        g.addEdge( 3, 4, 9);
        g.addEdge( 3, 5, 14);
        g.addEdge( 4, 5, 10);
        g.addEdge( 5, 6, 2);
        g.addEdge( 6, 7, 1);
        g.addEdge( 6, 8, 6);
        g.addEdge( 7, 8, 7);


        PrimsAlgorithmsUsingLibrary obj=new PrimsAlgorithmsUsingLibrary();

        obj.PrimsMST_Using_Heaps(g,0);
    }
}

