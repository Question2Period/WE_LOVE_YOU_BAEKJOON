package Gold;
import java.io.*;
import java.util.*;
public class BaekJoon14502 { //눈물나는 삼성 코테 유형 첫 솔
	public static int N,M,safe,max;
	public static int[][] map;
	public static int[][] newmap;
	public static boolean[][] visit;
	public static int[] dx = {0,-1,0,1,0};
	public static int[] dy = {0,0,1,0,-1};
	public static Queue<int[]> Q;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());//행
		M = Integer.parseInt(st.nextToken());//열
		map = new int[N+1][M+1];
		
		for(int i =1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1;j<=M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0);
		System.out.println(max);
	}
	
	public static void dfs(int cnt) {
		if(cnt==3) {// 벽 3개 설치시 bfs 시행
			max = Math.max(max,bfs());
			return;
		}
		for(int i = 1; i<=N; i++) {
			for(int j= 1; j<=M; j++) {
			if(map[i][j]!=0)continue;//벽, 바이러스가 존재시 벽 못세움
			map[i][j] = 1;
			dfs(cnt+1);
			map[i][j] = 0;
			}
		}
		
	}
	
	public static int bfs() {
		safe = 0;
		Q = new LinkedList<>();
		copyMap();
		while(!Q.isEmpty()) {
			int a = Q.peek()[0];
			int b = Q.peek()[1];
			Q.poll();
			for(int i = 1; i<5; i++) {
				int ax = a+dx[i];
				int ay = b+dy[i];
				if(ax<1||ax>N||ay<1||ay>M)continue;
				if(newmap[ax][ay]!=0)continue;
				newmap[ax][ay] = 2;
				safe--;
				Q.offer(new int[] {ax,ay});
			}
		}
		return safe;
	}

	public static void copyMap() {
		newmap = new int[N+1][M+1];
		for(int i = 1; i<=N; i++) {
			for(int j = 1; j<=M; j++) {
				newmap[i][j] = map[i][j];
				if(newmap[i][j]==0) safe++;
				if(newmap[i][j]==2) Q.offer(new int[] {i,j});
			}
		}
	}
	
	
}
