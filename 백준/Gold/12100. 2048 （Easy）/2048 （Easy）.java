import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] map;
    static Queue<Integer> que;
    static int maxNumber;
    public static void main(String[] args) throws NumberFormatException, IOException {
        solve();
        
    }
    private static void solve() throws IOException {
        init();
        maxNumber = Integer.MIN_VALUE;
        explore(0);

        System.out.println(maxNumber);
    }
    private static void explore(int cnt) {
        if (cnt == 5) {
            findMaxNumber();

            
            return;
        }


        int[][] copyMap = new int[N][N];
        mapCopy(copyMap);

        for (int i = 0; i < 4; i++) {
            que.clear();
            move(i);
            explore(cnt + 1);
            initMap(copyMap);

        }
    }
    private static void mapCopy(int[][] copyMap) {
        for (int i = 0; i < N; i++) {
            copyMap[i] = Arrays.copyOf(map[i], N);
        }
    }
    private static void findMaxNumber() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 0) continue;
                maxNumber = Math.max(maxNumber, map[i][j]);
            }
        }
    }
    private static void initMap(int[][] copyMap) {
        for (int j = 0; j < N; j++) {
            map[j] = Arrays.copyOf(copyMap[j], N);
        }
    }
    private static void move(int i) {
        switch (i) {
            //아래
            case 0:
                for (int c = 0; c < N; c++) {
                    for (int r = N - 1; r >= 0; r--) {
                        if (map[r][c] != 0) {
                            que.offer(map[r][c]);
                            map[r][c] = 0;
                        }
                    }

                    for (int r = N - 1; r >= 0; r--) {
                        if (!que.isEmpty()) {
                            if (r == N - 1) {
                                map[r][c] = que.poll();
                            } else if (map[r + 1][c] == que.peek()) {
                                map[r + 1][c] = 2 * que.poll();
                                if (!que.isEmpty()) map[r][c] = que.poll();
                            } else {
                                map[r][c] = que.poll();
                            }
                        }
                    }


                }
                break;

            //위
            case 1:
                for (int c = 0; c < N; c++) {
                    for (int r = 0; r < N; r++) {
                        if (map[r][c] != 0) {
                            que.offer(map[r][c]);
                            map[r][c] = 0;
                        }
                    }

                    for (int r = 0; r < N; r++) {
                        if (!que.isEmpty()) {
                            if (r == 0) {
                                map[r][c] = que.poll();
                            } else if (map[r - 1][c] == que.peek()) {
                                map[r - 1][c] = 2 * que.poll();
                                if (!que.isEmpty()) map[r][c] = que.poll();
                            } else {
                                map[r][c] = que.poll();
                            }
                        }
                    }

                }
                break;

            //좌
            case 2:
                for (int r = 0; r < N; r++) {
                    for (int c = N - 1; c >= 0; c--) {
                        if (map[r][c] != 0) {
                            que.offer(map[r][c]);
                            map[r][c] = 0;
                        }
                    }

                    for (int c = N - 1; c >= 0; c--) {
                        if (!que.isEmpty()) {
                            if (c == N - 1) {
                                map[r][c] = que.poll();
                            } else if (map[r][c + 1] == que.peek()) {
                                map[r][c + 1] = 2 * que.poll();
                                if (!que.isEmpty()) map[r][c] = que.poll();
                            } else {
                                map[r][c] = que.poll();
                            }
                        }
                    }

                    
                }

                break;
                
                //우
            case 3:
                for (int r = 0; r < N; r++) {
                    for (int c = 0; c < N; c++) {
                        if (map[r][c] != 0) {
                            que.offer(map[r][c]);
                            map[r][c] = 0;
                        }
                    }

                    for (int c = 0; c < N; c++) {
                        if (!que.isEmpty()) {
                            if (c == 0) {
                                map[r][c] = que.poll();
                            } else if (map[r][c - 1] == que.peek()) {
                                map[r][c - 1] = 2 * que.poll();
                                if (!que.isEmpty()) map[r][c] = que.poll();
                            } else {
                                map[r][c] = que.poll();
                            }
                        }
                    }
                }
                break;
        }
    }
    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        que = new ArrayDeque<>();
    }
}