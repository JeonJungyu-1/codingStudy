package baejoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ1152 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strArr = br.readLine().trim().split(" ");
        int strArrLength = strArr[0].equals("") ? 0 : strArr.length;
        System.out.println(strArrLength);
    }
}
