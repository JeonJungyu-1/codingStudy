import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] numbers;
    public static void main(String[] args) throws NumberFormatException, IOException {
        solve();
        
    }
    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        numbers = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers);
        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int number = Integer.parseInt(st.nextToken());
            int result = binarySearch(number);
            sb.append(result != N && numbers[result] == number ? 1 : 0).append("\n");
        }

        System.out.println(sb.toString());

    }
    private static int binarySearch(int num) {
        int low = -1;
        int high = N;
        while (low + 1 < high) {
            int mid = (low + high) / 2;
            if (numbers[mid] < num) {
                low = mid;
            } else {
                high = mid;
            }
        }
        return high;
    }

    
}