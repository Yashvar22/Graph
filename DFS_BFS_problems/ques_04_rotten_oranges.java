package DFS_BFS_problems;

import java.util.LinkedList;
import java.util.Queue;

public class ques_04_rotten_oranges {
  static class Pair{
    int row;
    int col;
    int move;
    Pair(int row,int col,int move){
      this.row=row;
      this.col=col;
      this.move=move;
    }
  }
  public static int rottenOrange(int[][] grid){
    int n=grid.length;
    int m=grid[0].length;
    Queue<Pair> q=new LinkedList<>();
    int[][] vis=new int[n][m];
    for(int i=0;i<n;i++){
      for(int j=0;j<m;j++){
        if(grid[i][j]==2){
          q.add(new Pair(i,j,0));
          vis[i][j]=2;
        }
        else{
           vis[i][j]=0;
        }
      }
    }
    int time=0;
    int[] delRow={-1,0,1,0};
    int[] delcol={0,1,0,-1};
    while(!q.isEmpty()){
      Pair p=q.poll();
      int row=p.row;
      int col=p.col;
      int t=p.move;
      time=Math.max(t,time);
      for(int i=0;i<4;i++){
        int nrow=delRow[i]+row;
        int ncol=delcol[i]+col;
        if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]!=2 && grid[nrow][ncol]==1){
          q.add(new Pair(nrow,ncol,t+1));
          vis[nrow][ncol]=2;
        }
      }
    }
    for(int i=0;i<n;i++){
      for(int j=0;j<m;j++){
        if(vis[i][j]!=2 && grid[i][j]==1){
          return -1;
        }
      }
    }
    return time;
  }
  public static void main(String[] args) {
    int arr[][]={ {2,1,1} , {1,1,0} , {0,1,1} };
        int rotting = rottenOrange(arr);
        System.out.println("Minimum Number of Minutes Required "+rotting);
  }
}
