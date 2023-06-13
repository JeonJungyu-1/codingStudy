import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

// 가장 가까운 세 사람의 심리적 거리

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
            Map<String, Integer> map = new HashMap<>();
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                String type = st.nextToken();
                map.put(type, map.getOrDefault(type, 0) + 1);
            }
            
            List<String> keys = new ArrayList<>(map.keySet());
            List<Integer> list = new ArrayList<>();
            
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < keys.size(); i++) {
                for (int j = i + 1; j < keys.size(); j++) {
                    int cnt = calculateType(keys.get(i), keys.get(j));
                    // list.add(cnt);
                    if (map.get(keys.get(i)) == 2 || map.get(keys.get(j)) == 2) {
                        min = Math.min(min, cnt * 2);
                    } else if (map.get(keys.get(i)) >= 3 || map.get(keys.get(j)) >= 3) {
                        min = 0;
                    } else {
                        for (int k = j + 1; k < keys.size(); k++) {
                            int sum = calculateType(keys.get(i), keys.get(k)) + calculateType(keys.get(j), keys.get(k));
                            min = Math.min(sum + cnt, min);
                        }
                    }

                }
            }



            if (min == Integer.MAX_VALUE) {
                min = 0;
            }
    
           
            sb.append(min).append("\n");
        }

        System.out.println(sb.toString());



    }



    private static int calculateType(String a, String b) {
        char[] aArr = a.toCharArray();
        char[] bArr = b.toCharArray();
        int cnt = 0;
        for (int i = 0; i < 4; i++) {
            if (aArr[i] != bArr[i]) cnt++;
        }

        return cnt;
    }



}