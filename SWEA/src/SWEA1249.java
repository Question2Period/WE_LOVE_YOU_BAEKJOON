import java.io.*;
import java.util.*;
public class SWEA1249 {

	static class Node implements Comparable<Node>{
		int x;
		int y;
		int cost;
		public Node(int x,int y,int cost) {
			this.x = x;
			this.y = y;
			this.cost = cost;
		}
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.cost-o.cost;
		}
		
	}
	
	static int N;
	static int[][] map;
	static int[][] distance;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N+1][N+1];
			distance = new int[N+1][N+1];
			for(int i = 1; i<=N; i++) {
				String str = br.readLine();
				for(int j = 1; j<=N; j++) {
					map[i][j] = str.charAt(j-1)-'0';
					distance[i][j] = Integer.MAX_VALUE;
				}
			}
			distance[1][1] = map[1][1];
			diijstra(1,1);
			sb.append("#"+t+" "+distance[N][N]+"\n");
		}
		System.out.println(sb);
	}
	
	public static void diijstra(int x, int y) {
		Queue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(x,y,distance[x][y]));
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			int ax = now.x;
			int ay = now.y;
			int cost = now.cost;
			if(cost!=distance[ax][ay])continue;
			for(int i = 0; i<4; i++) {
				int nx = ax+dx[i];
				int ny = ay+dy[i];
				if(nx<1||nx>N||ny<1||ny>N)continue;
				if(distance[nx][ny]<=distance[ax][ay]+map[nx][ny])continue;
				distance[nx][ny] = distance[ax][ay]+map[nx][ny];
				pq.add(new Node(nx,ny,distance[nx][ny]));
			}
		}
	}

}
