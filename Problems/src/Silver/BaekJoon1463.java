package Silver;
import java.io.*;
import java.util.*;
public class BaekJoon1463 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N+1];
		dp[1] = 0;
		if(N>1) {
			for(int i = 2; i<=N; i++) {
				if(i%3==0) {
					if(i%2==0)dp[i] = Math.min(dp[i/3]+1, dp[i/2]+1); //6의 배수
					else dp[i] = dp[i/3]+1;
				}
				else if(i%2==0) {
					dp[i] = dp[i/2]+1;
				}
				if(dp[i]!=0)	dp[i] = Math.min(dp[i],dp[i-1]+1);
				else dp[i] = dp[i-1]+1;
				
			}
		}
		System.out.println(dp[N]);
	}

}
