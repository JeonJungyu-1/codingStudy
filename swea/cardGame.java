package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


// 규영이와 인영이의 카드게임
public class cardGame {
    static int T;
    static int[] nums;
    static int[] myNums;
    static int[] yourNums;
    static int[] permNums;
    static boolean[] isVisited;
    static int win;
    static int lose;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            nums = new int[19];
            myNums = new int[9];
            yourNums = new int[9];
            permNums = new int[9];
            isVisited = new boolean[9];
            win = 0;
            lose = 0;
            for (int i = 0; i < 9; i++) {
                nums[Integer.parseInt(st.nextToken())] = 1;
            }

            int n = 0;
            int m = 0;
            for (int i = 1; i <= 18; i++) {
                if (nums[i] == 1) {
                    myNums[n++] = i;
                } else {
                    yourNums[m++] = i;
                }
            }

            // perm(0);
            do {
                int mySum = 0;
                int yourSum = 0;
                for (int i = 0; i < 9; i++) {
                    if (myNums[i] > yourNums[i]) {
                        mySum += myNums[i] + yourNums[i];
                    } else {
                        yourSum += myNums[i] + yourNums[i];
                    }
                }

                if (mySum > yourSum) {
                    win++;
                } else if (mySum < yourSum) {
                    lose++;
                }
            } while (np(8));

            sb.append("#").append(t).append(" ").append(win).append(" ").append(lose).append("\n");
        }

        System.out.println(sb.toString());
    }
    
    static void perm(int cnt) {
        if (cnt == 9) {
            int mySum = 0;
            int yourSum = 0;
            for (int i = 0; i < 9; i++) {
                if (myNums[i] > permNums[i]) {
                    mySum += myNums[i] + permNums[i];
                } else {
                    yourSum += myNums[i] + permNums[i];
                }
            }

            if (mySum > yourSum) {
                win++;
            } else if (mySum < yourSum) {
                lose++;
            }
            return;
        }

        for (int i = 0; i < 9; i++) {
            if (isVisited[i]) continue;
            isVisited[i] = true;
            permNums[cnt] = yourNums[i];
            perm(cnt + 1);
            permNums[cnt] = 0;
            isVisited[i] = false;
        }

    }

    static boolean np(int size) {
        int i = size;
        while (i > 0 && yourNums[i - 1] > yourNums[i]) i--;
        if (i == 0) return false;

        int j = size;
        while (yourNums[i - 1] > yourNums[j]) j--;
        int temp = yourNums[j];
        yourNums[j] = yourNums[i - 1];
        yourNums[i - 1] = temp;

        int k = size;
        while (i < k) {
            temp = yourNums[i];
            yourNums[i] = yourNums[k];
            yourNums[k] = temp;
            i++;
            k--;
        }

        return true;
    }
    
}
