import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    static int N, M, R;
    static int[] num;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
        
    }
    private static void print() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    private static void rotatePrint() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    

    private static void solve() {
        for (int i = 0; i < R; i++) {
            switch (num[i]) {
                case 1:
                    updownChange();
                    break;
    
                case 2:
                    leftrightChange();
                    break;
    
                case 3:
                    rightRotate();
                    break;
    
                case 4:
                    leftRotate();
                    break;
    
                case 5:
                    divideRight();
                    break;
    
                case 6:
                    divideleft();
                    break;
            }
        }

    }

    // 1번 상하 반전
    private static void updownChange() {
        int[][] copyMap = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                copyMap[N - 1 - i][j] = map[i][j];
            }
        }

        mapCopy(copyMap, N, M);
    }

    // 2번 좌우 반전
    private static void leftrightChange() {
        int[][] copyMap = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                copyMap[i][M - 1 - j] = map[i][j];
            }
        }
        mapCopy(copyMap, N, M);
    }


    // 3번 오른쪽 90도 회전
    private static void rightRotate() {
        int[][] copyMap = new int[M][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                copyMap[j][N - 1 - i] = map[i][j];
            }
        }
        
        map = new int[M][N];
        mapCopy(copyMap, M, N);
        nmChange();
    }
    private static void nmChange() {
        int temp = N;
        N = M;
        M = temp;
    }
    // 4번 왼쪽 90도 회전
    private static void leftRotate() {
 
        int[][] copyMap = new int[M][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                copyMap[M - 1 - j][i] = map[i][j];
            }
        }
        map = new int[M][N];
        mapCopy(copyMap, M, N);
        nmChange();
    }
    
    // 5번 그룹 오른쪽 이동
    private static void divideRight() {
        int[][] temp = new int[N/2][M/2];
        
        for (int i = 0; i < N/2; i++) {
            temp[i] = Arrays.copyOf(map[i], M/2);
        }

        for (int i = 0; i < N/2; i++) {
            for (int j = 0; j < M/2; j++) {
                map[i][j] = map[N/2 + i][j];
            }
        }

        for (int i = 0; i < N/2; i++) {
            for (int j = 0; j < M/2; j++) {
                map[N/2 + i][j] = map[N/2 + i][M/2 + j];
            }
        }

        for (int i = 0; i < N/2; i++) {
            for (int j = 0; j < M/2; j++) {
                map[N/2 + i][M/2 + j] = map[i][M/2 + j];
            }
        }



        for (int i = 0; i < N/2; i++) {
            for (int j = 0; j < M/2; j++) {
                map[i][M/2 + j] = temp[i][j];
            }
        }
    }

    // 6번 그룹 왼쪽 이동
    private static void divideleft() {
        int[][] temp = new int[N/2][M/2];
        
        for (int i = 0; i < N/2; i++) {
            temp[i] = Arrays.copyOf(map[i], M/2);
        }

        for (int i = 0; i < N/2; i++) {
            for (int j = 0; j < M/2; j++) {
                map[i][j] = map[i][M/2 + j];
            }
        }

        for (int i = 0; i < N/2; i++) {
            for (int j = 0; j < M/2; j++) {
                map[i][M/2 + j] = map[N/2 + i][M/2 + j];
            }
        }

        for (int i = 0; i < N/2; i++) {
            for (int j = 0; j < M/2; j++) {
                map[N/2 + i][M/2 + j] = map[N/2 + i][j];
            }
        }



        for (int i = 0; i < N/2; i++) {
            for (int j = 0; j < M/2; j++) {
                map[N/2 + i][j] = temp[i][j];
            }
        }

    }
    
    
    
    
    // 맵 카피 함수
    private static void mapCopy(int[][] copyMap, int NSize, int MSize) {
        for (int i = 0; i < NSize; i++) {
            map[i] = Arrays.copyOf(copyMap[i], MSize);
        }
    }
    
    
    // 입력 받기
    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        num = new int[R];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < R; i++) {
            num[i] = Integer.parseInt(st.nextToken()) ;
        }
    }
}

