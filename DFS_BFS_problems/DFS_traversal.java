package DFS_BFS_problems;

import java.util.ArrayList;

public class DFS_traversal {
  public static void dfs(int node,boolean[] vis,ArrayList<Integer> ls,ArrayList<ArrayList<Integer>> adj){
    vis[node]=true;
    ls.add(node);
    for(int it:adj.get(node)){
      if(!vis[it]){
        dfs(it,vis,ls,adj);
      }
    }
  }
  public static ArrayList<Integer> dfsOfGraph(int V,ArrayList<ArrayList<Integer>> adj){
    boolean[] vis=new boolean[V];
    //vis[0]=true;
    ArrayList<Integer> ll=new ArrayList<>();
    dfs(0,vis,ll,adj);
    return ll;
  }
    public static void main(String[] args) {
        int V = 5; // Number of vertices

        // Create adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Add sample edges
        addEdge(adj, 0, 1);
        addEdge(adj, 0, 2);
        addEdge(adj, 1, 3);
        addEdge(adj, 1, 4);

        ArrayList<Integer> result = dfsOfGraph(V, adj);
        System.out.println("DFS Traversal starting from node 0: " + result);
    }

    // Function to add undirected edge
    public static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
}
