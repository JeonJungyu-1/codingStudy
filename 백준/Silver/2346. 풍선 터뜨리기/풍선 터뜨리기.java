import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 풍선 터뜨리기

public class Main {
    
    static StringBuilder sb;
    

    
    public static void main(String[] args) throws IOException {
        solve();
    }
    
    

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] numbers = new int[N];
        boolean[] visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int index = 0;
        int count = 0;

        while (count < N) {
            if (!visited[index]) {
                sb.append(index + 1).append(" ");
                visited[index] = true;
                count++;
                if (count >= N) break;
            }


            int cnt = numbers[index];
            boolean isPlus = numbers[index] > 0 ? true : false;
            while (cnt != 0) {
                if (isPlus) {
                    index++;
                    if (index >= N) index = 0;
                    if (!visited[index]) cnt--;
                } else {
                    index--;
                    if (index < 0) index = N - 1;
                    if (!visited[index]) cnt++;
                }

            }


        }

        System.out.println(sb.toString());



    }
}