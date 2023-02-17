
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb;
    static boolean[] isVisited;
    static int[] sour;
    static int[] bitter;
    static int minMix;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        isVisited = new boolean[N];
        minMix = Integer.MAX_VALUE;
        sour = new int[N];
        bitter = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
    
            sour[i] = Integer.parseInt(st.nextToken());
            bitter[i] = Integer.parseInt(st.nextToken());

        }
        powerset(0);

        System.out.println(minMix);
        
    }

    static void powerset(int cnt) {
        if (cnt == N) {
            mix();
            return;
        }

        isVisited[cnt] = true;
        powerset(cnt + 1);
        isVisited[cnt] = false;
        powerset(cnt + 1);

    }

    static void mix() {
        int sourMix = 1;
        int bitterMix = 0;
        for (int i = 0; i < N; i++) {
            if (isVisited[i]) {
                sourMix *= sour[i];
                bitterMix += bitter[i];
            } 
        }

        if (sourMix != 1 && bitterMix != 0) {
            minMix = Math.min(minMix, Math.abs(sourMix - bitterMix));
        }
    }
}
