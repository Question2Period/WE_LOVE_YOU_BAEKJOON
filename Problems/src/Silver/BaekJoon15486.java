package Silver;
import java.io.*;
import java.util.*;
public class BaekJoon15486 {
	public static int N;
	public static int[] dp;
	public static int[][] arr;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		dp=new int[1500001];
		dp[0] = 0;
		arr = new int[2][N+1];			
			for(int j= 1; j<=N; j++) {
				st = new StringTokenizer(br.readLine());
				arr[0][j] = Integer.parseInt(st.nextToken()); //상담걸리는 기간
				arr[1][j] = Integer.parseInt(st.nextToken()); //완료시 지급 금액
			}		
//		System.out.println(check(0));
		for(int i = N; i<=1; i--) {
			dp[i] = Math.max(dp[i-arr[0][i]]-arr[1][i], dp[i]);
		}
		System.out.println(dp[N]);
	}
	
//	public static int check(int day) {
//		if(day>N) return -100000000;
//		if(day==N)return 0;
//		if(dp[day]!=-1)return dp[day];
//		dp[day] = Math.max(check(day+arr[0][day])+arr[1][day],check(day+1)); //상담했을 때와 안했을 때의 최대값이 dp
//		return dp[day];	
//	}
}
