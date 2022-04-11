package Gold;
import java.io.*;
import java.util.*;
public class BaekJoon1941 {
	public static int[][] map;
	public static int[] gongju;
	public static boolean[][] visit;
	public static int[] dx = {-1,0,1,0};
	public static int[] dy = {0,1,0,-1};
	public static int answer,end,flag,startx,starty;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[5][5];
		visit = new boolean[5][5];
		gongju = new int[7];
		for(int i= 0; i<5; i++) {
			String str = br.readLine();
			for(int j= 0; j<5; j++) {
				int a = str.charAt(j);
				if(a=='Y')map[i][j] = 0; //임도연파
				else map[i][j] = 1; // 다솜파
			}
		}	
		princess(0,0,1);
		System.out.println(answer);
	}
	
	public static void princess(int cur,int dasom,int start) {//고르기
		if(cur==7) {
			if(dasom<4)return;//다솜파가 4미만이면 패스
			int conn = bfs();
			if(conn!=7)return;//연결 다 안되어있으면 리턴
			answer++;
			return;
		}
		
		for(int i =start; i<=25; i++) {
			int d = i-1;
			gongju[cur] = i;
			if(map[d/5][d%5]==1)princess(cur+1,dasom+1,i+1);
			else princess(cur+1,dasom,i+1);
		}
		
		
	}	
	public static int bfs() {
		int num =0;
		int in = gongju[0]-1;
		boolean[][] visited = new boolean[5][5];
		Queue<int[]> Q = new LinkedList<>();
		Q.offer(new int[] {in/5,in%5});
		visited[in/5][in%5] = true;
		num++;
		while(!Q.isEmpty()) {
			int a = Q.peek()[0];
			int b = Q.peek()[1];
			Q.poll();
			for(int i = 0; i<4; i++) {
				int nx = a+dx[i];
				int ny = b+dy[i];
				if(nx<0||nx>4||ny<0||ny>4)continue;//범위 벗어나면 제외
				if(check(nx,ny))continue;//선택한 곳이 아니면 제외
				if(visited[nx][ny])continue;//방문한 곳이면 제외
				visited[nx][ny] =true;
				num++;
				Q.offer(new int[] {nx,ny});
			}
		}		
		return num;
	}
	
	public static boolean check(int a, int b) {
		int num = a*5+b+1;
		for(int i = 0; i<7; i++) {
			if(gongju[i]==num)return false;
		}
		return true;
	}

}
