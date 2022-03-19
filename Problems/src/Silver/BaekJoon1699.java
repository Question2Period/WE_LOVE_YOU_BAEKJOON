package Silver;
import java.io.*;
import java.util.*;
public class BaekJoon1699 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N+1]; //제곱수가 더해진 최소 횟수
		Arrays.fill(dp, Integer.MAX_VALUE);
		for(int i = 1; i*i<=N; i++)dp[i*i] = 1;
			
		for(int i = 2; i<=N; i++) {
			for(int j= 1; j*j<i; j++) {
				dp[i] = Math.min(dp[i],dp[i-j*j]+1);
			}
		}
		System.out.println(dp[N]);
	}

}
