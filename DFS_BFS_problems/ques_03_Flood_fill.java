package DFS_BFS_problems;

public class ques_03_Flood_fill {
  public static void dfs(int sr,int sc,int inicolor,int newColor,int[][] ans,int[][] img){
    int[] delRow={-1,0,1,0};
    int[] delCol={0,1,0,-1};
    ans[sr][sc]=newColor;
    int n=img.length;
    int m=img[0].length;
   for(int i=0;i<4;i++){
    int nrow=delRow[i]+sr;
    int ncol=delCol[i]+sc;
    if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && img[nrow][ncol]==inicolor && ans[nrow][ncol]!=newColor ){
        dfs(nrow, ncol, inicolor, newColor, ans, img);
   }
  }
  }
  public static int[][] floodfill(int[][] img,int sr,int sc,int newColor){
    int inicolor=img[sr][sc];
    int[][] ans=img;
    dfs(sr,sc,inicolor,newColor,ans,img);
    return ans;
  }
  public static void main(String[] args) {
     int[][] image =  {
	        {1,1,1},
	        {1,1,0},
	        {1,0,1}
	    };
      int[][] ans = floodfill(image, 1, 1, 2);
        for(int i = 0; i < ans.length; i++){
            for(int j = 0; j < ans[i].length; j++)
                System.out.print(ans[i][j] + " ");
            System.out.println();
        }

  }
}
