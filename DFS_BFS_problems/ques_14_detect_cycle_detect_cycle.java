package DFS_BFS_problems;

import java.util.*;

public class ques_14_detect_cycle_detect_cycle {
  public static boolean dfs(int node,ArrayList<ArrayList<Integer>> adj,boolean[] vis,boolean[] pathvis){
    vis[node]=true;
    pathvis[node]=true;
    for(int it:adj.get(node)){
      if(vis[it]==false){
        if(dfs(it,adj,vis,pathvis)) return true;
      }
      else if(pathvis[it]==true){
        return true;
      }
    }
    pathvis[node]=false; //bactrack;
    return false;
  }
  public static boolean isCycle(int V,ArrayList<ArrayList<Integer>> adj){
    boolean[] vis=new boolean[V];
    boolean[] pathvis=new boolean[V];
    for(int i=0;i<V;i++){
      if(!vis[i]){
        if(dfs(i,adj,vis,pathvis)) return true;
      }
    }
    return false;
  }
  public static void main(String[] args) {
    
  }
}
