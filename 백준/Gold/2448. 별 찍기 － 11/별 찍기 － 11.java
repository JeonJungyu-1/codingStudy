import java.util.Scanner;

public class Main {
	
	static int N;
	static int[][] star;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		star = new int[N][N/3 * 5 + N/3 - 1];	
		//로직
		star(0, 0, N);
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N/3 * 5 + N/3 - 1; j++) {
				sb.append(star[i][j] == 1 ? "*": " ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	//r: 행 / c: 열 / n: 범위값
	static void star(int r, int c, int n) {
		if (n == 3) {
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 5; j++) {
					if (i == 2 || (i == 1 && (j == 1 || j == 3)) ||(i == 0 && j == 2)) {
						star[r + i][c + j] = 1;	
					}
					
				}
			}
		} else {
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 4; j++) {
					if ((i == 1 && (j == 0 || j == 2)) ||(i == 0 && j == 1)) {
						star(r + i*n/2, c + j*n/2, n/2);
					}	
				}
			}
		}
	}

}



