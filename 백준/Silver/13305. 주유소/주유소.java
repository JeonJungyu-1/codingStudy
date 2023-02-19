import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 주유소 - 그리디
// 1. 이전 도시의 가격보다 낮거나 같으면 바로 계산
// 2. 이전 도시의 가격보다 높다면 낮거나 같은 도시가 나올때까지 거리 누적후에 계산
public class Main {
    static StringBuilder sb;
    static int N;
    static int[] distance, city;
    static int minPrice;
    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }
    
    private static void print() {
        System.out.println(minPrice);
    }

    private static void solve() {
        int beforePrice = Integer.MAX_VALUE;
        int cumulativeDistance = 0;
        for (int i = 0; i < city.length; i++) {
            if (beforePrice >= city[i]) {
                minPrice += (cumulativeDistance * beforePrice);
                beforePrice = city[i];
                cumulativeDistance = 0;
            }

            if (i < distance.length) cumulativeDistance += distance[i];
        }

    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        distance = new int[N - 1];
        city = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N - 1; i++) {
            distance[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            city[i] = Integer.parseInt(st.nextToken());
        }

        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}