import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// 단어 나누기

public class Main {
    
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        solve();
    }
    


    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        String str = br.readLine();
        Queue<String> pq = new PriorityQueue<>();
        for (int i = 1; i < str.length(); i++) {
            for (int j = 2; j < str.length(); j++) {
                if (i >= j) continue;
                
                String a = new StringBuilder(str.substring(0, i)).reverse().toString();
                String b = new StringBuilder(str.substring(i, j)).reverse().toString();
                String c = new StringBuilder(str.substring(j)).reverse().toString();
                pq.offer(a + b + c);




            }
        }

        System.out.println(pq.poll());



    }
}