package Silver;
import java.io.*;
import java.util.*;
public class BaekJoon17626 {
	public static int[] dp;
	public static int n;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		dp = new int[n+1];
		Arrays.fill(dp, -1);
        int[] dp = new int[n+1];
        dp[1] = 1;
 
        int min = 0;
        for (int i = 2; i <= n; i++) {
            min = Integer.MAX_VALUE;
            
            // i에서 i보다 작은 제곱수에서 뺀 dp[i - j * j] 중
            // 최소를 택한다.
            for (int j = 1; j * j <= i; j++) {
                int temp = i - j * j;
                min = Math.min(min, dp[temp]);
            }
 
            dp[i] = min + 1; // 그리고 1을 더해준다.
        }
		System.out.println(dp[n]);
	}
	

}