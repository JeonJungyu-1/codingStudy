
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int num = Integer.parseInt(br.readLine());

        // 입력받은 숫자만큼 반복
        for (int i = 0; i < num; i++) {
            // 한줄씩 별 넣어주기
            if (i % 2 == 0) {  // 행이 홀수일떄
                for (int j = 0; j < num * 2 - 1; j++) {
                    if (j % 2 == 0) { 
                        sb.append("*");
                    } else {
                        sb.append(" ");
                    }
                }
            } else {  // 행이 짝수일때
                for (int j = 0; j < num * 2; j++) {
                    // 행이 홀수고, 열이 홀수거나 행이 짝수고, 열이 짝수면 별 넣기
                    if (j % 2 == 1) {
                        sb.append("*");
                    } else {
                        sb.append(" ");
                    }
                }

            }
            
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
