package Silver;
import java.io.*;
import java.util.*;
public class BaekJoon2941 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int cnt = 0;
		for(int i= 0; i<str.length(); i++) {
			int index = str.charAt(i);
			if(index=='d') {
				if(i!=str.length()-1&&str.charAt(i+1)=='z') i++;				
			}
			i++;
			cnt++;			
		}
		System.out.println(cnt);
	}

}
