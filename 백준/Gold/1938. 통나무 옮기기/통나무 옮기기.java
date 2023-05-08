import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
	static int N;
	static int[][] map;
	static Node start, end;
	static boolean[][][] visited;
	
	static int[] dr = {0, -1, 0, 1};
	static int[] dc = {-1, 0, 1, 0};
	
	// d가 0이면 가로방향/ 1이면 세로방향
	static class Node {
		int r, c, d;

		public Node(int r, int c, int d) {
			super();
			this.r = r;
			this.c = c;
			this.d = d;
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[2][N][N];
		
		// 맵
		for (int i = 0; i < N; i++) {
			char[] ch = br.readLine().toCharArray();
			for (int j = 0; j < ch.length; j++) {
				if (ch[j] == 'B') {
					map[i][j] = 2;
				} else if (ch[j] == 'E') {
					map[i][j] = 3;
				} else if (ch[j] == '0') {
					map[i][j] = 0;
				} else if (ch[j] == '1') {
					map[i][j] = 1;
				}
			}
		}
		
		// 맵에서 시작위치, 끝나는 위치의 중간좌표하고 방향 찾기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 2) {
					if (i + 1 < N && map[i + 1][j] == 2) {
						start = new Node(i + 1, j, 1);
						map[i][j] = map[i + 1][j] = map[i + 2][j] = 0;
					} else if (map[i][j + 1] == 2) {
						start = new Node(i, j + 1, 0);
						map[i][j] = map[i][j + 1] = map[i][j + 2] = 0;
					}	
					
					
				} else if (map[i][j] == 3) {
					if (i + 1 < N && map[i + 1][j] == 3) {
						end = new Node(i + 1, j, 1);
						map[i][j] = map[i + 1][j] = map[i + 2][j] = 0;
					} else if (map[i][j + 1] == 3) {
						end = new Node(i, j + 1, 0);
						map[i][j] = map[i][j + 1] = map[i][j + 2] = 0;
					}	
				}
			}
		}

		int result = bfs();
		
		
		System.out.println(result);
		
	
	}
	private static int bfs() {
		Queue<Node> que = new ArrayDeque<>();
		que.offer(new Node(start.r, start.c, start.d));
		int count = 0;
		while (!que.isEmpty()) {
			int size = que.size();
			for (int i = 0; i < size; i++) {
				Node cur = que.poll();
				
				// 목적지에 도착
				if (cur.r == end.r && cur.c == end.c && cur.d == end.d) {
					return count;
				}
				
				// 방문 체크
				if (visited[cur.d][cur.r][cur.c]) continue;
				visited[cur.d][cur.r][cur.c] = true;
				
				
				
				// 상하좌우 이동
				for (int d = 0; d < 4; d++) {
					int nr = cur.r + dr[d];
					int nc = cur.c + dc[d];
					if (!isInRange(nr, nc) || !directionCheck(nr, nc, cur.d) || map[nr][nc] == 1) continue;
					que.offer(new Node(nr, nc, cur.d));
				}
				
				
				// 회전 이동
				if (!rotateCheck(cur.r, cur.c)) continue;
				que.offer(new Node(cur.r, cur.c, (cur.d + 1) % 2));
				
				
			}
			count++;
		}
		
		return 0;
		
	}
	
	// 회전 체크
	private static boolean rotateCheck(int r, int c) {
		for (int i = r - 1; i < r + 2; i++) {
			for (int j = c - 1; j < c + 2; j++) {
				if (!isInRange(i, j) || map[i][j] == 1) return false;
			}
		}
		return true;
	}
	
	// 방향 체크
	private static boolean directionCheck(int r, int c, int d) {
		if (d == 0) {
			if (!isInRange(r, c + 1) || map[r][c + 1] == 1) return false;
			if (!isInRange(r, c - 1) || map[r][c - 1] == 1) return false;
		} else if (d == 1) {
			if (!isInRange(r + 1, c) || map[r + 1][c] == 1) return false;
			if (!isInRange(r - 1, c) || map[r - 1][c] == 1) return false;
		}
		return true;
	}
	
	//맵 범위안에 있는지
	private static boolean isInRange(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}
}