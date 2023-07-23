import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

// 물건 팔기

public class Main {
    
    static StringBuilder sb;

    static class Product implements Comparable<Product> {
        int price, delivery;

        public Product(int price, int delivery) {
            this.price = price;
            this.delivery = delivery;
        }

        @Override
        public int compareTo(Product o) {
            int comparePrice = Integer.compare(this.price, o.price);
            return comparePrice == 0 ? Integer.compare(this.delivery, o.delivery) : comparePrice;
        }
        
        

    }
    public static void main(String[] args) throws IOException {
        solve();
    }

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        List<Product> list = new ArrayList<>();
        Set<Integer> set = new TreeSet<>();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int price = Integer.parseInt(st.nextToken());
            int delivery = Integer.parseInt(st.nextToken());
            list.add(new Product(price, delivery));
            set.add(price);
        }

        Collections.sort(list);

        int max = 0;
        int result = 0;
   
        for (int price : set) {
            int sum = 0;
            for (int j = 0; j < list.size(); j++) {
                if (price > list.get(j).price) continue;
                if (price - list.get(j).delivery > 0) {
                    sum += (price - list.get(j).delivery);
                }

            }

            if (sum > max) {
                max = sum;
                result = price;
            }
        }

        System.out.println(result);


    }
}