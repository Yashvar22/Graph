package DFS_BFS_problems;

import java.util.*;

public class ques_08_detect_cycle_in_2D_grid {
  static class Pair{
    int row;
    int col;
    int pr;
    int pc;
    Pair(int row,int col,int pr,int pc){
      this.row=row;
      this.col=col;
      this.pr=pr;
      this.pc=pc;
    }
  }
  public static boolean bfs(int row,int col,boolean[][] vis,char[][] grid){
     int n=grid.length;
    int m=grid[0].length;
    int[] delRow={-1,0,1,0};
    int[] delcol={0,1,0,-1};
    
    char ch=grid[row][col];
   Queue<Pair> q=new LinkedList<>();
    q.add(new Pair(row,col,-1,-1));
    vis[row][col]=true;
    while(!q.isEmpty()){
      Pair p=q.poll();
      int r=p.row;
      int c=p.col;
      for(int i=0;i<4;i++){
        int nrow=delRow[i]+r;
        int ncol=delcol[i]+c;
        if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]==ch){
          if(!vis[nrow][ncol]){
            vis[nrow][ncol]=true;
            q.add(new Pair(nrow,ncol,r,c));
          }
          else if(nrow!=p.pr && ncol!=p.pc){
            return true;
          }
        }
      }
    }
    return false;
  }
  public boolean detectCycle(char[][] grid){
    int n=grid.length;
    int m=grid[0].length;
    boolean[][] vis=new boolean[n][m];
    for(int i=0;i<n;i++){
      for(int j=0;j<m;j++){
        if(!vis[i][j]){
          if(bfs(i,j,vis,grid)){
            return true;
          }
        }
      }
    }
    return false;
  }
  public static void main(String[] args) {
    
  }
}
