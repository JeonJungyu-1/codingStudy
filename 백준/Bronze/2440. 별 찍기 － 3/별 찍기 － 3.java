import java.util.Scanner;

public class Main {
	
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		for (int i = 0; i < N; i++) {
			for (int j = N; j > i; j--) {
				System.out.print("*");
			}
			System.out.println();
		}

	}

}

