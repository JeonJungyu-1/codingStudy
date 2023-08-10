import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// 랭킹전 대기열

public class Main {
    
    static StringBuilder sb;

    static class Room {
        int cnt;
        int firstLevel;
        Queue<User> list;
        public Room(int cnt, int firstLevel) {
            this.cnt = cnt;
            this.firstLevel = firstLevel;
            this.list = new PriorityQueue<>();
        }
        
    }

    static class User implements Comparable<User> {
        String n;
        int l;
        public User(String n, int l) {
            this.n = n;
            this.l = l;
        }
        @Override
        public int compareTo(User o) {
            return this.n.compareTo(o.n);
        }

        

        
    }


    public static void main(String[] args) throws IOException {
        solve();
    }
 

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<Room> roomList = new ArrayList<>();
        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            String n = st.nextToken();
            boolean isEnter = false;
            for (Room r : roomList) {
                if (r.cnt < m && r.firstLevel + 10 >= l && r.firstLevel - 10 <= l) {
                    isEnter = true;
                    r.list.add(new User(n, l));
                    r.cnt++;
                    break;
                }
            }

            if (!isEnter) {
                Room r = new Room(1, l);
                r.list.add(new User(n, l));
                roomList.add(r);
            }
        }

        for (Room r : roomList) {

            if (r.cnt == m) {
                sb.append("Started!");
            } else {
                sb.append("Waiting!");
            }
            sb.append("\n");

            while (!r.list.isEmpty()) {
                User u = r.list.poll();
                sb.append(u.l).append(" ").append(u.n).append("\n");
            }

        }

        System.out.println(sb.toString());




    }
}