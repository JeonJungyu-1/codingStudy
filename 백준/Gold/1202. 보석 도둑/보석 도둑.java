import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;

// 보석 도둑
// 그리디

public class Main {
    
    static StringBuilder sb;
    static int N, K;
    static int[] bag;
    static PriorityQueue<Jewel> jewels;
    static PriorityQueue<Jewel> pq;
    static class Jewel implements Comparable<Jewel> {
        int w;
        int v;

        public Jewel(int w, int v) {
            this.w = w;
            this.v = v;
        }

        @Override
        public int compareTo(Jewel o) {
            int compare = Integer.compare(this.w, o.w);
            return compare == 0 ? -Integer.compare(this.v, o.v) : compare;
        }

    };
    public static void main(String[] args) throws IOException {
        solve();
    }
    


    private static void solve() throws IOException {
        init();
        long sumPrice = 0l;       
        Arrays.sort(bag);

        for (int i = 0; i < bag.length; i++) {
            while (!jewels.isEmpty()) {
                if (bag[i] < jewels.peek().w) break;
                pq.offer(jewels.poll());
            }
            if (!pq.isEmpty()) {
                sumPrice += (long)pq.poll().v;
            }
        }

        System.out.println(sumPrice);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        jewels = new PriorityQueue<>();
        bag = new int[K];
        pq = new PriorityQueue<>((a, b) -> Integer.compare(b.v, a.v));

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            jewels.offer(new Jewel(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        for (int i = 0; i < K; i++) {
            bag[i] = Integer.parseInt(br.readLine());
    }

    }
}