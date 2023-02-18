package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BJ2470 {
    static int N;
    static List<Integer> water;
    static int minSum;
    static int[] finalWater;
    // 두 용액 - 투포인터, 이분탐색
    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }


    private static void print() {
        StringBuilder sb = new StringBuilder();
        Arrays.sort(finalWater);
        sb.append(finalWater[0]).append(" ").append(finalWater[1]);
        System.out.println(sb.toString());
    }


    private static void solve() {
        // 투포인터
        // twoPointer();
        binarysearch();

    }



    private static void binarysearch() {
        finalWater = new int[2];
        minSum = Integer.MAX_VALUE;
        int currentSum = 0;
        a:
        for (int i = 0; i < water.size(); i++) {
            int low = 0;
            int high = water.size() - 1;
            while (true) {
                int mid = (low + high) / 2;
                if (low + 1 >= high) {
                    if (Math.abs(currentSum) < Math.abs(minSum) && mid != i) {
                        minSum = water.get(high) + water.get(i);
                        finalWater[0] = water.get(high);
                        finalWater[1] = water.get(i);
                    } 
                    break;
                }
                
                currentSum = water.get(mid) + water.get(i);
                
                if (currentSum >  0) {
                    high = mid;
                    currentSum = water.get(high) + water.get(i);
                } else if (currentSum < 0) {
                    low = mid;
                    currentSum = water.get(low) + water.get(i);
                } else {
                    finalWater[0] = water.get(mid);
                    finalWater[1] = water.get(i);
                    break a;
                }
            }
        }


    }


    private static void twoPointer() {
        finalWater = new int[2];
        minSum = Integer.MAX_VALUE;
        int start = 0;
        int end = water.size() - 1;
        int currentSum = 0;
        while (true) {
            if (start >= end) break;
            currentSum = water.get(start) + water.get(end);
            if (Math.abs(currentSum) < Math.abs(minSum)) {
                minSum = currentSum;
                finalWater[0] = water.get(start);
                finalWater[1] = water.get(end);
            } 

            if (currentSum > 0) {
                end--;
            } else if (currentSum < 0) {
                start++;
            } else {
                break;
            }
            


        }
    }


    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        water = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            water.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(water);

        br.close();
    }
}
