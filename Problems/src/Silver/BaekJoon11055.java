package Silver;
import java.io.*;
import java.util.*;
public class BaekJoon11055 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		int[] dp = new int[N];
		for(int i = 0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());
		dp = Arrays.copyOf(arr,N);
		for(int i = 0; i<N; i++) {
			for(int j= 0; j<i; j++)
			if(arr[i]>arr[j])dp[i] = Math.max(dp[j]+arr[i], dp[i]);
		}
		Arrays.sort(dp);
		System.out.println(dp[N-1]);
	}

}
