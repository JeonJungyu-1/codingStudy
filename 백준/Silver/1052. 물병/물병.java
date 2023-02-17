import java.util.Scanner;

public class Main {
    static boolean canMove = false;
    static int addBottle = 0;
    static int currentMoveBottle = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int firstBottle = sc.nextInt();
        int canMoveBottle = sc.nextInt();
        // 처음 받은 물병에서 2씩 나누어 나가면서 나머지가 1이면 물병 1개씩 증가
        // 구한 물병이 한번에 움직일 수 있는 물병보다 많으면 물병을 추가
        while (true) {
            if (canMove == true) {
                break;
            } else {
                canMove = bottle(firstBottle, canMoveBottle);
            }
        }

        System.out.println(addBottle);

    }

    // 물병 로직
    static boolean bottle(int firstBottle, int canMoveBottle) {
        firstBottle += addBottle;
        currentMoveBottle = 0;
        while (firstBottle > 0) {
            if (firstBottle % 2 == 1) {
                currentMoveBottle++;
            }
            firstBottle /= 2;
        }

        if (currentMoveBottle <= canMoveBottle) return true;

        addBottle++;
        return false;
    }
}
