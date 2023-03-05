package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 센서 - 그리디
// 센서간의 거리를 오름차순으로 정렬
// 가장 먼 거리부터 최대 집중국 수 - 1만큼 빼주고 나머지를 더해주면 
// 최대 K개 집중국의 수신 가능 영역 길이의 합의 최솟값을 구할 수 있다

public class BJ2212 {
    static StringBuilder sb;
    static int N, K;
    static int[] sensor;
    static int[] sensorDiff;
    static int min;
    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }
    
    private static void print() {
        System.out.println(min);
    }

    private static void solve() {
        Arrays.sort(sensor);
        for (int i = 0; i < N - 1; i++) {
            sensorDiff[i] = sensor[i + 1] - sensor[i];
        }

        Arrays.sort(sensorDiff);
        for (int i = 0; i < sensorDiff.length - K + 1; i++) {
            min += sensorDiff[i];
        }

    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        sensor = new int[N];
        sensorDiff = new int[N - 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sensor[i] = Integer.parseInt(st.nextToken());
        }





        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}
