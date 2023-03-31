import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 가장 긴 증가하는 부분 수열 4

public class Main {
    static int T, N;
    static int[] numbers;
    static int[] result;
    static int[] record;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
            N = Integer.parseInt(br.readLine());
            numbers = new int[N];
            result = new int[N];
            record = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                numbers[i] = Integer.parseInt(st.nextToken());
            }

            int size = 0;
            for (int i = 0; i < N; i++) {
                int temp = Arrays.binarySearch(result, 0, size, numbers[i]);
                if (temp < 0) {
                    temp = Math.abs(temp + 1);
                    result[temp] = numbers[i];
                    record[i] = temp + 1;
                    if (size == temp) size++;
                }

            }

        sb.append(size).append("\n");
        int[] lis = new int[size];
        int index = size;
        for (int i = record.length - 1; i >= 0; i--) {
            if (index == record[i] && index != 0) {
                lis[index - 1] = numbers[i];
                index--;
            }
        }

        for (int number: lis) {
            sb.append(number).append(" ");
        }
        System.out.println(sb.toString());

        
    }
}