import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

//Counting Vowels

public class Main {
    
    static Character[] str = {'a', 'e', 'i', 'o', 'u'};

    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        solve();
    }
    
    private static void print() {

    }

    private static void solve() throws IOException {
        init();
        print();
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        char[] ch = br.readLine().toCharArray();
        List<Character> list = Arrays.asList(str);
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if (list.contains(ch[i])) cnt++;
        }

        System.out.println(cnt);



        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}