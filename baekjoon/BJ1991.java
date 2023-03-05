package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

// 트리 순회
// 전위순회, 중위순회, 후위순회


public class BJ1991 {
    static StringBuilder sb;
    static int N;
    static Node[] adj;



    static class Node {
        char index;
        Node left;
        Node right;
        public Node(char index) {
            this.index = index;
            this.left = null;
            this.right = null;
        }
        @Override
        public String toString() {
            return "Node [index=" + index + ", left=" + left + ", right=" + right + "]";
        }
    }


    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }
    
    private static void print() {
        System.out.println(sb.toString());
    }

    private static void solve() {
        preOrder(adj[0]);
        sb.append("\n");
        inOrder(adj[0]);
        sb.append("\n");
        postOrder(adj[0]);
    }


    static void preOrder(Node node) {
        sb.append(node.index);
        if (node.left != null) {
            preOrder(node.left);
        }
        if (node.right != null) {
            preOrder(node.right);
        }
    }
    static void inOrder(Node node) {
        if (node.left != null) {
            inOrder(node.left);
        }
        sb.append(node.index);
        if (node.right != null) {
            inOrder(node.right);
        }
    }
    static void postOrder(Node node) {
        if (node.left != null) {
            postOrder(node.left);
        }
        if (node.right != null) {
            postOrder(node.right);
        }
        sb.append(node.index);
    }
    
    
    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());

        adj = new Node[N];
        

        char root = 'A';
        for (int i = 0; i < N; i++) {
            adj[i] = new Node(root++);
        }
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            char index = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);
            if (left != '.') {
                adj[index - 65].left = adj[left - 65];
            }

            if (right != '.') {
                adj[index - 65].right = adj[right - 65];
            }

        }


    }
}
