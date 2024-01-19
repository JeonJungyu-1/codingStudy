import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// 카드 합체 놀이

public class Main {
    
    static StringBuilder sb;
    static int n, m;
    static Queue<Long> cardList;
    public static void main(String[] args) throws IOException {
        solve();
    }
    
    private static void print() {

    }

    private static void solve() throws IOException {
        init();

        for (int i = 0; i < m; i++) {
            long a = cardList.poll();
            long b = cardList.poll();
            cardList.offer(a + b);
            cardList.offer(a + b);
        }

        long result = 0;
        while (!cardList.isEmpty()){
            result += cardList.poll();
        }

        System.out.println(result);
        print();
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        cardList = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            cardList.offer(Long.parseLong(st.nextToken()));
        }





        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}