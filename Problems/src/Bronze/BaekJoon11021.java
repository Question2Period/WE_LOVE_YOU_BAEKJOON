package Bronze;
import java.io.*;
import java.util.*;
public class BaekJoon11021 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i = 0; i<T; i++) {
			st= new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			System.out.println("Case #"+(i+1)+": "+(a+b));
		}
	}

}
