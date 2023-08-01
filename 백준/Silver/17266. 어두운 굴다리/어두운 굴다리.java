import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 어두운 굴다리

public class Main {
    
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        solve();
    }
    

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[] lamp = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            lamp[i] = Integer.parseInt(st.nextToken());
        }

        int height = Math.max(lamp[0], N - lamp[M - 1]);

        int start = 0;
        int end = 1;

        while (end < M) {
            height = Math.max(height, (lamp[end] - lamp[start] + 1) / 2);

            start++;
            end++;

        }


        System.out.println(height);

    }
}