package Algorithms.Graph;

/**
 * Created by mcstarioni on 25.05.2017.
 */
import java.util.Scanner;
import static java.lang.Math.min;

public class Prim {
    int INF = Integer.MAX_VALUE / 2;
    int vNum;
    int[][] graph;

    Prim(int [][] graph)
    {
        this.graph = graph;
        vNum = graph.length;
    }

    int[] mstPrim() {
        boolean[] used = new boolean [vNum];
        int[] dist = new int [vNum];

        fill(dist, INF);
        dist[0] = 0;

        for (;;) {
            int v = -1;
            for (int nv = 0; nv < vNum; nv++)
                if (!used[nv] && dist[nv] < INF && (v == -1 || dist[v] > dist[nv]))
                    v = nv;
            if (v == -1) break;
            used[v] = true;
            for (int nv = 0; nv < vNum; nv++)
                if (!used[nv] && graph[v][nv] < INF)
                    dist[nv] = min(dist[nv], graph[v][nv]);
        }
        return dist;
    }
    void fill(int[] dist, int val)
    {
        for (int i = 0; i < dist.length; i++) {
            dist[i] = val;
        }
    }

    public static void main(String[] args) {
        System.out.println("Введите размер: ");
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[][] graph = new int[N][N];
        System.out.println("Введите граф: ");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                graph[i][j] = scanner.nextInt();
            }
        }
        Prim p = new Prim(graph);
        int[] dist = p.mstPrim();
        for (int i = 0; i < 3; i++) {
            System.out.println(((char)(i+'A'))+" "+ dist[i]);
        }
    }
}
