package DFS_BFS_problems;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS_traversal {
  public static ArrayList<Integer> bfsofGraph(int V,ArrayList<ArrayList<Integer>> adj){
    ArrayList<Integer> bfs=new ArrayList<>();
    boolean[] vis=new boolean[V];
    Queue<Integer> q=new LinkedList<>();
    q.add(0);
    vis[0]=true;
    while(!q.isEmpty()){
      int node=q.poll();
      bfs.add(node);
      for(int it:adj.get(node)){
        if(vis[it]==false){
          vis[it]=true;
         q.add(it);
        }
      }
    
    }
    return bfs;
  }
  public static void main(String[] args) {
        int V = 5;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Sample undirected edges
        addEdge(adj, 0, 1);
        addEdge(adj, 0, 2);
        addEdge(adj, 1, 3);
        addEdge(adj, 2, 4);

        ArrayList<Integer> result = bfsofGraph(V, adj);
        System.out.println("BFS Traversal starting from node 0: " + result);
    }

    public static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u); // Because it's undirected
    }
}
