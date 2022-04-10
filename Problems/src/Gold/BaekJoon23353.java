package Gold;
import java.io.*;
import java.util.*;
public class BaekJoon23353 {

	static class Node{
		int x;
		int y;
		int dis;
		int dir;
		int crush;

		public Node(int x, int y, int dis, int dir, int crush) {
			this.x = x;
			this.y = y;
			this.dis = dis;
			this.dir = dir;
			this.crush = crush;
			
		}

	
	}

	public static int N,max;
	public static int[] dx = {-1,-1,0,1,1,1,0,-1};
	public static int[] dy = {0,1,1,1,0,-1,-1,-1};
	public static int[][] map;
	public static Node[][] dist;
	public static boolean[][] visit;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		dist = new Node[N][N];
		visit = new boolean[N][N];
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==1)dist[i][j]=new Node(i,j,1,-1,0);
				else if(map[i][j]==2)dist[i][j]=new Node(i,j,1,-1,1);
			}
		}
		bfs();
		System.out.println(1);
		System.out.println(max);
	}
	
	public static void bfs() {
		for(int i= 0; i<N; i++) {
			for(int j= 0; j<N; j++) {
				if(map[i][j]==0)continue;
				if(visit[i][j])continue;
				Queue<Node> Q= new LinkedList<>();
				Q.offer(dist[i][j]);
				while(!Q.isEmpty()) {
					int x = Q.peek().x;
					int y = Q.peek().y;
					int dis = Q.peek().dis;
					int dir = Q.peek().dir;
					int crush = Q.peek().crush;
					max = Math.max(dis, max);
					Q.poll();
					if(visit[x][y])continue;//방문했을 시 
					visit[x][y] =true;
					for(int k= 0; k<8; k++) {
						int nx = x+dx[k];
						int ny = y+dy[k];
						if(nx<0||nx>N-1||ny<0||ny>N-1)continue;//범위초과
						if(map[nx][ny]==0)continue;//빈공간
						
						if(map[nx][ny]==1) {//흑돌일 때
							if(dir==-1||(dir!=k&&dir!=(k+4%8))) {//방향이 다르거나 시초라면
								if(dist[nx][ny].dis<2) {//그 값이 2미만일때만 갱신
									dist[nx][ny] = new Node(nx,ny,2,k,crush);
									Q.offer(dist[nx][ny]);
								}
							}
							else {//같은 선 상의 방향이라면
								if(dist[nx][ny].dis<dist[x][y].dis+1) {
									//그 값이 현재+1미만일때만 갱신
									dist[nx][ny] = new Node(nx,ny,dist[x][y].dis+1,k,crush);
									Q.offer(dist[nx][ny]);
								}
							}
						}
						else {//흰돌일 때
							if(crush==1)continue;//이미 바꾼적 있다면 제외
							
							//이후 돌은 무조건 바꾼적 없는  흑돌
							if(dir==-1||(dir!=k&&dir!=(k+4%8))) {//방향이 다르거나 시초라면
								if(dist[nx][ny].dis<2) {//그 값이 2미만일때만 갱신
									dist[nx][ny] = new Node(nx,ny,2,k,1);
									Q.offer(dist[nx][ny]);
								}
							}
							else {//같은 선상의 방향이라면
								if(dist[nx][ny].dis<dist[x][y].dis+1) {
									//그 값이 현재+1미만일때만 갱신
									dist[nx][ny] = new Node(nx,ny,dist[x][y].dis+1,k,1);
									Q.offer(dist[nx][ny]);
								}
							}
							
						}
//						visit[nx][ny] = true;
					}
				}
			}
		}
	}
	

	
	

}
