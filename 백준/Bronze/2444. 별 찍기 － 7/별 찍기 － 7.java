import java.util.Scanner;

public class Main {
	
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		StringBuilder sb = new StringBuilder(); //mutterable string
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N - 1 - i; j++) {
				sb.append(" ");
			}
			
			for (int k = 0; k < 2 * i + 1 ; k++) {
				sb.append("*");
			}
			sb.append("\n");
		}
		
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < i; j++) {
				sb.append(" ");
			}
			
			for (int k = 0; k < 2 * (N - 1 - i) + 1 ; k++) {
				sb.append("*");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString()); //immutterable
	}

}



