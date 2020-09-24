package codeforces.div3_661;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.LinkedList;

/// Remember to take care of long overflow during multiplication ////

// This is a really really good question  (Tutorial referred :( )
public class E2_Weights_division {

    static int dfs(int node, int prev, PriorityQueue<TupleWL> pq1, PriorityQueue<TupleWL> pq2, long[] arr){
        if (adj[node].size() == 1 && adj[node].get(0)[0] == prev) return 1;//child node
        int leaves = 0;
        for (int[] adjacent : adj[node]){
            if (adjacent[0] == prev) continue;
            int childLeaves = dfs(adjacent[0], node, pq1,pq2,arr);
            leaves += childLeaves;
            if(adjacent[2]==1){
                arr[0]+=(long)adjacent[1]*(long)childLeaves;
                pq1.add(new TupleWL(adjacent[1], childLeaves));
            }else {
                arr[1]+=(long)adjacent[1]*(long)childLeaves;
                pq2.add(new TupleWL(adjacent[1], childLeaves));
            }
        }
        return leaves;
    }

    static ArrayList<Long> generateSums(long coinSum,PriorityQueue<TupleWL> pq){
            ArrayList<Long> temp=new ArrayList<>();
            temp.add(coinSum);
            while(coinSum>0 && pq.size()>0){
                TupleWL t = pq.poll();
                coinSum -= ((long)(t.L)*(long)(t.W));
                coinSum += (long)(t.L)*(long)(t.W/2);
                temp.add(coinSum);
                pq.add(new TupleWL( t.W/2 , t.L ));
            }
            return temp;
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
    static void addEdge(int u , int v , int w, int c){
        adj[u].add(new int[]{v,w,c});
        adj[v].add(new int[]{u,w,c});
    }
    // graph implementation ends
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String testcases = br.readLine();
        int tc = Integer.parseInt(testcases);
        PriorityQueue<TupleWL> pq1 = new PriorityQueue<>();
        PriorityQueue<TupleWL> pq2 = new PriorityQueue<>();
        initGraph();
        for (int TC = 0; TC < tc; TC++) {
            pq1.clear();
            pq2.clear();
            int n;
            long S;
            String[] line = br.readLine().split(" ");// Use string tokenizer less time
            n = Integer.parseInt(line[0]);
            clearGraph(n);
            S = Long.parseLong(line[1]);
            String[] edge;
            int u, v, w,c;

            for (int j = 0; j < n - 1; j++) {
                edge = br.readLine().split(" ");
                u = Integer.parseInt(edge[0]);
                v = Integer.parseInt(edge[1]);
                w = Integer.parseInt(edge[2]);
                c = Integer.parseInt(edge[3]);
                addEdge(u - 1, v - 1, w, c);
            }
            long[] oneTwoCoins=new long[2];
            dfs(0,-1,pq1,pq2,oneTwoCoins);

            ArrayList<Long> arr1=generateSums(oneTwoCoins[0],pq1);
            ArrayList<Long> arr2=generateSums(oneTwoCoins[1],pq2);
            //// Two Pointer approach for finding the minimum number of coins
            long ans=Long.MAX_VALUE;
            int j=arr2.size()-1;
            for(int i=0;i<arr1.size();i++){
                while(j>0 && arr1.get(i) + arr2.get(j-1) <=S) --j;
                if(arr1.get(i) + arr2.get(j) <=S){
                    ans=Math.min(ans,i+2*j);
                }
            }
            System.out.println(ans);
        }
        pw.close();
    }
}
class TupleWL implements Comparable<TupleWL>{// for priority queue
    int W;
    int L;
    long comparison;
    TupleWL(int W, int L){
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
