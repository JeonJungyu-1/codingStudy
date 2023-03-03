import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int R, C, M;
    static int[][] map;
    static Shark[] sharkList;
    static int fisher;
    static int[] d = {0, -1, 1, 1, -1};
    static int cnt;


    
    static class Shark {
        int r, c, s, d, z;

        public Shark(int r, int c, int s, int d, int z) {
            this.r = r;
            this.c = c;
            this.s = s;
            this.d = d;
            this.z = z;
        }
        
    }
    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }
    private static void print() {
        System.out.println(cnt);
    }
    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        sharkList = new Shark[M];
        for (int i = 0; i < R; i++) {
            Arrays.fill(map[i], -1);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            sharkList[i] = new Shark(r, c, s, d, z);
            map[r][c] = i;
        }
    }
    private static void solve() {
        cnt = 0;
        // 낚시왕 오른쪽으로 한칸 이동
        for (int fisher = 0; fisher < C; fisher++) {

            // 상어 잡기
            killShark(fisher);
            
            // 맵 초기화
            for (int i = 0; i < R; i++) {
                Arrays.fill(map[i], -1);
            }
            
            for (int i = 0; i < sharkList.length; i++) {
                if (sharkList[i] == null) continue;
                // 상어 이동
                sharkMove(sharkList[i]);
                // 이동후 같은 칸 상어 먹기
                eatShark(i);
            }

        }
    }
    private static void killShark(int fisher) {
        for (int i = 0; i < R; i++) {
            if (map[i][fisher] != -1) {
                cnt += sharkList[map[i][fisher]].z;
                sharkList[map[i][fisher]] = null;
                map[i][fisher] = -1;
                break;
            }
        }
    }
    private static void eatShark(int i) {
        if (map[sharkList[i].r][sharkList[i].c] == -1) {
            map[sharkList[i].r][sharkList[i].c] = i;
        } else {
            int oldSharkIndex = map[sharkList[i].r][sharkList[i].c];
            if (sharkList[oldSharkIndex].z > sharkList[i].z) {
                sharkList[i] = null;
            } else {
                sharkList[oldSharkIndex] = null;
                map[sharkList[i].r][sharkList[i].c] = i;
            }
        }
    }

    private static void sharkMove(Shark shark) {
        switch (shark.d) {
            case 1:
            case 2:
                for (int i = 0; i < shark.s; i++) {
                    if (!rowCheck(shark.r + d[shark.d])) shark.d = 3 - shark.d;
                    shark.r += d[shark.d];
                }
                break;
            case 3:
            case 4:
                for (int i = 0; i < shark.s; i++) {
                    if (!columnCheck(shark.c + d[shark.d])) shark.d = 7 - shark.d;
                    shark.c += d[shark.d];
                }
                break;
        }

    }

    private static boolean rowCheck(int r) {
        return r >= 0 && r < R;
    }

    private static boolean columnCheck(int c) {
        return c >= 0 && c < C;
    }
}