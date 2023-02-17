import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static String[] strArr = new String[] {"A", "B", "C", "D", "E", "F", "G", "H"};
	static String[] strCodeArr = new String[] { "000000", "001111", "010011", "011100", "100110", "101001", "110101", "111010"}; 
	static String str;
	static String output = "";

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		str = br.readLine();
		
		a:
		for (int i = 0; i < num; i++) {
			int strCheck = -5;
			int temp = -5;
			
			for (int j = 0; j < strArr.length; j++) {
				strCheck = strCheck(i, strArr[j], strCodeArr[j]);
				if (strCheck == -1) {
					continue a;
				}
				
				if (temp == -5){
					temp = strCheck;
				}
			}
				
			if (temp != -5) {
				System.out.println(i + 1);
				return;
			}
		}
			
		System.out.println(output);
	}
	
	static int strCheck(int index, String check, String checkStr) {
		int count = 0;
		index *= 6;
		for (int i = index; i < index + 6; i++) {
			if (str.charAt(i) != checkStr.charAt(i - index)) {
				count++;
			}
			
			if (count >= 2) {
				return index;
			} 
		}
		
		output += check;
		return -1;
		
		
	}
	
}