import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// 수 정렬하기 5

public class Main {
    
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        solve();
    }
    

    // 우선순위큐
    // private static void solve() throws IOException {
    //     System.setIn(new FileInputStream("baekjoon/a.txt"));
    //     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //     StringTokenizer st;
    //     sb = new StringBuilder();
    //     int N = Integer.parseInt(br.readLine());
    //     Queue<Integer> pq = new PriorityQueue<>();

    //     for (int i = 0; i < N; i++) {
    //         pq.offer(Integer.parseInt(br.readLine()));
    //     }

    //     while (!pq.isEmpty()) {
    //         sb.append(pq.poll()).append("\n");
    //     }

    //     System.out.println(sb.toString());
    // }

    // 동적배열
    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(list);
        for (int i = 0; i < N; i++) {
            sb.append(list.get(i)).append("\n");
        }

        System.out.println(sb.toString());
    }
}