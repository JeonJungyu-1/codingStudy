import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 유레카 이론


public class Main {
    
    static StringBuilder sb;
    static List<Integer> numbers;
    static boolean[] visited;
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

        // 중복 조합
        visited = new boolean[1001];
        numbers = new ArrayList<>();
        int n = 1;
        while (true) {
            int re = n * (n + 1) / 2;
            if (re > 1000) break;
            numbers.add(re);
            n++;
        }

        combination(0, 0, 0);


        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int number = Integer.parseInt(br.readLine());
            sb.append(visited[number] ? 1 : 0).append("\n");
        }

        System.out.println(sb.toString());


        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }

    private static void combination(int cnt, int start, int sum) {

        if (cnt == 3) {
            if (sum <= 1000) visited[sum] = true;
            return;
        }



        for (int i = start; i < numbers.size(); i++) {
            combination(cnt + 1, start, sum + numbers.get(i));
        }

    }
}