package baekjoon;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ1259 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder outputStr = new StringBuilder("");
        while (true) {
            String str = br.readLine();
            StringBuilder sb = new StringBuilder(str);
            if (str.equals("0")) {
                break;
            }

            

            if (str.equals(sb.reverse().toString())) {
                outputStr.append("yes").append("\n");
            } else {
                outputStr.append("no").append("\n");
            }
        }

        System.out.println(outputStr);
    }
}
