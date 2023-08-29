import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 수 이어가기

public class Main {
    
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        solve();
    }
    


    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        int number = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();
        List<Integer> maxList = new ArrayList<>();
        int maxLength = Integer.MIN_VALUE;
        

        for (int i = 1; i <= number; i++) {
            list.clear();
            int cur = number;
            int next = i;
            while (true) {
                int diff = cur - next;
                list.add(cur);
                if (diff < 0) {
                    list.add(next);
                    break;
                } else {
                    cur = next;
                    next = diff;
                }
            }
            if (maxLength < list.size()) {
                maxLength = list.size();
                maxList = new ArrayList<>(list);
            }
        }


        sb.append(maxLength).append("\n");
        for (int num : maxList) {
            sb.append(num).append(" ");
        }

        System.out.println(sb.toString());



    }
}