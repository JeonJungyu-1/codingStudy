import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static List<Member> list;
    static class Member implements Comparable<Member> {
        int index;
        int age;
        String name;
        public Member(int index, int age, String name) {
            this.index = index;
            this.age = age;
            this.name = name;
        }

        
        @Override
        public int compareTo(Member o) {
            int compare = Integer.compare(this.age, o.age);
            return compare == 0 ? Integer.compare(this.index, o.index) : compare;
        }


        
    }
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        list = new ArrayList<>();
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new Member(i, Integer.parseInt(st.nextToken()), st.nextToken()));
        }

        Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        for (Member member : list) {
            sb.append(member.age).append(" ").append(member.name).append("\n");
        }

        System.out.println(sb.toString());

    }
}