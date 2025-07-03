package DFS_BFS_problems;

import java.util.ArrayList;

public class ques_01_no_of_provinces {
  public static void dfs(int node,boolean[] vis,int[][] isConnected){
    vis[node]=true;
    for(int i=0;i<isConnected.length;i++){
      if(isConnected[node][i]==1 && vis[i]==false){
        dfs(node, vis, isConnected);
      }
    }
  }
  public static int noProvinces(int[][] isConnected,int V){
     int n=isConnected.length;
     boolean[] vis=new boolean[V];
     int cnt=0;
     for(int i=0;i<V;i++){
      if(vis[i]==false){
        cnt++;
        dfs(i,vis,isConnected);
      }
     }
     return cnt;
  }
  public static void main(String[] args) {
     int[][] isConnected = {
      {1, 1, 0, 0},
      {1, 1, 0, 0},
      {0, 0, 1, 1},
      {0, 0, 1, 1}
    };
    int V = isConnected.length; // Number of provinces
    // Calculate the number of provinces
    int result = noProvinces(isConnected, V);
    System.out.println("Number of provinces: " + result);
  }

}
