import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ConnectedComponent {
  public static void bfs(int node,boolean[] vis,ArrayList<ArrayList<Integer>> adj){
    vis[node]=true;
    Queue<Integer> q=new LinkedList<>();
    q.add(node);
    while(!q.isEmpty()){
      int temp=q.poll();
      for(int it:adj.get(temp)){
        if(vis[it]=false){
          vis[it]=true;
          q.add(it);
        }
      }
    }
  }
  public static int countComponent(int V, ArrayList<ArrayList<Integer>> adj){
    boolean[] vis= new boolean[V+1];
    int cnt=0;
    for(int i=1;i<=V;i++){
      cnt++;
      bfs(i,vis,adj);

    }
    return cnt;
  }
  public static void main(String[] args) {
    int V = 5;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            adj.add(new ArrayList<>());
        }

        // Sample edges (undirected)
        addEdge(adj, 1, 2);
        addEdge(adj, 2, 3);
        addEdge(adj, 4, 5);

        int result = countComponent(V, adj);
        System.out.println("Number of connected components: " + result);

    }
    public static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
}
