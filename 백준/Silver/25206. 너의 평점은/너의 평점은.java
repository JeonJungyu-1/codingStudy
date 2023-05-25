import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// 너의 평점은

public class Main {
    
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        solve();
    }
    

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        Map<String, Double> map = new HashMap<>();
        map.put("A+", 4.5);
        map.put("A0", 4.0);
        map.put("B+", 3.5);
        map.put("B0", 3.0);
        map.put("C+", 2.5);
        map.put("C0", 2.0);
        map.put("D+", 1.5);
        map.put("D0", 1.0);
        map.put("F", 0.0);


        double average = 0;
        int cnt = 0;
        for (int i = 0; i < 20; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            double score = Double.parseDouble(st.nextToken());
            
            String grade = st.nextToken();

            if (!grade.equals("P")) {
                average += (score * map.get(grade));
                cnt += score;
            }
        }

        System.out.println(average/cnt);

    }
}