package Bronze;
import java.io.*;
import java.util.*;
public class BaekJoon11022 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		for(int i = 1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = x+y;
			sb.append("Case #"+i+": "+ x+" + "+y+" = "+z).append("\n");
		}
		System.out.println(sb);
	}

}
