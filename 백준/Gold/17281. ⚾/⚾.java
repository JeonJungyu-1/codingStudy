import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] numbers;
    static boolean[] isVisited; 
    static int[][] playerList;
    static int[] game;
    static int max;

    public static void main(String[] args) throws NumberFormatException, IOException {
        init();
        solve();
    }

    private static void solve() {
        max = Integer.MIN_VALUE;
        numbers[3] = 0;
        isVisited[0] = true;
        perm(0);
        System.out.println(max);

    }
    private static int playGame() {


        int score = 0;
        int index = 0;
        // 이닝만큼 반복
        for (int i = 0; i < N; i++) {
            // 게임 초기화
            game = new int[4];
            int out = 0;
            while (out < 3) {
                int hit = playerList[i][numbers[index]];
                if (hit != 0) {
                    switch (hit) {
                        case 1:
                        case 2:
                        case 3:
                            for (int k = 3; k >= 1; k--) {
                                if (game[k] != 0) {
                                    game[k]--;
                                    if (k + hit >= 4) {
                                        score++;
                                    } else {
                                        game[k + hit]++;
                                    }
                                }
                            }
                            game[hit]++;
                            break;

                        case 4:
                            for (int k = 1; k <= 3; k++) {
                                if (game[k] != 0) {
                                    game[k] = 0;
                                    score++;
                                }
                            }   
                            score++;
                            break;
                    }
                } else {
                    out++;
                }


                index = (index + 1) % 9;
            }
        }

    

        return score;


    }

    private static void perm(int cnt) {
        if (cnt == 9) {

            max = Math.max(max, playGame());


            return;
        }

        if (cnt != 3) {
            for (int i = 0; i < 9; i++) {
                if (isVisited[i]) continue;
                    isVisited[i] = true;
                    numbers[cnt] = i;
                    perm(cnt + 1);
                    isVisited[i] = false;
            }
        } else {
            perm(cnt + 1);
        }
    }


    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        numbers = new int[9];
        isVisited = new boolean[9];
        playerList = new int[N][9];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                playerList[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}