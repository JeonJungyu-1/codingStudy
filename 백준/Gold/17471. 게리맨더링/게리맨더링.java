import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    // 부분집합 
    // 모든 경우의 수
    // 정점에 대한 부분집합
    static int N;
    static int[] city;
    static List<List<Integer>> adj;
    static int aSum, bSum;
    static int min;
    static boolean[] isSelected;
    static boolean[] v;
    static class Edge {
        int s;
        int e;
        public Edge(int s, int e) {
            this.s = s;
            this.e = e;
        }
        @Override
        public String toString() {
            return "Edge [s=" + s + ", e=" + e + "]";
        }

        
        
    }


    public static void main(String[] args) throws NumberFormatException, IOException {
        init();
        solve();
        print();
    }



    private static void print() {
        if (min == Integer.MAX_VALUE) {
            min = -1;
        }
        System.out.println(min);
    }



    private static void solve() {
        subset(1);
    }

    private static void subset(int cnt) {
        if (cnt == city.length) {

            if (divide()) {
                min = Math.min(min, Math.abs(aSum - bSum));
            }
            
            return;
        }
        
        isSelected[cnt] = true;
        subset(cnt + 1);
        isSelected[cnt] = false;
        subset(cnt + 1);
        
        
    }
    
    
    private static boolean divide() {
        
        List<Integer> aList = new ArrayList<>();
        List<Integer> bList = new ArrayList<>();
        v = new boolean[N + 1];
        aSum = 0;
        bSum = 0;
        
        for (int i = 1; i <= N; i++) {
            if (isSelected[i]) {
                aList.add(i);
                aSum += city[i];
            } else {
                bList.add(i);
                bSum += city[i];
            }
        }

        if (aList.size() == 0 || bList.size() == 0) return false;

        bfs(aList.get(0), true);
        bfs(bList.get(0), false);

        for (int i = 1; i <= N; i++) {
            if (!v[i]) return false;
        }


        return true;
    }



    private static void bfs(int s, boolean selectCheck) {
        Queue<Integer> que = new ArrayDeque<>();
        que.offer(s);
        v[s] = true;

        while (!que.isEmpty()) {
            int start = que.poll();

            List<Integer> li = adj.get(start);
            for (int i = 0; i < li.size(); i++) {
                int e= li.get(i);
                if (v[e] || isSelected[e] != selectCheck) continue;
                que.offer(e);
                v[e] = true;
            }
        }
    }


    private static void init() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        city = new int[N + 1];
        min = Integer.MAX_VALUE;
        isSelected = new boolean[N + 1];
        adj = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            city[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            for (int j = 0; j < n; j++) {
                int e = Integer.parseInt(st.nextToken());
                adj.get(i).add(e);
            }
        }


    }
}