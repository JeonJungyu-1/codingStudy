import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// 온라인 판매

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
        int M = Integer.parseInt(st.nextToken());
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(list);
        int maxProfit = Integer.MIN_VALUE;
        int price = 0;

        for (int i = 0; i < M; i++) {
            int curProfit = (M - i) < N ? (M - i) * list.get(i) : N * list.get(i);
            if (maxProfit < curProfit) {
                price = list.get(i);
                maxProfit = curProfit;
            }
        }

        sb.append(price).append(" ").append(maxProfit);
        System.out.println(sb.toString());
    }
}