package JavaBook_RobertSadgewick.graph;

public class Graph_Edge_Implementation {

    int V,E;
    Edge edge[];

    public Graph_Edge_Implementation(int v, int e) {
        V = v;
        E = e;
        edge=new Edge[E];
        for(int i=0;i<E;i++){
            edge[i]=new Edge(0,0);
        }


    }
}
