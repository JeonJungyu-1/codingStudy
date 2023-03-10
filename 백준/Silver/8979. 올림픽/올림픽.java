import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb;
    static int N, K;
    static Medal[] list;
    static class Medal implements Comparable<Medal> {
        int country, g, s, b;

        

        public Medal(int country, int g, int s, int b) {
            this.country = country;
            this.g = g;
            this.s = s;
            this.b = b;
        }



        @Override
        public int compareTo(Medal o) {
            if (this.g != o.g) {
                return Integer.compare(this.g, o.g);
            } else if (this.s != o.s) {
                return Integer.compare(this.s, o.s);
            } else {
                return Integer.compare(this.b, o.b);
            }
        }
        
    }
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }
    

    private static void solve() {
        Arrays.sort(list);
        int rank = 1;
        for (int i = 0; i < list.length - 1; i++) {
            if (list[i].country == K) break;
            if (list[i].g == list[i + 1].g && list[i].s == list[i + 1].s && list[i].b == list[i + 1].b) continue;
            rank++;
        }

        System.out.println(rank);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        list = new Medal[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[i] = new Medal(c, g, s, b);
        }


    }
}