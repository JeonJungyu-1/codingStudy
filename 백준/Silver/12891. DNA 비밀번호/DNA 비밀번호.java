
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

//12891
//2178

public class Main {
    static int N, M;
    static int start, end;
    static int count;
    static boolean isFail;
    static Map<Character, Integer> map;
    static Map<Character, Integer> temp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new HashMap<>();
        temp = new HashMap<>();

        String str = br.readLine();
        

        st = new StringTokenizer(br.readLine());
        map.put('A', Integer.parseInt(st.nextToken()));
        map.put('C', Integer.parseInt(st.nextToken()));
        map.put('G', Integer.parseInt(st.nextToken()));
        map.put('T', Integer.parseInt(st.nextToken()));

        
        tempInit();
        start = 0;
        end = M - 1;
        Character firstCh = str.charAt(0);
        Character endCh = str.charAt(M - 1);
        
        while (end < N) {
            isFail = false;
            
            if (start == 0) {
                // 최초 설정
                for (int i = 0; i < M; i++) {
                    char ch = str.charAt(i);
                    temp.put(ch, temp.get(ch) + 1);             
                }
                for (Character c: map.keySet()) {
                    if (temp.get(c) < map.get(c)) {
                        isFail = true;
                        break;
                    }
                }
            } else {
                endCh = str.charAt(end);
                temp.put(firstCh, temp.get(firstCh) - 1);
                temp.put(endCh, temp.get(endCh) + 1);
                // if (temp.get(firstCh) < map.get(firstCh)) isFail = true;
                // if (temp.get(endCh) < map.get(endCh)) isFail = true;
                for (Character c: map.keySet()) {
                    if (temp.get(c) < map.get(c)) {
                        isFail = true;
                        break;
                    }
                }
                firstCh = str.charAt(start);
                

            }


            if (!isFail) count++;
            start++;
            end++;
        }
        System.out.println(count);

    }

    static void tempInit() {
        temp.put('A', 0);
        temp.put('C', 0);
        temp.put('G', 0);
        temp.put('T', 0);
    }

    // static void numCheck(char ch) {
    //     if (ch == 'A') {
    //         numCount[0]++;
    //     } else if (ch == 'C') {
    //         numCount[1]++;
    //     } else if (ch == 'G') {
    //         numCount[2]++;
    //     } else if (ch == 'T') {
    //         numCount[3]++;
    //     }
    // }

    // static boolean isAvailable() {
    //     for (int i = 0; i < 3; i++) {
    //         if (minCount[i] > numCount[i]) return false;
    //     }

    //     return true;
    // }
}
