import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
    static int T, N;
    static List<Node> stair;
    static List<Node> person;
    static int minTime;
    static Node[] selected;
    
    static class Node implements Comparable<Node> {
        int r, c, time, type, down, stairIndex;
        boolean isSuccess, isDown;


        public Node(int r, int c, int type) {
            this.r = r;
            this.c = c;
            this.type = type;
        }

        public Node(int type, int time) {
            this.type = type;
            this.time = time;
        }

        

        public Node(int r, int c, int type, int time, int stairIndex) {
            this.r = r;
            this.c = c;
            this.time = time;
            this.type = type;
            this.stairIndex = stairIndex;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.time, o.time);
        }

        @Override
        public String toString() {
            return "Node [r=" + r + ", c=" + c + ", time=" + time + ", type=" + type + ", down=" + down + ", isSuccess="
                    + isSuccess + "]";
        }

        
        

        

        
        
    }
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            stair = new ArrayList<>();
            person = new ArrayList<>();
            

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    int number = Integer.parseInt(st.nextToken());
                    if (number == 1) {
                        person.add(new Node(i, j, 0));
                    } else if (number != 0) {
                        stair.add(new Node(i, j, number));
                    }
                }
            }
            selected = new Node[person.size()];
            minTime = Integer.MAX_VALUE;
            // System.out.println(stair);
            // System.out.println(person);
            perm(0);
            
            
            sb.append("#").append(t).append(" ").append(minTime).append("\n");
            
        }
        System.out.println(sb.toString());
    }
    private static void perm(int cnt) {
        if (cnt == person.size()) {
            
            Node[] newSelected = new Node[person.size()];
            for (int i = 0; i < person.size(); i++) {
                newSelected[i] = new Node(selected[i].r, selected[i].c, selected[i].type, selected[i].time, selected[i].stairIndex);
                newSelected[i].down = -1;
            }
            Arrays.sort(newSelected);
            
            int time = 1;
            int[] personCount = new int[stair.size()];
            while (true) {
                boolean isEnd = true;
                for (int i = 0; i < newSelected.length; i++) {
                    if (newSelected[i].isSuccess) continue;
                    isEnd = false;
                    if (newSelected[i].down == time) {
                        personCount[newSelected[i].stairIndex]--;
                        newSelected[i].isSuccess = true;
                    }
                    
                    if (newSelected[i].down == -1 && (newSelected[i].time == time || newSelected[i].isDown) && personCount[newSelected[i].stairIndex] != 3) {
                        personCount[newSelected[i].stairIndex]++;
                        newSelected[i].down = time + newSelected[i].type; 
                    }

                    if (newSelected[i].down == -1 && newSelected[i].time == time && personCount[newSelected[i].stairIndex] == 3) {
                        newSelected[i].isDown = true;
                    } 
                }
                if (isEnd) break;
                time++;
            }
            // System.out.println(Arrays.toString(selected));
            minTime = Math.min(time, minTime);

            return;
        }


        for (int i = 0; i < stair.size(); i++) {
            selected[cnt] = new Node(person.get(cnt).r, person.get(cnt).c, stair.get(i).type, calculateTime(stair.get(i), person.get(cnt)), i);
            perm(cnt + 1);
        }
    }
    private static int calculateTime(Node a, Node b) {
        return Math.abs(a.r - b.r) + Math.abs(a.c - b.c);
    }
}
