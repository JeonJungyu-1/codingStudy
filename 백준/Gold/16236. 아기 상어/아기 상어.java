
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

// 아기상어
public class Main {

    static int N;
    static int map[][];
    static int[][] isVisited;
    static Queue<int[]> queue;
    static int shark;
    static int time;
    static int totalTime;
    static int eat;
    static int[] min;
    // 거리가 가깝다면 위, 여러마리 있다면 왼쪽 이니 이동은 위 왼 먼저 하기
    static int[] dr = {-1, 0, 0, 1};
    static int[] dc = {0, -1, 1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        queue = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    queue.add(new int[]{i, j});
                    map[i][j] = 0;
                }
            }
        }
        shark = 2;
        time = 0;
        totalTime = 0;
        eat = 0;
        
        while (true) {
            
            isVisited = new int[N][N];
            min = new int[3];
            Arrays.fill(min, Integer.MAX_VALUE);
            bfsExplore();
            if (min[2] == Integer.MAX_VALUE) break;
            totalTime += min[2];
            queue.add(new int[] {min[0], min[1]});
            map[min[0]][min[1]] = 0;
    

            eat++;
            if (eat == shark) {
                shark++;
                eat = 0;
            }


        }

        System.out.println(totalTime);




        br.close();
    }

    static void bfsExplore() {
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nr = cur[0] + dr[i];
                int nc = cur[1] + dc[i];
                // System.out.printf("%d %d\n", nr, nc );
                if (!mapCheck(nr, nc) || isVisited[nr][nc] != 0 || map[nr][nc] > shark) continue;

                if (map[nr][nc] == 0 || map[nr][nc] == shark) {
                    queue.add(new int[]{nr, nc});
                    isVisited[nr][nc] = isVisited[cur[0]][cur[1]] + 1;
                } else if (map[nr][nc] < shark) {
                    

                    isVisited[nr][nc] = isVisited[cur[0]][cur[1]] + 1;
                    if (min[2] < isVisited[nr][nc]) {
                        break;
                    }
                    min[2] = Math.min(min[2], isVisited[nr][nc]);


                    if (min[0] == nr) {
                        if (min[1] > nc) {
                            min[0] = nr;
                            min[1] = nc;
                        }
                    } else if (min[0] > nr) {
                        min[0] = nr;
                        min[1] = nc;
                    }
                    
                }
              
            }
            

        }
    }


    // static void bfsExplore() {
    //     while (!queue.isEmpty()) {
    //         int[] cur = queue.poll();
    //         // if (isVisited[cur[0]][cur[1]] == true) continue;
    //         for (int i = 0; i < 4; i++) {
    //             int nr = cur[0] + dr[i];
    //             int nc = cur[1] + dc[i];
    //             if (!mapCheck(nr, nc) || isVisited[nr][nc] != 0 || map[nr][nc] > shark) continue;

    //             // 
    //             if (map[nr][nc] == 0 || map[nr][nc] == shark) {
    //                 queue.add(new int[]{nr, nc});
    //                 isVisited[nr][nc] = isVisited[cur[0]][cur[1]] + 1;
    //             } else if (map[nr][nc] < shark) {

            

    //                 queue.clear();
    //                 queue.add(new int[]{nr, nc});
    //                 isVisited[nr][nc] = isVisited[cur[0]][cur[1]] + 1;
    //                 map[nr][nc] = 0;
    //                 eat++;
    //                 if (eat == shark) {
    //                     shark++;
    //                     eat = 0;
    //                 }
    //                 totalTime += isVisited[nr][nc];
    //                 System.out.println(shark);
    //                 System.out.printf("%d %d \n", nr + 1, nc + 1);
    //                 System.out.println(isVisited[nr][nc]);
    //                 System.out.println(totalTime);
    //                 System.out.println();
    //                 isVisited = new int[N][N];
    //                 break;
    //             }
              
    //         }
            

    //     }
    // }

    static boolean mapCheck(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }

    static void mapInit() {
        for (int i = 0; i < N; i++) {
            // for (int j = 0; j < N)
        }
    }
}


