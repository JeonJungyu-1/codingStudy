import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// 로마 숫자 만들기

public class Main {
    
    static StringBuilder sb;
    static int N;
    static Map<Integer, Integer> map;
    static int[] numbers = {1, 5, 10, 50}; 
    static int result;
    public static void main(String[] args) throws IOException {
        solve();
    }
    
    private static void print() {
        System.out.println(result);
    }

    private static void solve() throws IOException {
        init();
        combination(0, 0, 0);
        print();
    }

    private static void combination(int cnt, int start, int sum) {
        if (cnt == N) {
            if (!map.containsKey(sum)) {
                map.put(sum, 1);
                result++;
            }
            return;
        }

        for (int i = start; i < 4; i++) {
            combination(cnt + 1, i, sum + numbers[i]);
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());

        map = new HashMap<>();

    }
}