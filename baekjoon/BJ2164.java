package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ2164 {
    static StringBuilder sb;
    static int N;
    static Queue<Integer> card;
    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }
    
    private static void print() {
        System.out.println(card.poll());
    }

    private static void solve() {
        while (card.size() != 1) {
            card.poll();
            card.offer(card.poll());
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        card = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            card.offer(i + 1);
        }

    }
}
