package Silver;
import java.io.*;
import java.util.*;
public class BaekJoon1912 {
	public static int[] arr;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		arr = new int[n];
		int[] dp = new int[100100];
		Arrays.fill(dp, Integer.MIN_VALUE);
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<n; i++)arr[i] = Integer.parseInt(st.nextToken());
		dp[0] = arr[0];
		for(int i= 1; i<n; i++) {
			dp[i] = Math.max(dp[i-1]+arr[i], arr[i]);
		}
		Arrays.sort(dp);
		System.out.println(dp[100099]);
	}

}
