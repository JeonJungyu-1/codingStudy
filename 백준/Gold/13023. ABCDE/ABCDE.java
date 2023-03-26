import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// ABCDE
// 인접리스트를 이용해서 그래프탐색하기

public class Main {
    
    StringBuilder sb;
    List<List<Integer>> adjList;
    int N, M;
    boolean[] visited;
    int result;
    
    private void print() {
        System.out.println(result);
    }

    private void solve() throws IOException {
        init();

        for (int i = 0; i < N; i++) {
            visited[i] = true;
            exploreFriend(0, i);
            visited[i] = false;
        }
        print();

    }

    private void exploreFriend(int cnt, int pre) {
        if (result == 1) return;
        if (cnt == 4) {
            result = 1;
            return;
        }


        for (int next : adjList.get(pre)) {
            if (visited[next]) continue;
            visited[next] = true;
            exploreFriend(cnt + 1, next);
            visited[next] = false;

        }
    }

    private void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        adjList = new ArrayList<>();
        for (int i = 0; i < N; i ++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            adjList.get(s).add(e);
            adjList.get(e).add(s);
        }


        visited = new boolean[N];
        result = 0;
    }


    public static void main(String[] args) throws IOException {
        new Main().solve();
    }
}