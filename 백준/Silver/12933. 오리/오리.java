import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 오리

public class Main {
    
    static StringBuilder sb;
    static char[] duck = {'q', 'u', 'a', 'c', 'k'};
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

        char[] ch = br.readLine().toCharArray();

        int cnt = -1;
        int changeCnt = 0;
        boolean isEnd = false;
        while (true) {


            if (isEnd) break;
            isEnd = true;
            cnt++;

            int index = 0;
            for (int i = 0; i < ch.length; i++) {
                if (ch[i] == ' ') continue;

                if (ch[i] == duck[index]) {
                    ch[i] = ' ';
                    
                    index++; 

                    if (index == 5) {
                        index = 0;
                        changeCnt += 5;
                        isEnd = false;
                    }
                }
            }



        }

        System.out.println(cnt == 0 || changeCnt != ch.length ? -1 : cnt);




        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}