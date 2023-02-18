import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


// 신나는 함수 실행 - dp
// 3차원 배열을 이용해 메모이제이션
// top-down 사용
public class Main {
    static StringBuilder sb;
    static int[][][] memo;
    public static void main(String[] args) throws IOException {
        solve();
        print();
    }
    
    private static void print() {
        System.out.println(sb.toString());
    }

  

    private static int w(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            return 1;
        }

        
        if (a > 20 || b > 20 || c > 20) {
            memo[20][20][20] = w(20, 20, 20);
            return memo[20][20][20];    
        }
        
        if (memo[a][b][c] != 0) {
            return memo[a][b][c];    
        }

        if (a < b && b < c) {
            memo[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
            return memo[a][b][c];    
        }

        memo[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c- 1);
        return memo[a][b][c];    

    }

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        sb = new StringBuilder();
        memo = new int[21][21][21];
        
        while (true) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (a == -1 && b == -1 && c == -1) break;
            int result = w(a, b, c);
            sb.append("w(").append(a).append(", ").append(b).append(", ").append(c).append(") = ").append(result).append("\n");
        }




        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }

    
}