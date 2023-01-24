package baekjoon;

import java.util.Scanner;

public class BJ1546 {
    static int maxNum = -1;
    static double[] updateNumbers;
    static double sum = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        updateNumbers = new double[count];
        // 최대값 찾기
        for (int i = 0; i < count; i++) {
            int currentNum = sc.nextInt();
            updateNumbers[i] = currentNum;
            if (maxNum < currentNum) {
                maxNum = currentNum;
            }
        }

        // 점수 수정하기
        for (int i = 0; i < updateNumbers.length; i++) {
            updateNumbers[i] = updateNumbers[i] / maxNum * 100;
            sum += updateNumbers[i];
        }

        System.out.println(sum / count);
    }
}
