package DFS_BFS_problems;

import java.util.*;

public class ques_07_distance_of_nearest_cell_having_one {
  static class Pair{
    int row;
    int col;
    int dis;
    Pair(int row,int col,int dis){
      this.row=row;
      this.col=col;
      this.dis=dis;
    }
  }

  public static int[][] nearest(int[][] grid){
    int n=grid.length;
    int m=grid[0].length;
    int[][] vis=new int[n][m];
    int[][] dist=new int[n][m];
    Queue<Pair> q=new LinkedList<>();
    for(int i=0;i<n;i++){
      for(int j=0;j<m;j++){
        if(grid[i][j]==1){
          q.add(new Pair(i,j,0));
          vis[i][j]=1;
        }
        else{
          vis[i][j]=0;
        }
      }
    }
    int[] delrow={-1,0,1,0};
    int[] delcol={0,1,0,-1};
    while(!q.isEmpty()){
      Pair p=q.poll();
      int row=p.row;
      int col=p.col;
      int steps=p.dis;
      dist[row][col]=steps;
      for(int i=0;i<4;i++){
        int nrow=delrow[i]+row;
        int ncol=delcol[i]+col;
        if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==0){
          vis[nrow][ncol]=1;
          q.add(new Pair(nrow,ncol,steps+1));
        }
      }
    }
    return dist;
  }
  public static void main(String[] args) {
     int[][] grid = {
            {0,1,1,0},
            {1,1,0,0},
            {0,0,1,1}
        };

       
        int[][] ans =nearest(grid);
        for(int i = 0; i < ans.length; i++){
            for(int j = 0; j < ans[i].length; j++){
                System.out.print(ans[i][j] + " "); 
            }
            System.out.println();
        }
  }
}
