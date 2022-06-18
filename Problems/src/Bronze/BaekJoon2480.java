package Bronze;
import java.io.*;
import java.util.*;
public class BaekJoon2480 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		if(A==B&& B==C)sb.append(10000+A*1000);
		else if(A!=B&&A!=C&&B!=C)sb.append(Math.max(Math.max(A, B), C)*100);
		else {
			if(A==B)sb.append(1000+100*A);
			else sb.append(1000+100*C);		
		}
		System.out.println(sb);
	}

}
