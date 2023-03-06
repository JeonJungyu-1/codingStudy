import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] map;
	static int[] start;
	static int[] dr = {-1, 0, 0, 1};
	static int[] dc = {0, -1, 1, 0};
	static boolean[][] visited;
	static int shark = 2;
	static int eatCount = 0;
	static int result = 0;
	static PriorityQueue<Shark> pq = new PriorityQueue<>();
	
	static class Shark implements Comparable<Shark> {
		int r;
		int c;
		int time;
		
		public Shark(int r, int c, int time) {
			super();
			this.r = r;
			this.c = c;
			this.time = time;
		}

		@Override
		public int compareTo(Shark o) {
			if(this.time == o.time) {
				if(this.r == o.r) {
					return Integer.compare(this.c, o.c);
				}
				return Integer.compare(this.r, o.r);
			}
			return Integer.compare(this.time, o.time);
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		start = new int[2];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 9) {
					
					start[0] = i;
					start[1] = j;
				}
			}
		}
				
		while(bfs()) {
			Shark now = pq.poll();
			map[now.r][now.c] = 0;
			start[0] = now.r;
			start[1] = now.c;
			
			result += now.time;
			eatCount++;
			
			if(eatCount == shark) {
				shark++;
				eatCount = 0;
			}
			
			pq.clear();
		}
		
		System.out.println(result);
	}
	
	// 일단 먹을수 있는 애가 있는지 없는지 체크, 가장 가까운 애부터 먹음
	// bfs로 거리 재면서 가장 가까운 애 먹고, 상어 위치를 거기로 갱신

	private static boolean bfs() {
		Queue<Shark> q = new LinkedList<>();
		q.offer(new Shark(start[0], start[1], 0));
		visited = new boolean[N][N];
		visited[start[0]][start[1]] = true;
		boolean check = false;
		
		a:
		while(!q.isEmpty()) {			
			Shark cur = q.poll();
			int r = cur.r;
			int c = cur.c;
			int time = cur.time;

			for (int i = 0; i < 4; i++) {
				int nr = r+dr[i];
				int nc = c+dc[i];
				
				if(!check(nr, nc)) continue;
				if(visited[nr][nc]) continue;
				if(map[nr][nc] > shark) continue;
				if(map[nr][nc] == shark || map[nr][nc] == 0) {
					visited[nr][nc] = true;
					q.offer(new Shark(nr, nc, time+1));
					continue;
				}
				
				if(map[nr][nc] > 0) {
					pq.offer(new Shark(nr, nc, time+1));
					visited[nr][nc] = true;
					map[start[0]][start[1]] = 0;
					check = true;
					
					continue a;
				}
			}
		}
		// 더이상 먹을 수 있는 물고기가 없으면
		if(!check) return false;
		return true;
	}

	private static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}
}