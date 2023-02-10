package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class BJ4256 {
    static int[] nums;
    public static void main(String[] args) throws IOException {
        TreeSet<Integer> treeSet = new TreeSet<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        // 전위 순회는 뿌리->왼쪽 자식->오른쪽 자식 순
        // 중위 순회는 왼쪽자식-> 뿌리-> 오른쪽 자식
        // 후위 순회는 왼쪽자식->오른쪽 자식-> 뿌리
        
        // 전위 처음이 뿌리

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine());

            // 전위 순회한 값 저장
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                treeSet.add(Integer.valueOf(st.nextToken()));
            }
            System.out.println(treeSet);
            System.out.println(treeSet.last());

            Iterator iter = treeSet.iterator();	// Iterator 사용
            while(iter.hasNext()) {//값이 있으면 true 없으면 false
                System.out.println(iter.next());
            }
        }
    }

}
