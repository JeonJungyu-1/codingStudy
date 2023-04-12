import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;


// 통계학

public class Main {
    
    static StringBuilder sb;
    static int N;
    static List<Integer> numbers;

    static class Number implements Comparable<Number> {
        int num, cnt;

        public Number(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Number o) {
            int compare = Integer.compare(o.cnt, this.cnt);
            return compare == 0 ? Integer.compare(this.num, o.num) : compare;
        }

        
        
    }
    
    public static void main(String[] args) throws IOException {
        solve();
    }
    
    private static void print() {
        System.out.println(sb.toString());
    }

    private static void solve() throws IOException {
        init();
        Map<Integer, Integer> map = new TreeMap<>();
        PriorityQueue<Number> pq = new PriorityQueue<>();
        Collections.sort(numbers);
        double sum = 0;
        for (int i = 0; i < numbers.size(); i++) {
            sum += numbers.get(i);

            map.put(numbers.get(i), map.getOrDefault(numbers.get(i), 0) + 1);
        }
        //산술평균
        sb.append(Math.round(sum / N)).append("\n");

        //중앙값
        sb.append(numbers.get(N / 2)).append("\n");
        //최빈값
        for (int key : map.keySet()) {
            pq.offer(new Number(key, map.get(key)));
        }
        Number number = pq.poll();
        sb.append(pq.isEmpty() || number.cnt != pq.peek().cnt ? number.num : pq.peek().num).append("\n");


        //범위
        sb.append(numbers.get(N - 1) - numbers.get(0)).append("\n");
        print();
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        numbers = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            numbers.add(Integer.parseInt(br.readLine()));
        }





        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}