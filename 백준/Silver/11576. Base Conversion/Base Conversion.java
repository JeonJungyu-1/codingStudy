import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// Base Conversion

public class Main {
    
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        solve();
    }
    


    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        
        Collections.reverse(list);

        int number = 0;
        for (int i = 0; i < m; i++) {
            number += (Math.pow(A, i) * list.get(i));
        }

        List<Integer> result = new ArrayList<>();
        int i = B;
        while (number != 0) {
            result.add(number % B);
            number /= B;
            i *= B;
        }


        for (int j = result.size() - 1; j >= 0; j--) {
            sb.append(result.get(j)).append(" ");
        }

        System.out.println(sb.toString());
        



    }
}