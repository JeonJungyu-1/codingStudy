package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 회의실 배정 - 그리디
// 1. 끝나는 시간 기준 오름차순으로 정렬
// 2. 먼저 끝나는 시간이 가장 빠른 회의를 선택하고 배열을 순차적으로 탐색
// 3. 시작 시간이 이전에 선택한 회의의 끝나는 시간보다 크거나 같으면 그 회의를 선택하고, 끝나는 시간을 저장해둠.
// 4. 위의 과정을 반복
public class BJ1931 {
    static StringBuilder sb;
    static int N;
    static Meet[] meeting;
    static int count;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }
    
    private static void print() {
        System.out.println(count);
    }

    private static void solve() {
        Arrays.sort(meeting);
        int end = -1;
        for (int i = 0; i < meeting.length; i++) {
            if (meeting[i].start >= end) {
                end = meeting[i].end;
                count++;
            }
        }

    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        meeting = new Meet[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            meeting[i] = new Meet(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }





        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }

    static class Meet implements Comparable<Meet> {
        int start;
        int end;
        public Meet(int start, int end) {
            this.start = start;
            this.end = end;
        }
        @Override
        public int compareTo(Meet o) {
            return Integer.compare(this.end, o.end) != 0 ? Integer.compare(this.end, o.end) : Integer.compare(this.start, o.start);
        }
        @Override
        public String toString() {
            return "Meet [start=" + start + ", end=" + end + "]";
        }
        

        
    }
}
