import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 터렛
// 기하학

public class Main {
    
    static StringBuilder sb;
    
    public static void main(String[] args) throws IOException {
        solve();
    }

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());


            int distance = ((x1 - x2) * (x1 - x2)) + ((y1 - y2) * (y1 - y2));

            if (x1 == x2 && y1 == y2) {
                if (r1 == 0 && r2 == 0) {
                    sb.append("1");
                } else if (r1 == r2) {
                    sb.append("-1");
                } else {
                    sb.append("0");
                }
            } else {
                int radiusSum = (r1 + r2) * (r1 + r2);
                int radiusDiff = (r1 - r2) * (r1 - r2);

                if (radiusSum < distance || radiusDiff > distance) {
                    sb.append("0");
                } else if (radiusSum == distance || radiusDiff == distance) {
                    sb.append("1");
                } else {
                    sb.append("2");
                }
            }

            sb.append("\n");


        }

        System.out.println(sb.toString());

    }
}