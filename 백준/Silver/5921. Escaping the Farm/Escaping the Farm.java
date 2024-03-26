import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Escaping the Farm

public class Main {
    
    static StringBuilder sb;
    static int N;
    static boolean[] visited;
    static String[] cow;
    static int max;
    public static void main(String[] args) throws IOException {
        solve();
    }
    
    private static void print() {

    }

    private static void solve() throws IOException {
        init();
        print();
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        visited = new boolean[N];

        cow = new String[N];
        for (int i = 0; i < N; i++) {
            cow[i] = br.readLine();
        }
        max = Integer.MIN_VALUE;

        dfs(0, 0, 0);
        System.out.println(max);


        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }


    private static void dfs(int cnt, int sum, int count) {
        if (cnt == N) {
            max = Math.max(max, count);

            return;
        }



        if (isPass(cnt, sum)) {
            dfs(cnt + 1, sum + Integer.parseInt(cow[cnt]), count + 1);
        }

        dfs(cnt + 1, sum, count);




    }


    private static boolean isPass(int i, int sum) {
            if (sum == 0) {
                sum = Integer.parseInt(cow[i]);
                return true;
            }

            char[] a = String.valueOf(sum).toCharArray();
            char[] b = cow[i].toCharArray();

            int j = a.length - 1;
            int k = b.length - 1;
            boolean isFail = false;
            while (true) {
                if (j < 0 || k < 0) break;

                if (((a[j] - '0') + (b[k] - '0')) >= 10) {
                    isFail = true;
                    break;
                }
                j--;
                k--;
            }

            if (isFail) {
                return false;
            }

            return true;

    }

    private static void subset(int n, int trueCnt) {
            if ((trueCnt + N - 1 - n) < max) return;


            if (n == N) {
                int cnt = 1;
                int sum = 0;
                char[] a;
                char[] b;
                for (int i = 0; i < N; i++) {
                    if (!visited[i]) continue;

                    if (sum == 0) {
                        sum = Integer.parseInt(cow[i]);
                        continue;
                    }

                    a = String.valueOf(sum).toCharArray();
                    b = cow[i].toCharArray();

                    int j = a.length - 1;
                    int k = b.length - 1;
                    boolean isFail = false;
                    while (true) {
                        if (j < 0 || k < 0) break;

                        if (((a[j] - '0') + (b[k] - '0')) >= 10) {
                            isFail = true;
                            break;
                        }
                        j--;
                        k--;
                    }

                    if (isFail) {
                        break;
                    }

                    sum += Integer.parseInt(cow[i]);
                    cnt++;

                }

                max = Math.max(max, cnt);

                return;
            }
        
            visited[n] = true;
            subset(n + 1, trueCnt + 1);
            visited[n] = false;
            subset(n + 1, trueCnt);

    }
}