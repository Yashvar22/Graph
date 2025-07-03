package DFS_BFS_problems;

import java.util.*;

public class ques_05_detect_cycle_BFS {
   static class Pair{
    int node;
    int parent;
    Pair(int node,int parent){
      this.node=node;
      this.parent=parent;
    }
   }
   
   public static boolean bfs(int node,ArrayList<ArrayList<Integer>> adj,boolean[] vis){
           vis[node]=true;
           Queue<Pair> q=new LinkedList<>();
           q.add(new Pair(node,-1));

           while(!q.isEmpty()){
            Pair p=q.poll();
            int temp=p.node;
            int parent=p.parent;

            for(int it:adj.get(temp)){
              if(!vis[it]){
                vis[it] = true; 
                q.add(new Pair(it,temp));
              }
              else if(it!=parent){
                return true;
              }
            }
           }
           return false;
   }
   public static boolean detectCycle(int V,ArrayList<ArrayList<Integer>> adj){
    boolean[] vis=new boolean[V];
    for(int i=0;i<V;i++){
      if(!vis[i]){
        if(bfs(i,adj,vis)==true) return true;
      }
    }
    return false;
   }
  public static void main(String[] args) {
    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            adj.add(new ArrayList < > ());
        }
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);
                
       
        boolean ans = detectCycle(4, adj);
        if (ans)
            System.out.println("1");    
        else
            System.out.println("0");
  }
}
