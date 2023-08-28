import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

// 십자카드 문제

public class Main {
    
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        solve();
    }


    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();


        int[] numbers = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        
        // 시계수 찾기
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            String str = "";
            for (int j = 0; j < 4; j++) {
                str += numbers[(i + j) % 4];
            }

            list.add(Integer.parseInt(str));
            
        }

        Collections.sort(list);
        int clockNumber = list.get(0);
   
        
        
        boolean[] visited = new boolean[10000];
        int number = 1111;
        int cnt = 1;
        outer:
        while (true) {

            char[] ch = String.valueOf(number).toCharArray();
            for (int i = 0; i < 4; i++) {
                if (ch[i] == '0') {
                    number += Math.pow(10, 3 - i);
                }
            }
            if (number == clockNumber) break;
            if (visited[number]) {
                number++;
                continue;
            }
            visited[number] = true;

            int newNumber = number;
            for (int i = 0; i < 3; i++) {
                newNumber = (newNumber % 1000) * 10 + (newNumber / 1000);
                if (newNumber == clockNumber) break outer;
                visited[newNumber] = true;
            }
            cnt++;
            number++;
            
            



        }

        System.out.println(cnt);

    }
}