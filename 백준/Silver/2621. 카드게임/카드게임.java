import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

// 카드겡미

public class Main {
    
    static StringBuilder sb;
    static class Card implements Comparable<Card> {
        String color;
        int number;
        public Card(String color, int number) {
            this.color = color;
            this.number = number;
        }
        @Override
        public int compareTo(Card o) {
            int compareNumber = Integer.compare(this.number, o.number);
            return compareNumber != 0 ? compareNumber : this.color.compareTo(o.color);
        }

    }
    public static void main(String[] args) throws IOException {
        solve();
    }
    


    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        List<Card> list = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new Card(st.nextToken(), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(list);

        boolean isSameColor = getIsSameColor(list);
        boolean isContinuous = getIsContinuous(list);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            map.put(list.get(i).number, map.getOrDefault(list.get(i).number, 0) + 1);
        }
        int score = 0;

         if (isSameColor && isContinuous) {
            score = 900 + list.get(4).number;
        } else {
            int[] cnt = new int[16];
            for (int key : map.keySet()) {
                if (cnt[map.get(key)] == 0) {
                    cnt[map.get(key)] = key;
                } else {
                    cnt[map.get(key) + 10] = key;
                }
            }
            if (cnt[4] != 0) {
                score = 800 + cnt[4];
            } else if (cnt[3] != 0 && cnt[2] != 0) {
                score = 700 + cnt[2] + cnt[3] * 10;
            } else if (isSameColor) {
                score = 600 + list.get(4).number;
            } else if (isContinuous) {
                score = 500 + list.get(4).number;
            } else if (cnt[3] != 0) {
                score = 400 + cnt[3];
            } else if (cnt[2] != 0 && (cnt[12] != 0 || cnt[3] != 0)) {
                score = 300 + Math.min(cnt[2], cnt[12]) + Math.max(cnt[2], cnt[12]) * 10;
            } else if (cnt[2] != 0 || cnt[3] != 0) {
                score = 200 + cnt[2];
            } else {
                score = 100 + list.get(4).number;
            }

        }

        System.out.println(score);

    }



    private static boolean getIsContinuous(List<Card> list) {
        int number = list.get(0).number + 1;
        for (int i = 1; i < 5; i++) {
            if (number != list.get(i).number) return false;
            number++;
        }
        return true;
    }



    private static boolean getIsSameColor(List<Card> list) {
        String color = list.get(0).color;
        for (int i = 1; i < 5; i++) {
            if (!list.get(i).color.equals(color)) return false;
        }
        return true;
    }
}