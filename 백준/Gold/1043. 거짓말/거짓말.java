import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

// 거짓말

public class Main {

    static int N, M;
    static List<List<Integer>> party;
    static boolean[] person;
    static int count;
    public static void main(String[] args) throws IOException {
        init();

        boolean isEnd = false;
        boolean hasTruth = false;

        
        while (true) {
            if (isEnd) break;
            isEnd = true;

            for (int i = 0; i < party.size(); i++) {
                
                hasTruth = false;

                // 파티에 진실을 아는 사람이 있는지 확인
                for (int next : party.get(i)) {
                    if (person[next]) {
                        hasTruth = true;
                        break;
                    }
                }


                if (!hasTruth) continue;
                // 파티에 진실을 아는 사람이 있고, 처리안된 사람이 있는지 확인
                for (int next : party.get(i)) {
                    if (!person[next]) {
                        isEnd = false;
                        person[next] = true;
                    }
                }
                
            }
        }


        // 과장된 이야기 할 수 있는 파티 찾기
        outer:
        for (int i = 0; i < party.size(); i++) {
                
            for (int next : party.get(i)) {
                if (person[next]) {
                    continue outer;
                }
            }
            count++;
        }
        System.out.println(count);

        
    }
    private static void init() throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        person = new boolean[N + 1];
        party = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            party.add(new ArrayList<>());
        }

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            person[Integer.parseInt(st.nextToken())] = true;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            for (int j = 0; j < n; j++) {
                int p = Integer.parseInt(st.nextToken());
                party.get(i).add(p);
            }
        }
    }

}