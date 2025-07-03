import java.util.ArrayList;
class Pair{
    int node;
    int wt;
    Pair(int node,int wt){
      this.node=node;
      this.wt=wt;
    }
  }
public class weighted_graph {
  // class Pair{
  //   int node;
  //   int wt;
  //   Pair(int node,int wt){
  //     this.node=node;
  //     this.wt=wt;
  //   }
  // }
  public static void main(String[] args) {
    int V=5;
    ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
    for(int i=0;i<V;i++){
      adj.add(new ArrayList<>());
    }
    addEgde(adj,1,2,4);
    addEgde(adj,1,3,1);
    addEgde(adj,2,4,3);
    addEgde(adj,3,4,2);
    addEgde(adj,4,5,7);
    for (int i = 1; i < V; i++) {
            System.out.print(i + " -> ");
            for (Pair p : adj.get(i)) {
                System.out.print("(" + p.node + ", " + p.wt + ") ");
            }
            System.out.println();
        }
  }
  static void addEgde(ArrayList<ArrayList<Pair>> adj,int u,int v,int w){
        adj.get(u).add(new Pair(v, w));
        adj.get(v).add(new Pair(u, w));
  }
}
