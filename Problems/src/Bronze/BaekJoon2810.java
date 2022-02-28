package Bronze;
import java.io.*;
import java.util.*;
public class BaekJoon2810 {
	public static int countL,countS;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		for(int i = 0; i<N; i++) {
			char index = str.charAt(i);
			if(index=='L')countL++;
			else if(index=='S')countS++;
		}
		int holder= countL/2+countS+1;
		if(holder>N)System.out.println(N);
		else System.out.println(holder);
	}

}
