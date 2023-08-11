import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

// 창고 다각형

public class Main {
    
    static StringBuilder sb;

    static class Pillar implements Comparable<Pillar> {
        int point;
        int height;
        public Pillar(int point, int height) {
            this.point = point;
            this.height = height;
        }
        @Override
        public int compareTo(Pillar o) {
            return Integer.compare(this.point, o.point);
        }
        
        
    }
    public static void main(String[] args) throws IOException {
        solve();
    }
    

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        List<Pillar> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            list.add(new Pillar(p, h));
        }
        
        Collections.sort(list);
        Pillar max = new Pillar(0, Integer.MIN_VALUE);
        int maxIndex = 0;
        
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).height > max.height) {
                max.height = list.get(i).height;
                max.point = list.get(i).point;
                maxIndex = i;
            }
        }


        Stack<Pillar> stack = new Stack<>();
        int result = max.height;
        // 좌측
        for (int i = 0; i < maxIndex; i++) {
            if (stack.isEmpty() || stack.peek().height <= list.get(i).height) {
                stack.push(list.get(i));
            }
        }

        int prevPoint = list.get(maxIndex).point;
        while (!stack.isEmpty()) {
            Pillar cur = stack.pop();
            result += cur.height * (prevPoint - cur.point);
            prevPoint = cur.point;
        }

        // 우측
        for (int i = list.size() - 1; i > maxIndex; i--) {
            if (stack.isEmpty() || stack.peek().height <= list.get(i).height) {
                stack.push(list.get(i));
            }
        }
        prevPoint = list.get(maxIndex).point;
        while (!stack.isEmpty()) {
            Pillar cur = stack.pop();
            result += cur.height * (cur.point - prevPoint);
            prevPoint = cur.point;
        }    


        System.out.println(result);


    }
}