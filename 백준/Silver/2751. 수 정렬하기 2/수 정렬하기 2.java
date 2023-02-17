
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class Main {
    // 시간초과 실패
    // public static void main(String[] args) throws Exception {
    //     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //     int num = Integer.parseInt(br.readLine());
    //     int[] numArr = new int[num];

    //     for (int i = 0; i < numArr.length; i++) {
    //         numArr[i] = Integer.parseInt(br.readLine());
    //     }

    //     Arrays.sort(numArr);

    //     StringBuilder sb = new StringBuilder();
    //     for (int i = 0; i < numArr.length; i++) {
    //         sb.append(numArr[i]);
    //         sb.append("\n");
    //     }

    //     System.out.println(sb);
    // }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        ArrayList<Integer> numArr = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            numArr.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(numArr);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numArr.size(); i++) {
            sb.append(numArr.get(i));
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
