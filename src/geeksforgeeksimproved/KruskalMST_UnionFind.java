package geeksforgeeksimproved;


import JavaBook_RobertSadgewick.disjoint_set.Set;
import JavaBook_RobertSadgewick.disjoint_set.UnionFindAlgorithm;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;


class Edge implements Comparable<Edge>{
    int src,dest,weight;
    Edge(){}
    public Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    // Sorted in Descending Order based on weight
    @Override
    public int compareTo(@NotNull Edge edge) {
            if(this.weight>edge.weight)return 1;
            else{return -1;}
    }
}
 class Graph{
    int V;
    int E;
    Edge edge[];

    public Graph(int v, int e, Edge[] edge) {
        V = v;
        E = e;
        this.edge = edge;
    }
}
public class KruskalMST_UnionFind {
    public void KruskalMST_UnionFind(Graph g){
        Edge result[]=new Edge[g.V];// This would contain final result i:e MST algorithm
        int index=0;
        for(int i=0;i<g.V;i++){
            result[i]=new Edge();
        }

        Arrays.sort(g.edge);
        Set sets[]=new Set[g.V];
        for(int i=0;i<g.V;i++){
            sets[i]=new Set(0,i);
        }
        UnionFindAlgorithm unionFindAlgorithm=new UnionFindAlgorithm();
        int iter=0;
        int e=0;
        while(e < (g.V -1)){
            Edge next_edge=new Edge();

            next_edge=g.edge[iter++];

            int x=unionFindAlgorithm.find(sets,next_edge.src);
            int y=unionFindAlgorithm.find(sets,next_edge.dest);

            if(x!=y){
                result[e++]=next_edge;
                unionFindAlgorithm.union(sets,x,y);
            }
        }
        // print the contents of result[] to display
        // the built MST
        System.out.println("Following are the edges in " +
                "the constructed MST");
        for (int i = 0; i < e; ++i)
            System.out.println(result[i].src+" -- " +
                    result[i].dest+" == " + result[i].weight);

    }
    public static void main(String[] args) {

        Graph g=new Graph(4,5,new Edge[]{
                new Edge(0,1,10),
                new Edge(0,2,6),
                new Edge(0,3,5),
                new Edge(1,3,15),
                new Edge(2,3,4)
        });

        KruskalMST_UnionFind obj=new KruskalMST_UnionFind();

        obj.KruskalMST_UnionFind(g);
    }
}
