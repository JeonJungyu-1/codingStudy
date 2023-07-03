import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

// 물통
// dfs

public class Main {
    
    static StringBuilder sb;
    static int A, B, C, N;
    static Set<Integer> set;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        solve();
    }
    

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        visited = new boolean[201][201];
        set = new TreeSet<>();
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());


        dfs(0, 0, C);

        for (int number : set) {
            sb.append(number).append(" ");
        }

        System.out.println(sb.toString());


    }


    private static void dfs(int a, int b, int c) {
        if (visited[a][b]) return;
        visited[a][b] = true;
        if (a == 0) set.add(c);



        // A -> B
        if (a != 0 && b < B) {
            if (b + a > B) {
                dfs(a - (B - b), B, c);
            } else {
                dfs(0, b + a, c);
            }
        }
        // B -> A
        if (b != 0 && a < A) {
            if (b + a > A) {
                dfs(A, b - (A - a), c);
            } else {
                dfs(a + b, 0, c);
            }
        }
        // A -> C
        if (a != 0 && c < C) {
            if (c + a > C) {
                dfs(a - (C - c), b, C);
            } else {
                dfs(0, b, a + c);
            }
        }
        // C -> A
        if (c != 0 && a < A) {
            if (c + a > A) {
                dfs(A, b, c - (A - a));
            } else {
                dfs(a + c, b, 0);
            }
        }
        // B -> C
        if (b != 0 && c < C) {
            if (c + b > C) {
                dfs(a, b - (C - c), C);
            } else {
                dfs(a, 0, b + c);
            } 
        }
        // C -> B
        if (c != 0 && b < B) {
            if (b + c > B) {
                dfs(a, B, c - (B - b));
            } else {
                dfs(a, b + c, 0);
            }
        }

    }
}