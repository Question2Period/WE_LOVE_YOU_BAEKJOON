package Gold;
import java.io.*;
import java.util.*;
public class BaekJoon2133 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[31];
		dp[0] = 1;
		dp[2] = 3;
		for(int i = 4; i<=N; i+=2) {
			dp[i] += (dp[i-2]*dp[2]);
			for(int j = i-4; j>=0; j-=2) {
				dp[i]+=(dp[j]*2);
			}
		}
		System.out.println(dp[N]);
	}

}
