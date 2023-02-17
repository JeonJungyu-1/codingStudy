
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[][] map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        
        // 너비(열)는 2i + 3, 높이(행)는 2i + 1
        //배열 사이즈 찾기
        int[] arrSize = new int[]{1, 1};
        for (int i = 1; i < num; i++) {
            arrSize[0] = arrSize[0] * 2 + 1;
            arrSize[1] = arrSize[1] * 2 + 3;
        }

        // System.out.println(arrSize[0]);
        // System.out.println(arrSize[1]);
        //맵 생성 후 0으로 채워넣기
        map = new int[arrSize[0]][arrSize[1]];
        for (int i = 0; i < map.length; i++) {
            Arrays.fill(map[i], 0);
        }

        // 초기좌표하고 받은 세모 단계 넣어서 star 호출
        star(0, 0, num, arrSize[0], arrSize[1]);

        // 맵에 들어있는 값들을 스트링빌더에 추가
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == 1) {
                    sb.append("*");
                } else  {
                    if (num % 2 == 0 && j < arrSize[1] - i) {
                        sb.append(" ");
                    } else if (num % 2 == 1 && j < i + arrSize[1]/2) {
                        sb.append(" ");
                    }
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void star(int r, int c, int n, int rSize, int cSize) {
        // 그릴 수 없는 세모가 없을 때 return
        if (n == 0) return;
        
        // 한단계 작은 세모 그리기
        
        star(r + (n % 2 == 0 ? 1 : rSize / 2), c == 0 ? (int)Math.pow(2, n - 1) : c + (int)Math.pow(2, n - 1), n - 1, (rSize - 1)/2, (cSize - 3)/2);
        
        // System.out.printf("%d %d %d %d %d\n", r, c, n , rSize, cSize);
        // 현재 세모 단계가 홀수면 삼각형, 짝수면 역삼각형
        // 세모 부분을 1로 바꾸기
        if (n % 2 == 1) {
            for (int i = r; i < r + rSize; i++) {
                if (i == r) {
                    map[i][c + cSize / 2] = 1;
                }else if (i == r + rSize - 1) {
                    for (int j = c; j < c + cSize; j++) {
                        map[i][j] = 1;
                    }
                } else {
                    map[i][c + cSize/2 - i + r] = 1;
                    map[i][c + cSize/2 + i - r] = 1;
                }
            }
        } else {
            for (int i = r; i < r + rSize; i++) {
                if (i == r + rSize - 1) {
                    map[i][c + cSize / 2] = 1;
                } else if (i == r) {
                    for (int j = c; j < c + cSize; j++) {
                        map[i][j] = 1;
                    }
                } else {
                    map[i][c + i - r] = 1;
                    map[i][c + cSize - i + r - 1] = 1;
                }
            }
        }


        

    }
}
