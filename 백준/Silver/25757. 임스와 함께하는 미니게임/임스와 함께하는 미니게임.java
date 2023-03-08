import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static String game;
    static int gameCnt;
    static HashMap<String, Boolean> map;
    static int playCount;
    public static void main(String[] args) throws IOException {
        solve();
        
    }
    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        map = new HashMap<>();
        N = Integer.parseInt(st.nextToken());
        game = st.nextToken();
        switch (game) {
            case "Y":
                gameCnt = 1;
                break;
            case "F":
                gameCnt = 2;
                break;
            case "O":
                gameCnt = 3;
                break;
        }

        int cnt = 0;
        for (int i = 0; i < N ; i++) {
            String user = br.readLine();
            if (!map.containsKey(user)) {
                map.put(user, true);
                cnt++;
                if (cnt == gameCnt) {
                    cnt = 0;
                    playCount++;
                }
            }
        }

        System.out.println(playCount);
    }
}