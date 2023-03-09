import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static List<Integer> numbers;
    static int[] selected;
    public static void main(String[] args) throws NumberFormatException, IOException {
        init();
        solve();
        print();
        
    }
    private static void print() {
        StringBuilder sb = new StringBuilder();
        sb.append(selected[0]).append(" ").append(selected[1]);
        System.out.println(sb.toString());
    }
    private static void solve() {
        Collections.sort(numbers);
        // 투포인터
        int start = 0;
        int end = numbers.size() - 1;
        selected[0] = numbers.get(start);
        selected[1] = numbers.get(end);
        selected[2] = Math.abs(selected[0] + selected[1]);
        while (start < end) {
            int startNumber = numbers.get(start);
            int endNumber = numbers.get(end);
            int diff = Math.abs(startNumber + endNumber);
            if (diff == 0) {
                selected[0] = startNumber;
                selected[1] = endNumber;
                break;
            } else {
                if (diff < selected[2]) {
                    selected[0] = startNumber;
                    selected[1] = endNumber;
                    selected[2] = diff;
                } else {
                    if (startNumber + endNumber < 0) {
                        start++;
                    } else {
                        end--;
                    }
                }
            }
        }
    }
    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        numbers = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers.add(Integer.parseInt(st.nextToken()));
        }
        selected = new int[3];
    }
}