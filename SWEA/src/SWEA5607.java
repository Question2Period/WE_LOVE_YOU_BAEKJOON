import java.io.*;
import java.util.*;
public class SWEA5607 {
	public static int N,R;
	public static long ans,temp;
	public static final int Mod = 1234567891;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		long[] factorial = new long[1000001];
		factorial[1] = 1;
		for(int i =2; i<=1000000; i++)factorial[i] = (factorial[i-1]*i)%Mod;
		for(int t = 1; t<=T; t++) {
			ans = 0;
			temp = 0;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			long a= factorial[R]%Mod;
			long b= factorial[N-R]%Mod;
			long x = a*b;
			
			ans = ferma(x,Mod-2);
			ans = (factorial[N]*ans)%Mod;
			sb.append("#"+t+" "+ans);
		}
		System.out.println(sb);
	}

	
	public static long ferma(long a, int b) {
		if (b == 0) return 1;
        long tmp = ferma(a, b / 2);
        long ret = (tmp * tmp) % Mod;
        if (b % 2 == 0) return ret;
        else return (ret * a) % Mod;
	}
}
