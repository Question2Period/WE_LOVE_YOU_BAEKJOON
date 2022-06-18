package Bronze;
import java.io.*;
import java.util.*;
public class BaekJoon1712 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int x = C-B;
		if(x<=0)System.out.println(-1);
		else System.out.println(A/x+1);
	}

}
