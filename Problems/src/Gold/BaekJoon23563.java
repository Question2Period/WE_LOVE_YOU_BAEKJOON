package Gold;
import java.io.*;
import java.util.*;
public class BaekJoon23563 {
	
	static class Node implements Comparable<Node>{
		int row;//행
		int column;//열
		int distance;//거리
		boolean wall;//벽에 인접한 칸이면 true
		public Node(int row,int column,int distance,boolean wall) {
			this.row = row;
			this.column = column;
			this.distance = distance;
			this.wall = wall;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.distance-o.distance;
		}
		
	}
	
	public static int H,W,min,startx,starty,endx,endy;
	public static int[][] map;
	public static int[][] distance;
	public static int[] dx = {-1,0,1,0};
	public static int[] dy = {0,1,0,-1};
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());//행 
		W = Integer.parseInt(st.nextToken());//열
		map = new int[H][W];
		distance = new int[H][W];
		for(int i = 0; i<H; i++) {
			String str = br.readLine();
			for(int j = 0; j<W; j++) {
				char a = str.charAt(j);
				if(a=='#')map[i][j]=-100;//벽
				else if(a=='S') {
					map[i][j] = 1;
					startx = i;
					starty = j;
				}
				else if(a=='E') {
					map[i][j]=1;//도착
					endx = i;
					endy = j;
				}
				else map[i][j]=1;//비용
			}
		}
		for(int i = 0;i<H; i++)
			for(int j= 0; j<W; j++)distance[i][j] = Integer.MAX_VALUE;
		distance[startx][starty]=0;
		dijstra(endx,endy,nearwall(startx,starty));
		System.out.println(distance[endx][endy]);
	}
	
	
	public static void dijstra(int a, int b,boolean c) {
		Queue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(startx,starty,0,c));
		while(!pq.isEmpty()) {
			int currentx = pq.peek().row;
			int currenty = pq.peek().column;
			int currentdist = pq.peek().distance;
			boolean currentw = pq.peek().wall;
			pq.poll();
//			if(distance[a][b]!=Integer.MAX_VALUE)return;
			if(currentdist!=distance[currentx][currenty])continue;
			for(int i = 0; i<4; i++) {
				int nx = currentx+dx[i];
				int ny = currenty+dy[i];
				if(nx<0||nx>H||ny<0||ny>W)continue;//범위 넘어가면 패스
				if(map[nx][ny]==-100)continue;//벽이면 패스
				boolean wall = nearwall(nx,ny);//벽인접칸인지 체크
				if(currentw&&wall) {
					if(distance[nx][ny]<=distance[currentx][currenty])continue;
					distance[nx][ny]=distance[currentx][currenty];
				}
				else {
					if(distance[nx][ny]<=distance[currentx][currenty]+map[nx][ny])
						continue;
						int checkd = distance[currentx][currenty];
						int checkm = map[nx][ny];
						distance[nx][ny]=distance[currentx][currenty]+map[nx][ny];
				}
				pq.offer(new Node(nx,ny,distance[nx][ny],wall));
			}
		}
	}
	
	public static boolean nearwall(int x,int y) {//벽에 인접한 칸인지 검사
		for(int i = 0; i<4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(nx<0||nx>H||ny<0||ny>W)continue;
			if(map[nx][ny]==-100) {
				return true;
			}
		}
		return false;
	}
	
	
	
	
	

}
