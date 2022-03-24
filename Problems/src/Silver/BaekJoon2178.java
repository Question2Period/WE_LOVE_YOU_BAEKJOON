package Silver;
import java.io.*;
import java.util.*;
public class BaekJoon2178 {
	public static int cnt;
	public static int[][] arr;
	public static int[] dx = {-1,0,1,0};
	public static int[] dy = {0,1,0,-1};
	public static boolean[][] visit;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		arr = new int[N+1][M+1];
		visit = new boolean[N+1][M+1];
		for(int i = 1; i<=N; i++) {
			String str = br.readLine();
			for(int j= 1; j<=M; j++) {
				arr[i][j] = str.charAt(j-1)-'0';
			}
		}
		Queue<int[]> Q = new LinkedList<>();
		Q.offer(new int[] {1,1});
		visit[1][1] = true;
		while(!Q.isEmpty()) {
			int x = Q.peek()[0];
			int y = Q.peek()[1];
			Q.poll();
			for(int i =0; i<4; i++) {
				int ax = x+dx[i];
				int ay = y+dy[i];
				if(ax<1||ax>N||ay<1||ay>M)continue;
				if(visit[ax][ay])continue;
				if(arr[ax][ay]!=1)continue;
				visit[ax][ay] = true;
				arr[ax][ay] = arr[x][y]+1;
				Q.offer(new int[] {ax,ay});
			}
		}
		System.out.println(arr[N][M]);
	}

}
