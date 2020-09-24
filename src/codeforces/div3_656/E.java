package codeforces.div3_656;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
 
public class E{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);    
        String testcases = br.readLine();
        int TC = Integer.parseInt(testcases); 
        PriorityQueue<Pair> q=new PriorityQueue<>();
        for (int tc = 0; tc < TC; tc++){
            String[] line = br.readLine().split(" ");// Use string tokenizer less time
            int V,K;
            V=Integer.parseInt(line[0]);
            K=Integer.parseInt(line[1]);
            ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
            for(int i=0;i<V;i++)
                adj.add(new ArrayList<Integer>());

            int[] degree=new int[V];
            int[] noOfLeaves=new int[V];
            q.clear();
           
            int S,D;
            
            for(int i=0;i<V-1;i++){
                line=br.readLine().split(" ");
                S=Integer.parseInt(line[0]);
                D=Integer.parseInt(line[1]);
                --S;
                --D;
                adj.get(S).add(D);
                adj.get(D).add(S);
                degree[S]+=1;
                degree[D]+=1;
            }

            for(int i=0;i<adj.size();i++){
                int count=0;
                for(int j:adj.get(i)){
                    if(degree[j]==1)
                        count+=1;
                }
                noOfLeaves[i]=count;
                if(adj.get(i).size()>=K){
                    q.add(new Pair(i,count));
                }
            }


            // System.out.println("Q size is ->"+q.size());
            int moves=0;

            while(q.size()!=0){
                int Vertex=q.peek().V;
                int Leaves=q.peek().L;
                q.poll();
                
                if(Leaves>=K){
                    int count=0;
                    for(int i=0;i<adj.get(Vertex).size();i++){
                        if(count>K)break;//Remove exactly K in 1 move
                        if(degree[i]==1){
                            count+=1;
                            degree[Vertex]-=1;
                            degree[i]-=1;
                            adj.get(Vertex).remove(i);//edge removed from parent
                            adj.get(i).remove(Vertex);//edge removed from leaf
                        }    
                    }
                    if(degree[Vertex]==1){
                        // This has become leaf node and its parent must be updated with latest leaves statistics in pq
                        int affected=adj.get(Vertex).get(0);
                        q.remove(affected);
                        q.add(new Pair(affected,noOfLeaves[affected]+1));
                    }


                    if(degree[Vertex]>=K){
                        q.add(new Pair(Vertex,Leaves-count));
                    }
                    moves+=1;
                }
            }
            if(K==1){
                moves=V-1;
            }
            pw.println(moves);
        }
         pw.flush();
         pw.close();
    }
}

class Pair implements Comparable<Pair>{
    int V;
    int L;
    Pair(int V,int L){
        this.V=V;
        this.L=L;
    }
    
    public int compareTo(Pair p){
        if(this.L>=p.L)return -1;
        return 1;
    }

}