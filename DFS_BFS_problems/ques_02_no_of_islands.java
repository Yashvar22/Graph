package DFS_BFS_problems;

import java.util.LinkedList;
import java.util.Queue;

 class Pair{
    int row;
    int col;
    Pair(int row,int col){
      this.row=row;
      this.col=col;
    }
  }
public class ques_02_no_of_islands {
 

  public static void bfs(int row,int col,int[][] vis,int[][] grid){
    Queue<Pair> q=new LinkedList<>();
    vis[row][col]=1;
    int n=grid.length;
    int m=grid[0].length;
    q.add(new Pair(row,col));

    while(!q.isEmpty()){
      Pair p=q.poll();
      int rw=p.row;
      int cl=p.col;
      
      //traverse in it b=neighbour
    for(int deltaRow = -1; deltaRow <= 1; deltaRow++) {
    for(int delcol = -1; delcol <= 1; delcol++) {
        int nrow = deltaRow + rw;
        int ncol = delcol + cl;

           if (deltaRow == 0 && delcol == 0) continue;
          //check conditions
          if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==0 && grid[nrow][ncol]==1){
            vis[nrow][ncol]=1;
            q.add(new Pair(nrow,ncol));
          }
        }
      }
    }
  }
  public static int NoIsland(int[][] grid){
    int n=grid.length;
    int m=grid[0].length;
    int[][] vis=new int[n][m];
    int cnt=0;
    for(int i=0;i<n;i++){
      for(int j=0;j<m;j++){
        if( vis[i][j]==0 && grid[i][j]==1){
          cnt++;
          bfs(i,j,vis,grid);
        }
      }
    }
    return cnt;
  }
  public static void main(String[] args) {
    int[][] grid = {
            {1, 1, 0, 0, 0},
            {1, 0, 0, 1, 1},
            {0, 0, 1, 0, 0},
            {0, 1, 0, 1, 1},
            {0, 0, 0, 0, 0}
        };
        // Calculate the number of islands
        int result = NoIsland(grid);
        System.out.println("Number of islands: " + result);
  }
}
