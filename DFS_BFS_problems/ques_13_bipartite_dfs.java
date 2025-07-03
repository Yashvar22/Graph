package DFS_BFS_problems;

import java.util.*;

public class ques_13_bipartite_dfs {
  public static boolean dfs(int start,int col,ArrayList<ArrayList<Integer>> adj,int[] color){
    color[start]=col;
    for(int it:adj.get(start)){
       if(color[it]==-1){
        if(dfs(it,1-col,adj,color)==false) return false;
        else if(color[it]==col){
          return false;
        }
       }
    }
    return true;
  }
  public static boolean isBipartite(int V,ArrayList<ArrayList<Integer>> adj){
    int[] color=new int[V];
    Arrays.fill(color, -1);
    for(int i=0;i<V;i++){
      if(color[i]==-1){
        if(!dfs(i,0,adj,color)) return false;
      }
    }
    return true;
  }
  public static void main(String[] args) {
    
  }
}
