import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int V, E;
    static int[][] adj;
    static int[][] distance;
    static int[] count;
    static final int INF = -1;
    public static void main(String[] args) throws NumberFormatException, IOException {
        init();
        solve();
        print();
    }
    private static void print() {

        for (int i = 1; i < V + 1; i++) {
            int cnt = 0;
            for (int j = 1; j < V + 1; j++) {
                if (distance[i][j] == 1 || distance[j][i] == 1) cnt++;
            }
            count[i] = V - 1 - cnt;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < V + 1; i++) {
            sb.append(count[i]).append("\n");
        }
        System.out.println(sb.toString());
    }
    private static void solve() {
        for (int i = 1; i < V + 1; i++) {
            for (int j = 1; j < V + 1; j++) {
                if (i == j) {
                    distance[i][j] = 0;
                } else if (adj[i][j] == 0) {
                    distance[i][j] = INF;
                } else {
                    distance[i][j] = adj[i][j];
                }
            }
        }


        for (int k = 1; k < V + 1; k++) {
            for (int i = 1; i < V + 1; i++) {
                for (int j = 1; j < V + 1; j++) {
                    if (i == j) continue;
                    if (distance[i][k] != INF && distance[k][j] != INF) {
                        distance[i][j] = 1;
                    }
                }
            }
        }

    }
    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        V = Integer.parseInt(br.readLine());
        E = Integer.parseInt(br.readLine());
        count = new int[V + 1];
        adj = new int[V + 1][V + 1];
        distance = new int[V + 1][V + 1];
        // Arrays.fill(count, V - 1);

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            adj[from][to] = 1;
        }

    }
}