import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 연결 요소의 개수 - 연결리스트 만들어서 dfs 이용
public class Main {
    static int N, M;
    static List<List<Integer>> list;
    static boolean[] isVisited;
    static int count;
    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }
    private static void print() {
        System.out.println(count);
    }
    private static void solve() {
        for (int i = 1; i < N + 1; i++) {
            if (isVisited[i]) continue;            
            dfs(i);
            count++;
        }
    }

    //dfs
    private static void dfs(int num) {
        List<Integer> li = list.get(num);
        for (int i = 0; i < li.size(); i++) {
            int newNum = li.get(i);
            if (isVisited[newNum]) continue;
            isVisited[newNum] = true;
            dfs(newNum);
        }
    }
    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        isVisited = new boolean[N + 1];
        for (int i = 0; i < N + 1; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            list.get(n).add(m);
            list.get(m).add(n);
        }
    }
}