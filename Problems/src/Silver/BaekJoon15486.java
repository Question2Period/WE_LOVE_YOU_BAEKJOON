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
		dp=new int[N+1];
		Arrays.fill(dp, -1);
		arr = new int[2][N];			
			for(int j= 0; j<N; j++) {
				st = new StringTokenizer(br.readLine());
				arr[0][j] = Integer.parseInt(st.nextToken());
				arr[1][j] = Integer.parseInt(st.nextToken());
			}		
		System.out.println(check(0));
	}
	
	public static int check(int day) {
		if(day>N) return -100000000;
		if(day==N)return 0;
		if(dp[day]!=-1)return dp[day];
		dp[day] = Math.max(check(day+arr[0][day])+arr[1][day],check(day+1));
		return dp[day];	
	}
}
