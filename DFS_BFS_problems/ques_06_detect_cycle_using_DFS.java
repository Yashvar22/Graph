package DFS_BFS_problems;

import java.util.ArrayList;

public class ques_06_detect_cycle_using_DFS {
  public static boolean dfs(int node,int parent,int[] vis,ArrayList<ArrayList<Integer>> adj){
     vis[node]=1;
     for(int it:adj.get(node)){
      if(vis[it]==0){
         if(dfs(it, node, vis, adj) == true) 
                    return true; 
      }
      else if(parent!=it){
        return true;
      }
     }
     return false;
  }
  public  static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
       int vis[] = new int[V]; 
       for(int i = 0;i<V;i++) {
           if(vis[i] == 0) {
               if(dfs(i, -1, vis, adj) == true) return true; 
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
                
       
        boolean ans = isCycle(4, adj);
        if (ans)
            System.out.println("1");    
        else
            System.out.println("0");
  }
}
