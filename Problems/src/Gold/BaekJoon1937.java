package Gold;
import java.io.*;
import java.util.*;
public class BaekJoon1937 { //dfs+dp이다. bfs로 풀라하지말고 dfs+dp로 푸는것이 훨씬 편하다.


	public static int[][]map,dist;
	public static int[] dx = {-1,0,1,0};
	public static int[] dy = {0,1,0,-1};
	public static int n,max;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		dist = new int[n][n];
		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j= 0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i = 0; i<n; i++) {
			for(int j= 0; j<n; j++) {
				max = Math.max(max, dfs(i,j));
			}
		}
		System.out.println(max);
	}

	public static int dfs(int x, int y) {
		if(dist[x][y]==0) {
			dist[x][y]=1;
			for(int i = 0; i<4; i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				if(nx<0||nx>n-1||ny<0||ny>n-1)continue;
				if(map[nx][ny]<=map[x][y])continue;
				dist[x][y] = Math.max(dist[x][y], dfs(nx,ny)+1);
			}
		}


		return dist[x][y];
	}


}
