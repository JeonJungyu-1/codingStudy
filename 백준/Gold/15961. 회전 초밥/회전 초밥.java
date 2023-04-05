import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 회전초밥 
// 슬라이딩 윈도우

public class Main {
    static StringBuilder sb;
    static int N, d, k, c;
    static int[] susi;
    static int[] susiType;
    static int max;
    static int cnt;
    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }
    
    private static void print() {
        System.out.println(max);
    }

    private static void solve() {
        int start = 0;
        int end = k - 1;

        
        // 시작점이 끝에 도달할때까지 반복
        while (start < N) {


            // // 스타트 초밥이 한개일때 미리 개수 줄여주기
            if (susiType[susi[start]] == 1) {
                cnt--;
            }
            // 스타트 초밥 1개 줄이고, 스타트 하나 증가
            susiType[susi[start]]--;
            start++;

            // 엔드 하나 중가하고, 순환시키기 위해 N으로 나눈 나머지로 바꿔주기
            end++;
            end %= N;
            // 엔드 초밥이 하나도 없으면 개수 하나 증가
            if (susiType[susi[end]] == 0) {
                cnt++;
            }
            // 엔드 초밥 1개 증가
            susiType[susi[end]]++;


            // 쿠폰 초밥이 하나도 없으면 하나 증가 시키기
            if (susiType[c] == 0) {
                susiType[c]++;
                cnt++;
            }

            // 현재 초밥 개수와 맥스값 비교해서 큰 값으로 바꾸기
            max = Math.max(max, cnt);


        }

    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        cnt = 0;
        max = Integer.MIN_VALUE;
        susi = new int[N];
        susiType = new int[d + 1];
        for (int i = 0; i < N; i++) {
            susi[i] = Integer.parseInt(br.readLine());
            if (i < k) {
                if (susiType[susi[i]] == 0) cnt++;
                susiType[susi[i]]++;
            }
        }
        
        if (susiType[c] == 0) {
            susiType[c]++;
            cnt++;
        }


        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}