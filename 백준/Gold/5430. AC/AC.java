import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

// AC

public class Main {
    
    static StringBuilder sb;
    static int T;
    public static void main(String[] args) throws IOException {
        solve();
    }
    
    

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        sb = new StringBuilder();
        Deque<Integer> dq = new ArrayDeque<>();
        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            char[] p = br.readLine().toCharArray();
            int n = Integer.parseInt(br.readLine());
            String str = br.readLine();
            str = str.substring(1, str.length() - 1);
            String[] arr;
            dq.clear();
            if (str.length() != 0) {
                arr = str.split(",");
                for (int j = 0; j < arr.length; j++) {
                    dq.offer(Integer.parseInt(arr[j]));
                }
            }

            boolean isFirst = true;
            boolean isError = false;
            for (int j = 0; j < p.length; j++) {
                if (p[j] == 'R') {
                    isFirst = !isFirst;
                } else {
                    if (dq.isEmpty()) {
                        isError = true;
                        break;
                    } else if (isFirst) {
                        dq.pollFirst();
                    } else {
                        dq.pollLast();
                    }
                }
            }


            if (isError) {
                sb.append("error");
            } else {
                if (isFirst) {
                    sb.append("[");
                    while (!dq.isEmpty()) {
                        sb.append(dq.pollFirst());
                        if (dq.size() != 0) sb.append(",");
                    }
                    sb.append("]");
                } else {
                    sb.append("[");
                    while (!dq.isEmpty()) {
                        sb.append(dq.pollLast());
                        if (dq.size() != 0) sb.append(",");
                    }
                    sb.append("]");
                }
            }
            sb.append("\n");

        }

        System.out.println(sb.toString());




        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}