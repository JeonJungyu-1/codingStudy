import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// 수 나누기 게임

public class Main {
    
    static StringBuilder sb;
    static int N;
    static List<Integer> list;
    static int[] score;
    static boolean[] numberCheck;
    static int max;
    public static void main(String[] args) throws IOException {
        solve();
    }
    
    private static void print() {
        for (int number : list) {
            sb.append(score[number]).append(" ");
        }

        System.out.println(sb.toString());
    }

    private static void solve() throws IOException {
        init();
        score = new int[max + 1];
        numberCheck = new boolean[score.length];
        for (int number : list) {
            numberCheck[number] = true;
        }

        for (int number : list) {
            
            for (int i = number * 2; i < score.length; i += number) {
                if (numberCheck[i]) {
                    score[number]++;
                    score[i]--;
                }
            }

        }

        print();
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());
            max = Math.max(n, max);
            list.add(n);
        }

    }
}