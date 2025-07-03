
import java.util.Scanner;

class adjacent_matrix {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // number of nodes
        int m = sc.nextInt(); // number of edges

        int[][] adjMat = new int[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adjMat[u][v] = 1;
            adjMat[v][u] = 1; // because it's an undirected graph
        }

        // Print adjacency matrix
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(adjMat[i][j] + " ");
            }
            System.out.println(); // move to next row
        }

        sc.close();
    }
}
