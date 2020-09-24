package codeforces.div3_661;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;
import java.util.PriorityQueue;
import java.util.LinkedList;


public class E1_Weights_division {

    static int dfs(int node, int prev, PriorityQueue<TupleWL> pq) {
        if (adj[node].size() == 1 && adj[node].get(0)[0] == prev) return 1;
        int leaves = 0;
        for (int[] adjacent : adj[node]) {
            if (adjacent[0] == prev) continue;
            int childLeaves = dfs(adjacent[0], node, pq);
            leaves += childLeaves;
            pq.add(new TupleWL(adjacent[1], childLeaves));
        }
        return leaves;
    }
    // graph implementation starts
    static List<int[]> adj[]=new List[100000];
    static void initGraph(){
        for(int i=0;i<100000;i++){
            adj[i]=new LinkedList<>();
        }
    }
    static void clearGraph(int V){
        for(int i=0;i<V;i++)
            if(adj[i].size()!=0)adj[i].clear();
    }
    static void addEdge(int u , int v , int w){
        adj[u].add(new int[]{v,w});
        adj[v].add(new int[]{u,w});
    }
    // graph implementation ends


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String testcases = br.readLine();
        int tc = Integer.parseInt(testcases);
        PriorityQueue<TupleWL> pq = new PriorityQueue<>();
        initGraph();
        for (int i = 0; i < tc; i++) {
            pq.clear();
            int n;
            long S;
            String[] line = br.readLine().split(" ");// Use string tokenizer less time
            n = Integer.parseInt(line[0]);
            clearGraph(n);
            S = Long.parseLong(line[1]);
            String[] edge;
            int u, v, w;

            for (int j = 0; j < n - 1; j++) {
                edge = br.readLine().split(" ");
                u = Integer.parseInt(edge[0]);
                v = Integer.parseInt(edge[1]);
                w = Integer.parseInt(edge[2]);
                addEdge(u - 1, v - 1, w);
            }


            long[] ws=new long[1];
            dfs(0,-1,pq);
            for(TupleWL t:pq){
                ws[0]+=(long)t.W * (long)t.L;
            }
            //Iteratre the pq and find the minimum number of moves required to make the sum just less than S
            int moves = 0;
            while (ws[0] > S) {
                TupleWL t = pq.poll();
                ws[0] -= ((long)(t.L)*(long)(t.W));
                ws[0] += (long)(t.L)*(long)(t.W/2);
                pq.add(new TupleWL( t.W/2 , t.L ));
                moves += 1;
            }
            pw.println(moves);
        }
        pw.close();
    }
}
class Tuple implements Comparable<TupleWL>{// for priority queue
    int W;
    int L;
    long comparison;
    Tuple(int W,int L){
        this.W=W;
        this.L=L;
        this.comparison=((long)this.L * ((long)this.W)) - ((long)this.L * ((long)this.W/2));
    }
    @Override
    public int compareTo(TupleWL t){
        if( this.comparison >= t.comparison  )return -1;// Max Heap with Priority for higher element defined
        return 1;
    }
}
