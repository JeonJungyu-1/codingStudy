import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

//KCPC

public class Main {
    
    static StringBuilder sb;

    static class Team implements Comparable<Team> {
        int number;
        int score;
        int cnt;
        int last;
        int[] list;
        public Team(int number, int score, int cnt, int last, int[] list) {
            this.number = number;
            this.score = score;
            this.cnt = cnt;
            this.last = last;
            this.list = list;
        }
        @Override
        public int compareTo(Team o) {
            int compareScore = Integer.compare(o.score, this.score);
            int compareCnt = Integer.compare(this.cnt, o.cnt);
            int compareLast = Integer.compare(this.last, o.last);
            return compareScore != 0 ? compareScore : compareCnt != 0 ? compareCnt : compareLast;
        }

        


        
    }
    public static void main(String[] args) throws IOException {
        solve();
    }


    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int test = 0; test < T; test++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            List<Team> list = new ArrayList<>();

            for (int i = 0; i <= n; i++) {
                list.add(new Team(i, 0, 0, 0, new int[k + 1]));
            }

            for (int d = 0; d < m; d++) {
                st = new StringTokenizer(br.readLine());
                int i = Integer.parseInt(st.nextToken());
                int j = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());
                Team team = list.get(i);
                team.list[j] = Math.max(team.list[j], s);
                team.cnt++;
                team.last = d;
            }

            for (Team team : list) {

                for (int i = 1; i <= k; i++) {
                    team.score += team.list[i];
                }

            }

            Collections.sort(list);
            int result = 1;
            for (Team team : list) {
                if (team.number != 0) {
                    if (team.number == t) {
                        sb.append(result).append("\n");
                        break;
                    } else {
                        result++;
                    }
                }
            }
        }

        System.out.println(sb.toString());

  
    }
}