import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 전깃줄
// Lis

public class Main {
    static int N;
    static int[] numbers;
    static int[] selectedNumbers;

    public static void main(String[] args) throws NumberFormatException, IOException {
        // System.setIn(new FileInputStream("src/a.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        numbers = new int[501];
        StringTokenizer st;
        int len = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(st.nextToken());
            numbers[index] = Integer.parseInt(st.nextToken());
            len = Math.max(len, index);
        }

        int size = 0;
        selectedNumbers = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            int temp = Arrays.binarySearch(selectedNumbers, 0, size, numbers[i]);
            if (numbers[i] != 0 && temp < 0) {
                temp = Math.abs(temp + 1);
                selectedNumbers[temp] = numbers[i];
                if (size == temp) size++;
            }
        }

        System.out.println(N - size);

        
        
    }
}