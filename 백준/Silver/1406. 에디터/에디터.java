import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

// 에디터

public class Main {
    
    static StringBuilder sb;
    static Deque<Character> first, second;
    
    public static void main(String[] args) throws IOException {
        solve();
    }



    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        char[] ch = br.readLine().toCharArray();
        int T = Integer.parseInt(br.readLine());

        first = new ArrayDeque<>();
        second = new ArrayDeque<>();
        for (int i = 0; i < ch.length; i++) {
            first.offer(ch[i]);
        }

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch (command) {
                case "L":
                    if(!first.isEmpty()) second.addFirst(first.pollLast());
                    break;
                case "D":
                    if(!second.isEmpty()) first.addLast(second.pollFirst());
                    break;
                case "B":
                    if (!first.isEmpty()) first.pollLast();
                    break;
                case "P":
                    String s = st.nextToken();
                    first.addLast(s.charAt(0));
                    break;
            }
        }

        while (!first.isEmpty()) sb.append(first.poll());
        while (!second.isEmpty()) sb.append(second.poll());

        System.out.println(sb.toString());
    }
}