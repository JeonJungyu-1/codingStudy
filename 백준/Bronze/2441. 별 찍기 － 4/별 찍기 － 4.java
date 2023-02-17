import java.util.Scanner;

public class Main {
	
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		StringBuilder sb = new StringBuilder(); //mutterable string
		for (int i = 0; i < N; i++) {
			for (int k = 0; k < i; k++) {
				sb.append(" ");
//				System.out.print(" ");
			}
			
			for (int j = N; j > i; j--) {
				sb.append("*");
//				System.out.print("*");
			}
//			System.out.println();
			sb.append("\n");
		}
		System.out.println(sb.toString()); //immutterable
	}

}
