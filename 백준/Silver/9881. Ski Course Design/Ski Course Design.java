import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

// Ski Course Design

public class Main {
    
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        solve();
    }

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(list);
        int maxNum = list.get(list.size() - 1);
        int minPrice = Integer.MAX_VALUE;
        int min = 0;
        int max = 17;
        
        while (min < maxNum) {
            int price = 0;
            if (list.get(0) >= min) {
                price += (list.get(0) - min) * (list.get(0) - min);
            } else {
                for (int i = 0; i < N; i++) {
                    if (list.get(i) >= min) break;
                    price += (min - list.get(i)) * (min - list.get(i));
                }
            }

            if (list.get(list.size() - 1) <= max) {
                price += (max - list.get(list.size() - 1)) * (max - list.get(list.size() - 1));
            } else {
                for (int i = N - 1; i >= 0; i--) {
                    if (list.get(i) <= max) break;
                    price += (list.get(i) - max) * (list.get(i) - max);
                }
            }

            minPrice = Math.min(price, minPrice);
            min++;
            max++;

        }

        System.out.println(minPrice);


    }
}