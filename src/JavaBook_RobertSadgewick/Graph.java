package JavaBook_RobertSadgewick;

import java.util.Iterator;
import java.util.LinkedList;

public class Graph {
    final private int V;
    private int E;

    // Array of Adjacency List for storing mapping
    LinkedList<Integer> adj[];

    public int getV() {
        return V;
    }

    public int getE() {
        return E;
    }

    public Graph(int v) {
        this.V = v;
        E=0;
        adj=new LinkedList[V];
        for(int i=0;i<V;i++){
            adj[i]=new LinkedList<>();
        }
    }
    public Graph(int V,int E,int[][] adj){
        this(V);
        this.E=E;

        for(int i=0;i<E;i++){
                int u=adj[i][0];
                int v=adj[i][1];
                this.addEdge(u,v);
              //  this.addEdge(v,u);// Comment this for directed graph
        }
    }
    // DeepCopy of the graph into current graph
    public Graph(Graph g){
        this.V=g.getV();
        this.E=g.getE();

        this.adj=new LinkedList[V];
        for(int i=0;i<V;i++){
            adj[i]=new LinkedList<>();
        }

        for(int i=0;i<g.getV();i++){
            for(int j:g.adj[i]){
                this.addEdge(i,j);
            }

        }

    }
    public int degree(int V){
        return adj[V].size();
    }
    public void addEdge(int v,int w){
        E++;
        adj[v].add(w);
        //adj[w].add(v);    /*uncomment for directed graph*/
    }
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(V + " vertices, " + E + " edges " + "\n");
        for (int v = 0; v < V; v++) {
            s.append(v + ": ");
            for (int w : adj[v]) {
                s.append(w + " ");
            }
            s.append("\n");
        }
        return s.toString();
    }

    /**
     * Unit tests the Graph data type.
     *
     *
     */
    public static void main(String[] args) {
        Graph G = new Graph(13,26,new int[][]{
                {0,6},{0,2},{0,1},{0,5},
                {1,0},
                {2,0},
                {3,5},{3,4},
                {4,5},{4,6},{4,3},
                {5,3},{5,4},{5,0},
                {6,0},{6,4},
                {7,8},
                {8,7},
                {9,11},{9,10},{9,12},
                {10,9},
                {11,9},{11,12},
                {12,11},{12,9}
        });

        System.out.println(G);

    }
}
