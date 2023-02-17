
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int num = Integer.parseInt(br.readLine());

        for (int j = 0; j < 2; j ++) {
            for (int i = 0; i < num; i++) {
                if ((i + j) % 2 == 0) {
                    sb.append("*");
                } else {
                    // if ((num % 2 == 0 && i % 2 == 1) || (num % 2 == 0 && i % 2 == 0)) break;
    
                    sb.append(" ");
                }
            }

            if (j == 0) {
                sb.append("\n");
            }
        }

        

        for (int i = 0; i < num; i++) {
            System.out.println(sb);
        }

    }    
}
