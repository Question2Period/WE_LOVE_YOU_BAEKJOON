import java.io.*;
import java.util.*;
public class BaekJoon11720 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int input = Integer.parseInt(br.readLine());
		String str = br.readLine();
		int Sum=0;
		for(int i=0;i<input;i++) {
			Sum+=str.charAt(i)-'0';
		}
		System.out.println(Sum);
	}
}
