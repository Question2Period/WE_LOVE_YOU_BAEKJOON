package Bronze;
import java.io.*;
import java.util.*;
public class BaekJoon11365 {
	public static String str;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			str = br.readLine();
			if(str.equals("END"))break;
			StringBuilder sb = new StringBuilder();
			sb.append(str);
			System.out.println(sb.reverse());
		}
	}

}
