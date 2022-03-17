package Silver;
import java.io.*;
import java.util.*;
public class BaekJoon9095 {
	public static int n;
	public static long[] dp;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t<T; t++) {
			dp = new long[1000001];
			Arrays.fill(dp, -1);
		n = Integer.parseInt(br.readLine());
		System.out.println(recur(n));
		}
	}

	public static long recur(int sum) {
		int time = 0;
		if(sum<0)return 0;
		if(sum==0) return 1;
		if(dp[sum]!=-1)return dp[sum];
		for(int i = 1; i<=3; i++)time += (recur(sum-i));
		dp[sum]=time;
		return dp[sum];
	}
	
}
