package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// 강의실 배정
// 1. 리스트에 강의 시간 모두 저장
// 2. 큐에 처음 회의의 끝나는 시간을 저장
// 3. 이 값이 다음 회의시간의 시작시간보다 작거나 같으면 큐에 저장된 값을 빼고 새로운 회의 시간의 끝나는 시간을 저장
// 4. 위 과정을 계속 반복하면 최종적으로 큐에 저장 값의 수가 최소의 강의실 수
// 삭제시 O(N)이 걸리는 배열이 아닌 O(logN)이 걸리는 우선순위 큐를 이용
// 시작시간순으로 정렬하기(회의 간의 간격을 최대한 줄이기 위해서)
public class BJ11000 {
    static StringBuilder sb;
    static int N;
    static List<Study> list = new ArrayList<>();
    static Queue<Integer> timeQue = new PriorityQueue<>();
    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }
    
    private static void print() {
        System.out.println(timeQue.size());
    }
    
    private static void solve() {
        Collections.sort(list);
        timeQue.add(-1);
        for (int i = 0; i < list.size(); i++) {
            Study st = list.get(i);
            if (st.start >= timeQue.peek()) timeQue.poll();
            timeQue.add(st.end);
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new Study(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }

    static class Study implements Comparable<Study> {
        int start;
        int end;
        public Study(int start, int end) {
            this.start = start;
            this.end = end;
        }
        @Override
        public int compareTo(Study o) {
            return this.start != o.start ? Integer.compare(this.start, o.start) : Integer.compare(this.end, o.end);
        }
        @Override
        public String toString() {
            return "Study [start=" + start + ", end=" + end + "]";
        }

        
        
    }
}
    



