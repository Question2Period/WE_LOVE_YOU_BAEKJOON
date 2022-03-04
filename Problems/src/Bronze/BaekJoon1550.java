package Bronze;
import java.io.*;
public class BaekJoon1550 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int sum = 0;
		int index = 0;
		for(int i = 0; i<str.length(); i++) {
			int x = (int)Math.pow(16, str.length()-i-1);
			int y = str.charAt(i);
			switch (y) {
			case 'A':
			case 'B':
			case 'C':
			case 'D':
			case 'E':
			case 'F':
				index=y-'A'+10;
				break;

			default:
				index=y-'0';
				break;
			}
			sum+= (x*index);
		}
		System.out.println(sum);
	}

}
