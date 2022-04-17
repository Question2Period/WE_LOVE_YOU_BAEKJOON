package Gold;
import java.io.*;
import java.util.*;
public class BaekJoon1726 {

	static class robot implements Comparable<robot>{
		int x;
		int y;
		int dir;
		int cnt;
		public robot(int x,int y,int dir,int cnt) {
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.cnt = cnt;
		}
		
		public int compareTo(robot o) {
			return this.cnt-o.cnt;
		}
	}
	public static int[] dx = {0,0,0,1,-1};
	public static int[] dy = {0,1,-1,0,0}; // 동서남북
	public static int M,N,ex,ey,edir;
	public static int[][] map;
	public static robot[][] move;
	public static Queue<robot> Q;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[M+1][N+1];
		move = new robot[M+1][N+1];
		for(int i = 1; i<=M; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j= 1; j<=N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		int sx = Integer.parseInt(st.nextToken());
		int sy = Integer.parseInt(st.nextToken());
		int sdir = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		ex = Integer.parseInt(st.nextToken());
		ey = Integer.parseInt(st.nextToken());
		edir = Integer.parseInt(st.nextToken());
		Q = new PriorityQueue<>();
		Q.offer(new robot(sx,sy,sdir,0));
		move[sx][sy] = new robot(sx,sy,sdir,0);
		bfs();
		System.out.println(move[ex][ey].cnt);
	}

	public static void bfs() {
		while(!Q.isEmpty()) {
			int x = Q.peek().x;
			int y = Q.peek().y;
			int dir = Q.peek().dir;
			int cnt = Q.peek().cnt;
			Q.poll();
			if(cnt!=move[x][y].cnt)continue;
			if(x==ex&&y==ey) {
				if(dir==edir)continue;//이미 방향 도달
				else {//방향만 다르다?
					int plus = leastmove(dir,edir);
					if(move[x][y].cnt>cnt+plus) {
						move[x][y].cnt=cnt+plus;
						continue;
					}
				}
			}
			for(int i =1; i<=4; i++) {
				for(int j = 1; j<=3; j++) {
					int nx = x+j*dx[i];
					int ny = y+j*dy[i];
					if(nx<1||nx>M||ny<1||ny>N)break;//범위 벗어나면 제외
					if(map[nx][ny]==1)break;//0이면 못가는곳이므로 제외
					int a = leastmove(dir,i)+1;
					if(checknull(nx,ny)) {//아직 아무도 도달하지 않았을 때
						move[nx][ny] = new robot(nx,ny,i,cnt+a);
						Q.offer(new robot(nx,ny,i,cnt+a));
					}
					else {//이미 도달한 경우 cnt비교	
						if(move[nx][ny].cnt>cnt+a) {//더 적은횟수로 도달가능하다면
							move[nx][ny].dir=i;
							move[nx][ny].cnt=cnt+a;
							Q.offer(new robot(nx,ny,i,cnt+a));
						}
					}
					
				}
			}
		}
	}

	public static int leastmove(int dir,int now) {
		if(Math.abs(dir-now)==1)return 2;
		else return 1;
	}

	public static boolean checknull(int x,int y) {
		if(move[x][y]==null)return true;
		else return false;
	}
	 

}
