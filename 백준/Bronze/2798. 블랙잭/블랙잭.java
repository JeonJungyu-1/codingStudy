
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int sum;
    static int N;
    static int[] selectedCard;
    static int[] card;
    static int maxSum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        sum = Integer.parseInt(st.nextToken());
        card = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            card[i] = Integer.parseInt(st.nextToken());
        }

        selectedCard = new int[3];
        maxSum = -1;

        combi(0, 0, 0);

        System.out.println(maxSum);

        


    }

    static void combi(int cnt, int start, int currentSum) {
        if (cnt == 3) {
            if (currentSum <= sum) {
                maxSum = Math.max(maxSum, currentSum);
            }
            return;
        }

        for (int i = start; i < N; i++) {
            selectedCard[cnt] = card[i];
            combi(cnt + 1, i + 1, currentSum + selectedCard[cnt]);
            selectedCard[cnt] = 0;
        }



    }
}
