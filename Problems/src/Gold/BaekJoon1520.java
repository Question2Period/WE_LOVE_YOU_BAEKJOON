package Gold;
import java.io.*;
import java.util.*;
public class BaekJoon1520 {
	public static int[][] count;
	public static int[] dx = {-1,0,1,0};//상우하좌
	public static int[] dy = {0,1,0,-1};
	public static int[][] map;//원본 배열
	public static int cnt,m,n;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
			cnt = 0;//경로 가짓수
			st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());//행
			n = Integer.parseInt(st.nextToken());//열
			map = new int[m+1][n+1];
			for(int i = 1; i<=m; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j= 1; j<=n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			count = new int[m+1][n+1]; // 경로 가짓수 저장 배열
			count[1][1] = 1;
			bfs();
			System.out.println(count[m][n]);
			
	}
	
	public static void bfs() {
		Queue<int[]> Q = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return map[o2[0]][o2[1]]-map[o1[0]][o1[1]];
			}});
		Q.offer(new int[] {1,1});//현재 x,y,분기x,y,방향은 최초일때 4
		
		while(!Q.isEmpty()) {
			int x = Q.peek()[0];
			int y = Q.peek()[1];
			Q.poll();
			int time = 0;
			for(int i= 0; i<4; i++) {//4방향 탐색
				int nx = x+dx[i];
				int ny = y+dy[i];
				if(nx<1||nx>m||ny<1||ny>n)continue;// 범위 벗어남
				if(map[nx][ny]>=map[x][y])continue;//내리막길이 아님
				if(count[nx][ny]==0)Q.offer(new int[] {nx,ny});//다음 지점 좌표만 갱신
				count[nx][ny] +=count[x][y];
			}
		}
	}

}
