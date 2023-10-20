import java.util.*;

class Solution {
    static boolean[] visited;
    static String[] answer;
    public String[] solution(String[][] tickets) {
        answer = null;
        
        visited = new boolean[tickets.length];
        
        dfs(0, "", tickets.length, null, tickets);
        
        return answer;
    }
    
    
    public void dfs(int cnt, String str, int N, String[] cur, String[][] tickets) {
        if (cnt == N) {
            String newStr = str.substring(1) + "," + cur[1];
            String[] strArr = newStr.split(",");
            
            if (answer == null) {
                answer = strArr;
                return;
            }
            
            
            
            String a = String.join(",", answer);
            
            String[] s = new String[2];
            s[0] = a;
            s[1] = newStr;
            Arrays.sort(s);
            answer = s[0].split(",");
            return;
        }
        
        for (int i = 0; i < tickets.length; i++) {
            if (visited[i]) continue;
            if (cur == null && !tickets[i][0].equals("ICN")) continue;
            if (cur != null && !cur[1].equals(tickets[i][0])) continue;
            visited[i] = true;
            dfs(cnt + 1, str + "," + tickets[i][0], N, tickets[i], tickets);
            visited[i] = false;
        }
    }
}