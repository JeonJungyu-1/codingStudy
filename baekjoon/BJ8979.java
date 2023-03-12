package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

//올림픽

public class BJ8979 {
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
            } else {
                if (this.s != o.s) {
                    return Integer.compare(this.s, o.s);
                } else {
                    if (this.b != o.b) {
                        return Integer.compare(this.b, o.b);
                    } else {
                        return Integer.compare(this.country, o.country);
                    }
                    
                }
            }
        }



        @Override
        public String toString() {
            return "Medal [country=" + country + ", g=" + g + ", s=" + s + ", b=" + b + "]";
        }

        
        
    }
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }
    

    private static void solve() {
        Arrays.sort(list, Collections.reverseOrder());
        int rank = 1;
        for (int i = 0; i < list.length; i++) {
            if (i != 0 && (list[i].g != list[i - 1].g || list[i].s != list[i - 1].s || list[i].b != list[i - 1].b)) {
                rank = i + 1;
            } 
            if (list[i].country == K) break;
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
