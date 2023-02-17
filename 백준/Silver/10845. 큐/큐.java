
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static List<Integer> queue = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        for (int i = 0; i < num; i++) {
            String command = br.readLine();
            int output = -1;
            if (command.contains("push")) {
                push(Integer.parseInt(command.split(" ")[1]));
            } else {
                if (command.equals("pop")) {
                    output = pop();
                } else if (command.equals("size")) {
                    output = size();
                } else if (command.equals("empty")) {
                    output = empty();
                } else if (command.equals("front")) {
                    output = front();
                } else if (command.equals("back")) {
                    output = back();
                }
                print(output);
            }
        }

        System.out.println(sb);
        
    }

    static void print(int num) {
        sb.append(Integer.toString(num)).append("\n");
    }

    static void push(int num) {
        queue.add(num);
    }

    static int pop() {
        if (queue.isEmpty()) {
            return -1;
        } else {
            return queue.remove(0);
        }
    }

    static int size() {
        return queue.size();
    }

    static int empty() {
        if (queue.isEmpty()) {
            return 1;
        } else {
            return 0;
        }
    }

    static int front() {
        if (queue.isEmpty()) {
            return -1;
        } else {
            return queue.get(0);
        }
    }

    static int back() {
        if (queue.isEmpty()) {
            return -1;
        } else {
            return queue.get(queue.size() - 1);
        }
    }
}
