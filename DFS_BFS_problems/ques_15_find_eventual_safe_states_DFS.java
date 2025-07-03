package DFS_BFS_problems;
import java.util.*;
public class ques_15_find_eventual_safe_states_DFS {
  public static boolean dfs(int node,List<List<Integer>> adj,int[] vis,int[] pathVis,int[] check){
      vis[node]=1;
      pathVis[node]=1;
      check[node]=0;
      for(int it:adj.get(node)){
        if(vis[it]==0){
          if(dfs(it,adj,vis,pathVis,check)==true){
            check[node]=0;
            return true;
          }
        }
          //if node has been previous vis and but it has to vis same path
          else if(pathVis[it]==1){
            check[node]=0;
            return true;
          }
        
        
      }
      check[node]=1;
        //backtrack
        pathVis[node]=0;
        return false;
  }
  public static List<Integer> evenSafeNodes(int V,List<List<Integer>> adj){
     int[] vis=new int[V];
     int[] pathVis=new int[V];
     int[] check=new int[V];//FOR marking of safe Node
    
     for(int i=0;i<V;i++){
      if(vis[i]==0){
        dfs(i,adj,vis,pathVis,check);
      }
      
     }
     List<Integer> ans=new ArrayList<>();
     for(int i=0;i<V;i++){
      if(check[i]==1){
        ans.add(i);
      }
     }
     return ans;
  }
  public static void main(String[] args) {
    
  }
}
