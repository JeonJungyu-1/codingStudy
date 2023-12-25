import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 두 동전

public class Main {
    
    static StringBuilder sb;
    static int N, M;
    static int[][] map;
    static Coin coin;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1};

    static class Coin {
        int aR, aC, bR, bC, cnt;

        

        public Coin() {
        }



        public Coin(int aR, int aC, int bR, int bC, int cnt) {
            this.aR = aR;
            this.aC = aC;
            this.bR = bR;
            this.bC = bC;
            this.cnt = cnt;
        }

        
    }

    public static void main(String[] args) throws IOException {
        solve();
    }
    
    private static void print() {

    }

    private static void solve() throws IOException {
        init();

        int result = bfs();
        System.out.println(result);

        print();
    }

    private static int bfs() {
        Queue<Coin> que = new ArrayDeque<>();
        que.offer(coin);
        

        while (!que.isEmpty()) {
            Coin cur = que.poll();

            if (cur.cnt > 10) {
                return -1;
            }


            for (int i = 0; i < 4; i++) {
                int naR = cur.aR + dr[i];
                int naC = cur.aC + dc[i];
                int nbR = cur.bR + dr[i];
                int nbC = cur.bC + dc[i];

                // 둘다 벽 -> 끝
                if (isInRange(naR, naC) && map[naR][naC] == 1 && isInRange(nbR, nbC) && map[nbR][nbC] == 1) {

                }

                // 하나만 벽, 하나 바깥 -> 성공
                else if (isInRange(naR, naC) && map[naR][naC] == 1 && !isInRange(nbR, nbC)) {
                    return cur.cnt;
                } else if (isInRange(nbR, nbC) && map[nbR][nbC] == 1 && !isInRange(naR, naC)) {
                    return cur.cnt;
                }


                // 하나만 벽, 하나 이동 -> 다음
                else if (isInRange(naR, naC) && map[naR][naC] == 1 && isInRange(nbR, nbC)) {
                    que.offer(new Coin(cur.aR, cur.aC, nbR, nbC, cur.cnt + 1));
                } else if (isInRange(nbR, nbC) && map[nbR][nbC] == 1 && isInRange(naR, naC)) {
                    que.offer(new Coin(naR, naC, cur.bR, cur.bC, cur.cnt + 1));
                }
                

                // 하나 바깥, 하나 이동 -> 성공
                else if (isInRange(naR, naC) && !isInRange(nbR, nbC)) {
                    return cur.cnt;
                } else if (isInRange(nbR, nbC) && !isInRange(naR, naC)) {
                    return cur.cnt;
                }

                // 둘다 이동 -> 다음
                else if (isInRange(naR, naC) && isInRange(nbR, nbC)) {
                    que.offer(new Coin(naR, naC, nbR, nbC, cur.cnt + 1));
                }

                // 둘다 바깥 -> 끝
                else if (!isInRange(naR, naC) && !isInRange(nbR, nbC)) {

                }



            }

        }

        return -1;

    }

    private static boolean isInRange(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        coin = new Coin(-1, -1, -1, -1, 1);


        for (int i = 0; i < N; i++) {
            char[] ch = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                if (ch[j] == 'o') {
                    if (coin.aR == -1) {
                        coin.aR = i;
                        coin.aC = j;
                    } else {
                        coin.bR = i;
                        coin.bC = j;
                    }
                } else if (ch[j] == '#') {
                    map[i][j] = 1;
                }
            }
        }
        



        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}