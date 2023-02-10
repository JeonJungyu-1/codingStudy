package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BJ1115 {
    static int N;
    static int[] numbers;
    static int[] selectedNumbers;
    static boolean[] isVisited;
    static int[] bNumbers;
    static int minNum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        numbers = new int[N];
        selectedNumbers = new int[N];
        bNumbers = new int[N];
        isVisited = new boolean[N];
        minNum = Integer.MAX_VALUE;
        bNumbers[0] = 0;
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        perm(0);


        System.out.println(minNum);


    }

    static void perm(int cnt) {
        if (cnt == N) {
            if (isPerfect()) {
                difference();
            }
            return;
        }

        for (int i = 0; i < N; i++) {
            if (isVisited[i]) continue;
            isVisited[i] = true;
            selectedNumbers[cnt] = i;
            if (cnt > 0) bNumbers[cnt] = selectedNumbers[bNumbers[cnt - 1]];
            perm(cnt + 1);
            selectedNumbers[cnt] = 0;
            isVisited[i] = false;
        }
    }

    static boolean isPerfect() {
        int same = 0;
        a:
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (bNumbers[i] == bNumbers[j]) {
                    same++;
                    break a;
                }
            }
        }

        return same == 0 ? true : false;
    }

    static void difference() {
        int diff = 0;
        for (int i = 0; i < N; i++) {
            if (numbers[i] != selectedNumbers[i]) {
                diff++;
                break;
            }
        }

        minNum = Math.min(diff, minNum);

    }
}
