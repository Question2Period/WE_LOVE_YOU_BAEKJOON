import java.io.*;
import java.util.*;
public class BaekJoon1259 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		while(true) {
			int count = 0;
			str=br.readLine();
			if(str.equals("0")) {
				count++;
				break;
			}
			for(int i =0; i<str.length()/2; i++) {
				if((str.charAt(i))!=(str.charAt(str.length()-i-1))) {
					count++;
					break;
				}
			}

			if(count==0) {
				System.out.println("yes");
			}
			else {
				System.out.println("no");
			}
		}
	}
}
