package DFS_BFS_problems;

import java.util.*;

public class ques_10_no_of_enclaves {
  static class Pair{
    int row;
    int col;
    Pair(int row,int col){
      this.row=row;
      this.col=col;
    }
  }
  public static int noofEnclave(int[][] grid){
    int n=grid.length;
    int m=grid[0].length;
    int[][] vis=new int[n][m];
    Queue<Pair> q=new LinkedList<>();
    for(int i=0;i<n;i++){
      for(int j=0;j<m;j++){
        if(i==0 || j==0 || i==n-1||j==m-1){
           if(grid[i][j]==1){
            vis[i][j]=1;
            q.add(new Pair(i,j));
           }
        }
      }
    }
    int[] delRow={-1,0,1,0};
    int[] delcol={0,1,0,-1};
    while(!q.isEmpty()){
      Pair p=q.poll();
      int row=p.row;
      int col=p.col;

      for(int i=0;i<4;i++){
        int nrow=delRow[i]+row;
        int ncol=delcol[i]+col;
        if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==0 && grid[nrow][ncol]==1){
          q.add(new Pair(nrow,ncol));
          vis[nrow][ncol]=1;
        }
      }
    }
      int cnt=0;
      for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
          if(vis[i][j]==0 && grid[i][j]==1){
            cnt++;
          }
        }
      }
      return cnt;
    }
  
  public static void main(String[] args) {
    {
        int grid[][] = {
        {0, 0, 0, 0},
        {1, 0, 1, 0},
        {0, 1, 1, 0},
        {0, 0, 0, 0}};

        
        int ans = noofEnclave(grid);
        System.out.println(ans);
    }
  }
}
