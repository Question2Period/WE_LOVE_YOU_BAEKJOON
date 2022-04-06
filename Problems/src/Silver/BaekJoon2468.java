package Silver;
import java.io.*;
import java.util.*;
public class BaekJoon2468 {
	public static int[] dx = {-1,0,1,0};
	public static int[] dy = {0,1,0,-1};
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int max = 0;
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N+1][N+1];
		boolean[][] visit; 
		for(int i = 1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j<=N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(map[i][j], max);
			}
		}
		int area = 0;
		for(int t= 0; t<=max; t++) {
			Queue<int[]> Q = new LinkedList<>();
			visit = new boolean[N+1][N+1];
			int cnt = 0; //영역 개수
			for(int i = 1; i<=N; i++) {
				for(int j =1; j<=N; j++) {
					if(map[i][j]<=t)continue;
					if(visit[i][j])continue;
					cnt++;
					Q.offer(new int[] {i,j});
					visit[i][j] = true;
					while(!Q.isEmpty()) {
						int x = Q.peek()[0];
						int y = Q.peek()[1];
						Q.poll();
						for(int k = 0; k<4; k++) {
							int nx = x+dx[k];
							int ny = y+dy[k];
							if(nx<1||nx>N||ny<1||ny>N)continue;
							if(visit[nx][ny])continue;
							if(map[nx][ny]<=t)continue;
							visit[nx][ny] = true;
							Q.offer(new int[] {nx,ny});
						}
					}
				}
			}
			area = Math.max(area, cnt);
		}
		System.out.println(area);
	}


}
