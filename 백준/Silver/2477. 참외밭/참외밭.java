import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// 참외밭

public class Main {
    
    static StringBuilder sb;

    static class fruit {
        int d, h;

        public fruit(int d, int h) {
            this.d = d;
            this.h = h;
        }
        
    }
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
        StringTokenizer st;
        sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        List<Integer> r = new ArrayList<>();
        List<Integer> c = new ArrayList<>();

        fruit[] fruits = new fruit[6];
        
        for (int i = 0; i < 6; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            fruits[i] = new fruit(d, h);

        }


        
        int sum = 0;
        for (int i = 0; i < 6; i++) {
            if (fruits[i].d == fruits[(i + 2) % 6].d && fruits[(i + 1) % 6].d == fruits[(i + 3) % 6].d)  {
                sum = (fruits[(i + 4) % 6].h * fruits[(i + 5) % 6].h) - (fruits[(i + 1) % 6].h * fruits[(i + 2) % 6].h);
                break;
            }
        }
        System.out.println(sum * N);
    }
}