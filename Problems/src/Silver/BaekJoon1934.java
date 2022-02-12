package Silver;
import java.io.*;
import java.util.*;
public class BaekJoon1934 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int max;
		StringTokenizer st;
		for(int i = 0; i<T; i++) {
			max = 0;
			st= new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			for(int j = 2; j<=Math.min(A, B); j++) {
				if(A%j==0 && B%j==0) {
					max = j;
				}
			}

			if(max==0)
			{
				System.out.println(A*B);
			}
			else {
				System.out.println(A*B/max);
			}
		}
	}

}
