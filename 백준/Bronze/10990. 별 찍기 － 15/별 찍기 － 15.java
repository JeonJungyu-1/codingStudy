import java.util.Scanner;

public class Main {
	
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N * 2 - 1; j++) {
				if ((i == 0 && j == N - 1) || (i != 0 &&Math.abs(N - 1 - j) == i)) {
					sb.append("*");
				} else if ((i == 0 && j < N - 1) || (i != 0 && j - N - 1 < i)) {
					sb.append(" ");
				}
				
			}
			sb.append("\n");
		}		
		
		System.out.println(sb.toString());
	}

}