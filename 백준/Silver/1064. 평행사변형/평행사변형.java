import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// 평행사변형

public class Main {
    static class Node {
        double r, c;

        public Node(double r, double c) {
            this.r = r;
            this.c = c;
        }
        
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Node[] list = new Node[3];
        for (int i = 0; i < 3; i++) {
            list[i] = new Node(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()));
        }

        List<Double> len = new ArrayList<>();
        List<Double> round = new ArrayList<>();


        // 점 사이의 거리 구하기
        for (int i = 0; i < 3; i++) {
            for (int j = i + 1; j < 3; j++) {
                len.add(calLength(list[i], list[j]));
            }
        }
        // 만들 수 있는 평행사변형 둘레 길이
        for (int i = 0; i < 3; i++) {
            for (int j = i + 1; j < 3; j++) {
                round.add(len.get(i) * 2 + len.get(j) * 2);
            }
        }

        Collections.sort(len);
        Collections.sort(round);
        double ccw = (list[1].r - list[0].r) * (list[2].c - list[0].c) - (list[2].r - list[0].r) * (list[1].c - list[0].c);
        System.out.println(ccw == 0.0 ? -1 :round.get(2) - round.get(0));
    }
    private static Double calLength(Node a, Node b) {
        return Math.sqrt(Math.pow(a.r - b.r, 2) + Math.pow(a.c - b.c, 2));
    }
}