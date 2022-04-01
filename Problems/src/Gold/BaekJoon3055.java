package Gold;
import java.io.*;
import java.util.*;
public class BaekJoon3055 {
	public static int[] dx = {-1,0,1,0};
	public static int[] dy = {0,1,0,-1};
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken()); // 행
		int C = Integer.parseInt(st.nextToken()); // 열
		int Endx=0;
		int Endy=0;
		int[][] map = new int[R+1][C+1];
		boolean[][] visit = new boolean[R+1][C+1];
		int[][] dis = new int[R+1][C+1];
		Queue<int[]> Q = new LinkedList<>();
		Queue<int[]> Q2 = new LinkedList<>();
		Queue<int[]> temp = new LinkedList<>();
		Queue<int[]> temp2 = new LinkedList<>();
		for(int i = 1; i<=R; i++) {
			String str = br.readLine();
			for(int j = 1; j<=C; j++) {
				char index = str.charAt(j-1);
				if(index=='D') {
					Endx = i;
					Endy = j;
					map[i][j] = -3;
				}
				else if(index=='*') {
					map[i][j] = -1; //물
					Q2.offer(new int[] {i,j});
				}
				else if(index=='X')map[i][j] = -2; //돌
				else if(index=='S') {
					Q.offer(new int[] {i,j}); //시작점
					visit[i][j] = true;
				}
			}
		}
		
		
		
		while(!visit[Endx][Endy]) {
						
			while(!Q2.isEmpty()) {
				int waterx = Q2.peek()[0];
				int watery = Q2.peek()[1];
				Q2.poll();
				for(int i = 0; i<4; i++) { // 물 퍼짐
					int nx = waterx+dx[i];
					int ny = watery+dy[i];
					if(nx<1||nx>R||ny<1||ny>C)continue; 
					if(map[nx][ny]==-1||map[nx][ny]==-2||map[nx][ny]==-3)continue; // 돌,물,굴 이동불가
					map[nx][ny]=-1; //물 채우기
					temp2.offer(new int[] {nx,ny});
				}
			}
			while(!temp2.isEmpty()) { //다음 물 블록 채우기
				Q2.offer(temp2.poll());
			}
			
			while(!Q.isEmpty()) { // 물이 찰 예정인 곳은 못가므로 물 먼저 이동?
				int x = Q.peek()[0];
				int y = Q.peek()[1];
				Q.poll();
				for(int i = 0; i<4; i++) { // 고슴도치 무빙
					int nx = x+dx[i];
					int ny = y+dy[i];
					if(nx<1||nx>R||ny<1||ny>C)continue;
					if(visit[nx][ny])continue; // 
					if(map[nx][ny]==-1||map[nx][ny]==-2)continue; // 물,돌 이동불가
					visit[nx][ny] =true;
					dis[nx][ny]=dis[x][y]+1;
					temp.offer(new int[] {nx,ny});
				}
			}
			while(!temp.isEmpty()) { //다음 물 블록 채우기
				Q.offer(temp.poll());
			}
			if(Q.isEmpty())break;
			
		}
		if(dis[Endx][Endy]==0)System.out.println("KAKTUS");
		else System.out.println(dis[Endx][Endy]);

	}

}
