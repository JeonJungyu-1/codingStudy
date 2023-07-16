import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// 두 수의 합

public class Main {
    
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        solve();
    }
    

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        List<Integer> numbers = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        int x = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            if (list.get(i) < x) numbers.add(list.get(i));
        }


        Collections.sort(numbers);

        int start = 0;
        int end = numbers.size() - 1;

        int count = 0;

        while (start < end) {
            int sum = numbers.get(start) + numbers.get(end);
            if (sum >= x) {
                if (sum == x) count++;
                end--;
            } else {
                start++;
            }
        }


        System.out.println(count);



    }
}