import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 숫자카드
// 이분탐색

public class Main {
    static StringBuilder sb;
    static int N, M;
    static int[] myCard;
    static int[] cardList;
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }
    

    private static void solve() {
        Arrays.sort(myCard);
        for (int i = 0; i < cardList.length; i++) {
            int result = binarySearch(cardList[i]);
            sb.append((result != -1 && myCard[result] == cardList[i]) ? 1 : 0).append(" ");
        }

        System.out.println(sb.toString());
        
    }

    private static int binarySearch(int num) {
        int low = -1;
        int high = myCard.length;
        while (low + 1 < high) {
            int mid = (low + high) / 2;
            if (myCard[mid] <= num) {
                low = mid;
            } else {
                high = mid;
            }
        }
        return low;
        
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        myCard = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            myCard[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());
        cardList = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            cardList[i] = Integer.parseInt(st.nextToken());
        }




        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}