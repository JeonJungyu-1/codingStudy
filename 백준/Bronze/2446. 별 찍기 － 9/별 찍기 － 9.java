import java.util.Scanner;

public class Main {
	
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		StringBuilder sb = new StringBuilder(); //mutterable string
		
		N = 2 * N - 1;
		
		for (int i = 0; i < N; i++) {
			int num = Math.abs(i - N / 2);
			for (int k = 0; k < Math.abs(num - N / 2); k++) {
				sb.append(" ");
			}
			
			for (int j = 0; j < 2 * num + 1; j++) {
				sb.append("*");
			}
			
			sb.append("\n");
		}		
		
		System.out.println(sb.toString()); //immutterable
	}

}



