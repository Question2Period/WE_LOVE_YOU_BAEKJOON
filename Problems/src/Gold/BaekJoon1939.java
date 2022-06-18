package Gold;
import java.io.*;
import java.util.*;
public class BaekJoon1939 {
	public static int A,B,C;
	public static int[][] parent;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		parent = new int[n+1][2];//첫 열은 조상, 두번째열은 최소가중치
		for(int i = 1; i<=n; i++)parent[i][0] = i;
		for(int i = 0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			union(A,B,C);
		}
		st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
	}

	public static void union(int x, int y, int cost) {
		
	}
	
}
