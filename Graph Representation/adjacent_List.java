import java.util.ArrayList;
import java.util.Scanner;

public class adjacent_List {
  public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
    int V=5;
    int m=6;
    ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
    for(int i=0;i<V;i++){
      adj.add(new ArrayList<>());
    }
    for(int i=0;i<m;i++){
     int u=sc.nextInt();
     int v=sc.nextInt();
     adj.get(u).add(v);
     adj.get(v).add(u);

    }
    for(int i=1;i<=V;i++){
      System.out.println(i+" ");
      for(int node:adj.get(i)){
        System.out.println(node+" ");
      }
      System.out.println();
    }
  }
}
