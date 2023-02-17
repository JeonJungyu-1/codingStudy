import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] light;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " "); 
        StringBuilder sb = new StringBuilder();
        light = new int[size];
        for (int i = 0; i < size; i++) {
            light[i] = Integer.parseInt(st.nextToken());
        }
        
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int gender = Integer.parseInt(st.nextToken());
            int index = Integer.parseInt(st.nextToken());




            if (gender == 2) {
                int k = 1;
                while (true) {
                    if (index - 1 - k < 0 || index - 1 + k >= size || light[index - 1 - k] != light [index - 1 + k]) break;

                    light[index - 1 - k] = light[index - 1 - k] == 1 ? 0 : 1;
                    light[index - 1 + k] = light[index - 1 + k] == 1 ? 0 : 1;

                    k++;

                }
                light[index - 1] = light[index - 1] == 1 ? 0 : 1;

            } else {
                for (int j = index; j <= size; j += index) {
                    light[j - 1] = light[j - 1] == 1 ? 0 : 1;
                }
            }

        }
        for (int i = 0; i < size - 1; i++) {
            sb.append(light[i]).append(" ");
            if ((i + 1) % 20 == 0 ) {
                sb.append("\n");
            }
        }
        sb.append(light[size - 1]);
        System.out.println(sb.toString());

    }
}
