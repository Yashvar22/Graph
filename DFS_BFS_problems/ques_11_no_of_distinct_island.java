package DFS_BFS_problems;

import java.util.*;

public class ques_11_no_of_distinct_island {
  public static void dfs(int r0,int c0,int r, int c,int[][] grid,boolean[][] vis,ArrayList<String> path){
    int n=grid.length;
    int m=grid[0].length;
     vis[r][c]=true;
     path.add((r-r0)+ " " + (c-c0));
     int[] dr={-1,1,0,0};
     int[] dc={0,0,-1,1};
     for(int i=0;i<4;i++){
      int nrow=dr[i]+r;
      int ncol=dc[i]+c;
      if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && !vis[nrow][ncol] && grid[nrow][ncol]==1){
        dfs(r0,c0,nrow,ncol,grid,vis,path);
      }
     }
  }
  public static int countDistinctIsland(int[][] grid){
    int n=grid.length;
    int m=grid[0].length;
    boolean[][] vis=new boolean[n][m];
    Set<String> shapes=new HashSet<>();
    for(int i=0;i<n;i++){
      for(int j=0;j<m;j++){
        if(grid[i][j]==1 && vis[i][j]==false){
          ArrayList<String> path=new ArrayList<>();
          dfs(i,j,i,j,grid,vis,path);
          shapes.add(String.join(" ,", path));
        }
      }
    }
    return shapes.size();
  }
  public static void main(String[] args) {
  
  }
}
