package Gold;
import java.io.*;
import java.util.*;
public class BaekJoon4485 {
	
	static class Node implements Comparable<Node>{
		int x;
		int y;
		int cost;
		
		public Node(int x,int y, int cost) {
			super();
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
	static int[][] map,distance;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int cnt = 1;
		while(true) {
			N = Integer.parseInt(br.readLine());
			if(N==0)break;
			map = new int[N+1][N+1];
			distance = new int[N+1][N+1];
			for(int i = 1; i<=N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 1; j<=N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					distance[i][j] = Integer.MAX_VALUE;
					
				}
			}
			
			sb.append("Problem " + (cnt++)+": "+dajkstra()+"\n");
		}
		System.out.println(sb);
	}
	
	public static int dajkstra() {
		distance[1][1] = map[1][1];
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		pq.offer(new Node(1,1,distance[1][1]));
		
		while(!pq.isEmpty()) {
			Node pre = pq.poll();
			if(distance[pre.x][pre.y]!=pre.cost)continue;
			for(int i = 0; i<4; i++) {
				int x = pre.x+dx[i];
				int y = pre.y+dy[i];
				if(x<1||x>N||y<1||y>N)continue;
				if(distance[pre.x][pre.y]+map[x][y]>=distance[x][y])continue;
				distance[x][y] = distance[pre.x][pre.y]+map[x][y];
				pq.add(new Node(x,y,distance[x][y]));
			}
		}
		
		
		return distance[N][N];
	}

}
