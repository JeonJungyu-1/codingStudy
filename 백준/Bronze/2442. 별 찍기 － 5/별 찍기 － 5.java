import java.util.Scanner;

public class Main {
	
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		StringBuilder sb = new StringBuilder(); //mutterable string
		for (int i = 0; i < N; i++) {
			for (int j = N - 1 - i; j > 0; j--) {
				sb.append(" ");
			}
			
			for (int k = 0; k < 2 * i + 1 ; k++) {
				sb.append("*");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString()); //immutterable
	}

}



