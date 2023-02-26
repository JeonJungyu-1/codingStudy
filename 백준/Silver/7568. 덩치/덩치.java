import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb;
    static int N;
    static Person[] personList;
    static int[] personRank;

    static class Person {
        int weight;
        int height;
        public Person(int weight, int height) {
            this.weight = weight;
            this.height = height;
        }
    }
    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }
    
    private static void print() {
        System.out.println(sb.toString());
    }

    private static void solve() {
        
        for (int i = 0; i < N; i++) {
            int cnt = 1;
            for (int j = 0; j < N; j++) {
                if (i == j) continue;
                if (personList[i].height < personList[j].height && personList[i].weight < personList[j].weight ) {
                    cnt++;
                }
            }
            personRank[i] = cnt;
        }

        for (int i = 0; i < N; i++) {
            sb.append(personRank[i]).append(" ");
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        personRank = new int[N];
        personList = new Person[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            personList[i] = new Person(w, h);
        }



    }
}