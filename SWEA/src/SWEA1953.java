import java.io.*;
import java.util.*;
public class SWEA1953 {
	public static int N,M,R,C,L,cnt;
	public static int[][] map;
	public static int[] dx = {-1,0,1,0};//상우하좌
	public static int[] dy = {0,1,0,-1};
	public static int[][]pipes = {{},{0,1,2,3},{0,2},{1,3},{0,1},{1,2},{2,3},{0,3}};
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t<=T; t++) {
			st= new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 행
			M = Integer.parseInt(st.nextToken()); // 열
			R = Integer.parseInt(st.nextToken()); // 시작 위치 행
			C = Integer.parseInt(st.nextToken()); // 시작 위치 열
			L = Integer.parseInt(st.nextToken());
			map  = new int[N+1][M+1];
			for(int i = 1; i<=N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j =1; j<=M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			cnt = 1;
			bfs(R+1,C+1);
			sb.append("#"+t+" "+cnt+"\n");
		}
		System.out.println(sb);
	}

	public static void bfs(int x, int y) {
		Queue<int[]> Q = new LinkedList<>();
		boolean[][] visit = new boolean[N+1][M+1];
		Q.offer(new int[] {x,y,map[x][y],0});
		visit[x][y] = true;
		while(!Q.isEmpty()) {
			int nowx = Q.peek()[0];
			int nowy = Q.peek()[1];
			int pipe = Q.peek()[2];
			int time = Q.peek()[3];
			if(time==L-1)break;
			Q.poll();
			int[] cur = pipes[pipe];
			for(int i =0; i<cur.length; i++) {
				int nx = nowx+dx[cur[i]];
				int ny = nowy+dy[cur[i]];
				if(nx<1||nx>N||ny<1||ny>M)continue;//범위 초과시 불가
				if(visit[nx][ny])continue;//이미 방문했을시 실패
				if(CheckPossiblity(nx,ny,pipe,cur[i]))continue; //다음 파이프랑 매칭안될시 실패
				 cnt++;
				 int newtime = time+1;
				 visit[nx][ny] = true;
				 Q.offer(new int[] {nx,ny,map[nx][ny],newtime});
				 
			}
		}
	}

	private static boolean CheckPossiblity(int nx, int ny, int pipe,int dir) {//다음 좌표들, 현재 파이프 종류, 방향
		// TODO Auto-generated method stub
		int npipe = map[nx][ny];
		boolean TF = false;
		if(npipe==0)TF=true;
		else {
			switch (pipe) {
			case 1:
				switch (dir) {
				case 0:
					if(npipe==3||npipe==4||npipe==7)TF = true;	
					break;
				case 1:
					if(npipe==2||npipe==4||npipe==5)TF = true;
					break;
				case 2:
					if(npipe==3||npipe==5||npipe==6)TF = true;	
					break;
				case 3:
					if(npipe==2||npipe==6||npipe==7)TF = true;
					break;
				}
				break;
			case 2:
				switch (dir) {
				case 0:
					if(npipe==3||npipe==4||npipe==7)TF = true;
					break;
				case 2:
					if(npipe==3||npipe==5||npipe==6)TF = true;	
					break;
				}
				break;
			case 3:
				switch (dir) {
				case 1:
					if(npipe==2||npipe==4||npipe==5)TF = true;
					break;
				case 3:
					if(npipe==2||npipe==6||npipe==7)TF = true;
					break;
				}
				break;
			case 4:
				switch (dir) {
				case 0:
					if(npipe==3||npipe==4||npipe==7)TF = true;
					break;

				case 1:
					if(npipe==2||npipe==4||npipe==5)TF = true;
					break;
				}
				break;
			case 5:
				switch (dir) {
				case 1:
					if(npipe==2||npipe==4||npipe==5)TF = true;
					break;
				case 2:
					if(npipe==3||npipe==5||npipe==6)TF = true;	
					break;
				}
				break;
			case 6:
				switch (dir) {
				case 2:
					if(npipe==3||npipe==5||npipe==6)TF = true;	
					break;
				case 3:
					if(npipe==2||npipe==6||npipe==7)TF = true;
					break;
				}
				break;
			case 7:
				switch (dir) {
				case 0:
					if(npipe==3||npipe==4||npipe==7)TF = true;
					break;
				case 3:
					if(npipe==2||npipe==6||npipe==7)TF = true;
					break;
				}
				break;
			}
		}
		return TF;
	}
}
