package LeetCode.graph;

import LeetCode.disjoint_set.Set;
import LeetCode.disjoint_set.UnionFindAlgorithm;

public class CycleDetectionUsingUnionFindAlgo {
    boolean isCycle(Graph_Edge_Implementation g){
            Set[] sets=new Set[g.V];
            for(int i=0;i<sets.length;i++){
                sets[i]=new Set(0,i);
            }
        UnionFindAlgorithm unionFindAlgorithm=new UnionFindAlgorithm();

        for(int i=0;i<g.E;i++){
            int x=unionFindAlgorithm.find(sets,g.edge[i].src);
            int y=unionFindAlgorithm.find(sets,g.edge[i].dest);
            if(x==y)
                return true;
            unionFindAlgorithm.union(sets,x,y);
        }
        return false;
    }

    public static void main(String[] args) {
        Graph_Edge_Implementation g=new Graph_Edge_Implementation(3,2);

        // add edge 0-1
        g.edge[0].src = 0;
        g.edge[0].dest = 1;

        // add edge 1-2
        g.edge[1].src = 1;
        g.edge[1].dest = 2;

        // add edge 0-2 int x=unionFindAlgorithm.find(sets,g.edge[i].src);

        /*
        g.edge[2].src = 2;
        g.edge[2].dest = 0;
        */

        CycleDetectionUsingUnionFindAlgo obj=new CycleDetectionUsingUnionFindAlgo();
        System.out.println(obj.isCycle(g));
    }
}
