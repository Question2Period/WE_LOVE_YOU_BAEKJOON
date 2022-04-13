package Gold;
import java.io.*;
import java.util.*;
public class BaekJoon1261 {
	
	static class Node implements Comparable<Node>{
		int x;
		int y;
		int dist;
		
		public Node(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.dist - o.dist;
		}
	}
	public static int[] dx = {-1,0,1,0};
	public static int[] dy = {0,1,0,-1};
	public static int N,M,min;
	public static int[][] map,dis;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N+1][M+1];
		dis = new int[N+1][M+1];
		for(int i =1; i<=N; i++) {
			String str = br.readLine();
			for(int j = 1; j<=M; j++) {
				map[i][j] = str.charAt(j-1)-'0';
				dis[i][j] = Integer.MAX_VALUE;
			}
		}
		dijstra();
		System.out.println(dis[N][M]);
	}
	
	
	public static void dijstra() {
		Queue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(1,1,0));
		dis[1][1] = 0;
		while(!pq.isEmpty()) {
			int x = pq.peek().x;
			int y = pq.peek().y;
			int d = pq.peek().dist;
			pq.poll();
			if(d!=dis[x][y])continue;
			for(int i = 0; i<4; i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				if(nx<1||nx>N||ny<1||ny>M)continue;
				if(dis[nx][ny]<=dis[x][y]+map[nx][ny])continue;
				dis[nx][ny] = dis[x][y] + map[nx][ny];
				pq.offer(new Node(nx,ny,dis[nx][ny]));
			}
		}
	}

}
