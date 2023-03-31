import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    static int T, N;
    static int[] numbers;
    static int[] result;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            numbers = new int[N];
            result = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                numbers[i] = Integer.parseInt(st.nextToken());
            }

            int size = 0;
            for (int i = 0; i < N; i++) {
                int temp = Arrays.binarySearch(result, 0, size, numbers[i]);
                temp = Math.abs(temp + 1);
                result[temp] = numbers[i];

                if (size == temp) size++;
            }

            sb.append("#").append(t).append(" ").append(size).append("\n");
        }
        System.out.println(sb.toString());

        
    }
}