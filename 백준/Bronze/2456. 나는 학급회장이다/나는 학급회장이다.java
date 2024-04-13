import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 나는 학급회장이다

public class Main {
    
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        solve();
    }
    
    private static void print() {

    }

    private static void solve() throws IOException {
        init();
        print();
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[3];
        int[] B = new int[3];
        int[] C = new int[3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            A[a - 1]++;
            B[b - 1]++;
            C[c - 1]++;
        }

        int sumA = 0;
        int sumB = 0;
        int sumC = 0;
        for (int i = 0; i < 3; i++) {
            sumA += (A[i] * (i + 1));
            sumB += (B[i] * (i + 1));
            sumC += (C[i] * (i + 1));
        }


        if (sumA >= sumB && sumA > sumC) {
            if (sumA > sumB) {
                sb.append("1 ").append(sumA);
            } else if (sumA < sumB) {
                sb.append("2 ").append(sumB);
            } else {
                if (A[0] > B[0]) {
                    sb.append("1 ").append(sumA);
                } else if (A[0] < B[0]) {
                    sb.append("2 ").append(sumB);
                } else {
                    if (A[1] > B[1]) {
                        sb.append("1 ").append(sumA);
                    } else if (A[1] < B[1]) {
                        sb.append("2 ").append(sumB);
                    } else {
                        if (A[2] > B[2]) {
                            sb.append("1 ").append(sumA);
                        } else if (A[2] < B[2]) {
                            sb.append("2 ").append(sumB);
                        } else {
                            sb.append("0 ").append(sumA);
                        }
                    }
                }
            }
        } else if (sumB >= sumC && sumB > sumA) {
            if (sumB > sumC) {
                sb.append("2 ").append(sumB);
            } else if (sumB < sumC) {
                sb.append("3 ").append(sumC);
            } else {
                if (B[0] > C[0]) {
                    sb.append("2 ").append(sumB);
                } else if (B[0] < C[0]) {
                    sb.append("3 ").append(sumC);
                } else {
                    if (B[1] > C[1]) {
                        sb.append("2 ").append(sumB);
                    } else if (B[1] < C[1]) {
                        sb.append("3 ").append(sumC);
                    } else {
                        if (B[2] > C[2]) {
                            sb.append("2 ").append(sumB);
                        } else if (B[2] < C[2]) {
                            sb.append("3 ").append(sumC);
                        } else {
                            sb.append("0 ").append(sumB);
                        }
                    }
                }
            }
        } else {
            if (sumC > sumA) {
                sb.append("3 ").append(sumC);
            } else if (sumC < sumA) {
                sb.append("1 ").append(sumA);
            } else {
                if (C[0] > A[0]) {
                    sb.append("3 ").append(sumC);
                } else if (C[0] < A[0]) {
                    sb.append("1 ").append(sumA);
                } else {
                    if (C[1] > A[1]) {
                        sb.append("3 ").append(sumC);
                    } else if (C[1] < A[1]) {
                        sb.append("1 ").append(sumA);
                    } else {
                        if (C[2] > A[2]) {
                            sb.append("3 ").append(sumC);
                        } else if (C[2] < A[2]) {
                            sb.append("1 ").append(sumA);
                        } else {
                            sb.append("0 ").append(sumC);
                        }
                    }
                }
            }
        }



        System.out.println(sb.toString());



        // bw.write(sb.toString());
        // bw.flush();
        // bw.close();    
    }
}