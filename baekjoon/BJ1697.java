package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 숨바꼭질 - bfs
public class BJ1697 {
    static int start, end;
    static int cnt;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        cnt = 0;

        visit = new boolean[100001];


        bfs();

        System.out.println(cnt);


        br.close();
    }


    //bfs
    static void bfs() {
        Queue<int[]> que = new ArrayDeque<>();
        que.offer(new int[]{start, 0});

        while (!que.isEmpty()) {
            int[] time = que.poll();
            if (time[0] == end) {
                cnt = time[1];
                return;
            }

            if (time[0] * 2 <= 100000 && !visit[time[0] * 2]) {
                que.offer(new int[] {time[0] * 2, time[1] + 1});
                visit[time[0] * 2] = true;
            }
            if (time[0] + 1 <= 100000 && !visit[time[0] + 1]) {
                que.offer(new int[] {time[0] + 1, time[1] + 1});
                visit[time[0] + 1] = true;
            }
            
            if (time[0] - 1 >= 0 && !visit[time[0] - 1]) {
                que.offer(new int[] {time[0] - 1, time[1] + 1});
                visit[time[0] - 1] = true;
            }


        }
    }


}
