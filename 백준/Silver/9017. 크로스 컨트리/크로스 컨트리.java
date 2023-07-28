import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

// 크로스 컨트리

public class Main {
    
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        solve();
    }
    


    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] scores = new int[N + 1];
            st = new StringTokenizer(br.readLine());
            Map<Integer, Integer> map = new HashMap<>();
            Map<Integer, Integer> totalScore = new HashMap<>();
            Map<Integer, List<Integer>> teamScore = new HashMap<>();
            for (int i = 1; i <= N; i++) {
                scores[i] = Integer.parseInt(st.nextToken());
                map.put(scores[i], map.getOrDefault(scores[i], 0) + 1);
            }
            
            int start = 1;
            for (int i = 1; i <= N; i++) {
                if (map.getOrDefault(scores[i], 0) < 6) continue;
                if (teamScore.getOrDefault(scores[i], new ArrayList<>()).size() < 4) totalScore.put(scores[i], totalScore.getOrDefault(scores[i], 0) + start);

                if (!teamScore.containsKey(scores[i])) teamScore.put(scores[i], new ArrayList<>());
                teamScore.get(scores[i]).add(start);
                start++;
            }


            


            int min = Integer.MAX_VALUE;
            int result = 0;
            for (int team : totalScore.keySet()) {
                if (totalScore.get(team) < min || (totalScore.get(team) == min && ((int)teamScore.get(team).get(4) < (int)teamScore.get(result).get(4)))) {
                    min = totalScore.get(team);
                    result = team;
                }


            }

            sb.append(result).append("\n");


        }

        System.out.println(sb.toString());


 
    }
}