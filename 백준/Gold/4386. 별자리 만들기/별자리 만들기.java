import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//Nc2
public class Main {
	static int N;
	static int[] p, r;
	static PriorityQueue<Star> pq;
	static Node[] nodeList;
	static int[] twoNode;

	static class Star implements Comparable<Star> {
		int start;
		int end;
		double distance;
        public Star(int start, int end, double distance) {
            this.start = start;
            this.end = end;
            this.distance = distance;
        }
        @Override
        public int compareTo(Star o) {
            return Double.compare(this.distance, o.distance);
        }
		
	}

	static class Node {
		double r;
		double c;
		public Node(double r, double c) {
			this.r = r;
			this.c = c;
		}
        @Override
        public boolean equals(Object obj) {
			Node n = (Node)obj;
            return this.r == n.r && this.c == n.c;
        }
		
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		init();
		solve();
	}

	private static void solve() {
		combi(0, 0);

		makeSet();
		int cnt = 0;
		double min = 0;
		while (cnt != N - 1) {
			Star star = pq.poll();
			if (union(star.start, star.end)) {
				min += star.distance;
				cnt++;
			}
		}

		System.out.println(String.format("%.2f", min));
	}

	private static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		nodeList = new Node[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			double r = Double.parseDouble(st.nextToken());
			double c = Double.parseDouble(st.nextToken());
			nodeList[i] = new Node(r, c);
		}

		twoNode = new int[2];
		pq = new PriorityQueue<>();
	}

	private static boolean union(int x, int y) {
		int px = find(x);
		int py = find(y);
		if (px == py) return false;
		if (r[px] > r[py]) {
			p[py] = px;
			r[px] += r[py];
		} else {
			p[px] = py;
			r[py] += r[px];
		}
		return true;
	}

	private static int find(int x) {
		if (x == p[x]) return x;
		else return p[x] = find(p[x]);
	}

	private static void makeSet() {
		p = new int[N + 1];
		r = new int[N + 1];
		for (int i = 0; i < N; i++) {
			p[i] = i;
			r[i] = 1;
		}
	}

	private static void combi(int cnt, int start) {
		if (cnt == 2) {
			int first = twoNode[0];
			int second = twoNode[1];
			Double distance = Math.sqrt(Math.pow(nodeList[first].r - nodeList[second].r, 2) + Math.pow(nodeList[first].c - nodeList[second].c, 2));
			pq.offer(new Star(first, second, distance));
			return;
		}

		for (int i = start; i < N; i++) {
			twoNode[cnt] = i;
			combi(cnt + 1, start + 1);
		}
	}

}