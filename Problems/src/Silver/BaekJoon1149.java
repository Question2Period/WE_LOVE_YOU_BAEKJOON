package Silver;
import java.io.*;
import java.util.*;
public class BaekJoon1149 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[][] cost = new int[N+1][3];
		for(int i = 1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			cost[i][0] = Integer.parseInt(st.nextToken());//빨강
			cost[i][1] = Integer.parseInt(st.nextToken());//초록
			cost[i][2] = Integer.parseInt(st.nextToken());//파랑
		}
		for(int i = 2; i<=N; i++) {
			cost[i][0]+=Math.min(cost[i-1][1],cost[i-1][2] );
			cost[i][1]+=Math.min(cost[i-1][0],cost[i-1][2] );
			cost[i][2]+=Math.min(cost[i-1][0],cost[i-1][1] );
		}
		System.out.println(Math.min(Math.min(cost[N][0], cost[N][1]), cost[N][2]));
		
	}

}
