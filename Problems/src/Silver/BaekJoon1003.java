package Silver;
import java.io.*;
import java.util.*;
public class BaekJoon1003 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int[] dp0 = new int[41];
		int[] dp1 = new int[41];
		dp0[0] = 1;
		dp0[1] = 0;
		dp1[0] = 0;
		dp1[1] = 1;
		for(int i = 2; i<=40; i++) {
			dp0[i] = dp0[i-2] + dp0[i-1];
			dp1[i] = dp1[i-2] + dp1[i-1];
		}
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t<T; t++) {
			int input = Integer.parseInt(br.readLine());
			sb.append(dp0[input]+" "+dp1[input]).append("\n");
		}
		System.out.println(sb);
	}

}
