import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 전깃줄 2
// Lis

public class Main {
    static int N;
    static int[] numbers;
    static int[] selectedNumbers;
    static int[] record;
    static boolean[] visited;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        numbers = new int[500001];
        record = new int[500001];
    
        StringTokenizer st;
        int len = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(st.nextToken());
            numbers[index] = Integer.parseInt(st.nextToken());
            len = Math.max(len, index);
        }

        int size = 1;
        selectedNumbers = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            int temp = Arrays.binarySearch(selectedNumbers, 1, size, numbers[i]);
            if (temp < 0 && numbers[i] != 0) {
                temp = Math.abs(temp + 1);
                selectedNumbers[temp] = numbers[i];
                record[i] = temp + 1;
                if (size == temp) size++;
            }
        }

        visited = new boolean[500001];
        int index = size;
        for (int i = len; i >= 1; i--) {
            if (index != 0 && record[i] == index) {
                visited[i] = true;
                index--;
            }
        }
        
        sb.append(N - size + 1).append("\n");
        for (int i = 1; i <= len; i++) {
            if (!visited[i] && numbers[i] != 0) sb.append(i).append("\n");
        }

        
        System.out.println(sb.toString());

        
        
    }
}