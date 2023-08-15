import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// 겹치는 건 싫어

public class Main {
    
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        solve();
    }
 

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());


        int start = 0;
        int end = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int[] numbers = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;
        int max = Integer.MIN_VALUE;

        while (end < N) {
            map.put(numbers[end], map.getOrDefault(numbers[end], 0) + 1);
            cnt++;
            if (map.get(numbers[end]) > K) {
                while (map.get(numbers[end]) > K) {
                    map.put(numbers[start], map.get(numbers[start]) - 1);
                    cnt--;
                    start++;
                }
            }
            end++;
            max = Math.max(max, cnt);
        }

        System.out.println(max);



    }
}