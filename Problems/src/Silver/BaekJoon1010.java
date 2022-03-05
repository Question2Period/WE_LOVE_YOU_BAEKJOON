package Silver;
import java.io.*;
import java.util.*;

public class BaekJoon1010 {
	public static int N,M,sum,di;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t<T; t++) {
			st = new StringTokenizer(br.readLine());
			sum=1;
			di=1;
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			if(N>M/2) {
				if(N==M) {sb.append(1).append("\n");
				continue;
				}
				N=M-N;
			}
			
			for(int i = M; i>M-N; i--) {
				sum*=i;
				di*=(M+1-i);
				if(sum%di==0) {
					sum/=di;
					di=1;
				}
			}
			sb.append(sum).append("\n");
		}
		System.out.println(sb);
	}

}
