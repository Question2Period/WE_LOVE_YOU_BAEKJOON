package Bronze;
import java.io.*;
import java.util.*;
public class BaekJoon5596 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int a = 0;
		int b = 0;
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<4; i++) {
		a+= Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int j =0; j<4; j++) {
			b+= Integer.parseInt(st.nextToken());
		}
		System.out.println(Math.max(a,b));
	}

}
