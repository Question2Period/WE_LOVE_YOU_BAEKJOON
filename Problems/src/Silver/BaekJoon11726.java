package Silver;
import java.io.*;
import java.util.*;
public class BaekJoon11726 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		long[] dp = new long[1010];
		dp[1] = 1;
		dp[2] = 2;
		for(int i = 3; i<1010; i++) dp[i] = (dp[i-1] + dp[i-2])%10007;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(dp[Integer.parseInt(br.readLine())]);
		
	}

}
