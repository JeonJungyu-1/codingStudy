import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

// 원자의 에너지
// 트리 dp

public class Main {
    static int N, M;
    static int[] atom;
    static Map<Integer, Integer> atomIndex;
    static int[] proton;
    static int[][] dp;
    static boolean[] visited;
    static List<ArrayList<Integer>> adj;
    static int maxEnergy;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        atom = new int[N];
        proton = new int[M];
        atomIndex = new HashMap<>();

        for (int i = 0; i < N; i++) {
            atom[i] = Integer.parseInt(br.readLine());
            atomIndex.put(atom[i], i);
        }

        for (int i = 0; i < M; i++) {
            proton[i] = Integer.parseInt(br.readLine());
        }

        dp = new int[N][2];

        adj = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < atom.length; i++) {
            for (int j = 0; j < proton.length; j++) {
                if (atom[i] - proton[j] > 0 && atomIndex.containsKey(atom[i] - proton[j])) {
                    adj.get(i).add(atomIndex.get(atom[i] - proton[j]));
                    adj.get(atomIndex.get(atom[i] - proton[j])).add(i);
                }
            }
        }
        

        maxEnergy = Integer.MIN_VALUE;

        visited = new boolean[N];
        dfs(0, -1);

        System.out.println(maxEnergy);




    }
    private static void dfs(int cur, int prev) {
        if (visited[cur]) return;
        visited[cur] = true;
        dp[cur][1] = atom[cur];
        dp[cur][0] = 0;

        for (int next : adj.get(cur)) {
            if (next != prev) {
                dfs(next, cur);
                dp[cur][1] += dp[next][0];
                dp[cur][0] += Math.max(dp[next][0], dp[next][1]);
                maxEnergy = Math.max(dp[cur][1], dp[cur][0]);
            }
        }
    }
   
}