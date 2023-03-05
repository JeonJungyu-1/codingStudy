package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 잃어버린 괄호 - 그리디
// 최소 값이 나오려면 + 계산을 먼저 끝내고 - 계산을 해야함
// 1. 먼저 -를 기준으로 문자열을 나눔
// 2. 나누어진 문자열을 + 기준으로 나누어서 계산
// 3. 계산된 문자열들을 모아서 - 계산을 함
public class BJ1541 {
    static StringBuilder sb;
    static List<String> str;
    static int[] numbers;
    static int result;
    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }
    
    private static void print() {
        System.out.println(result);
    }

    private static int calPlus(String string) {
        int sum = 0;
        StringTokenizer st = new StringTokenizer(string, "+");
        while (st.hasMoreTokens()) {
            sum += Integer.parseInt(st.nextToken());
        }
        return sum;
    }

    private static void solve() {
        calMinus();
    }

    private static void calMinus() {
        result = calPlus(str.get(0));
        for (int i = 1; i < str.size(); i++) {
            result -= calPlus(str.get(i));
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), "-");
        sb = new StringBuilder();
        str = new ArrayList<>();
        while (st.hasMoreTokens()) {
            str.add(st.nextToken());
        }

        numbers = new int[str.size()];



        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}
