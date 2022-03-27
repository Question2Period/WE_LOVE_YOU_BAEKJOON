package Gold;
import java.io.*;
import java.util.*;
public class BaekJoon2589 {
	public static int[][] arr,distance;
	public static boolean[][] visit;
	public static int[] dx = {0,1,0,-1};
	public static int[] dy = {-1,0,1,0};
	public static int row,column,max;
	public static Queue<int[]> Q = new LinkedList<>();
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		row = Integer.parseInt(st.nextToken());
		column = Integer.parseInt(st.nextToken());
		arr = new int[row+1][column+1];
		for(int i = 1; i<=row; i++) {
			String str = br.readLine();
			for(int j = 1; j<=column; j++) {
				if(str.charAt(j-1)=='W')
				arr[i][j] = -1;
				else arr[i][j] = 1; //L
			}
		}
		for(int i = 1; i<=row; i++) 
			for(int j = 1; j<=column; j++) {
				if(arr[i][j]!=1)continue;
				visit = new boolean[row+1][column+1];
				distance = new int[row+1][column+1];
				bfs(i,j);
			}
		System.out.println(max);
	}
	
	public static void bfs(int x, int y) {
		Q.offer(new int[]{x,y});
		visit[x][y] =true;
		
		while(!Q.isEmpty()) {
			int nextx = Q.peek()[0];
			int nexty = Q.peek()[1];
			Q.poll();
			for(int i = 0; i<4; i++) {
				int ax = nextx+dx[i];
				int ay = nexty+dy[i];
				if(ax<1||ax>row||ay<1||ay>column)continue;
				if(arr[ax][ay]!=1)continue;
				if(visit[ax][ay])continue;
				visit[ax][ay] = true;
				distance[ax][ay] = distance[nextx][nexty]+1;
				max = Math.max(max, distance[ax][ay]);
				Q.offer(new int[] {ax,ay});
			}
		}
	}

}
