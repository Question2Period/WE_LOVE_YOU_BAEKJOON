package Gold;
import java.io.*;
import java.util.*;
public class BaekJoon11559 {
	public static int[][] map,mapcopy;
	public static int[] dx = {-1,0,1,0};
	public static int[] dy = {0,1,0,-1};
	public static int answer;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[12][6];
		for(int i = 0; i<12; i++) {
			String str = br.readLine();
			for(int j= 0; j<6; j++) {
				char A = str.charAt(j);
				if(A=='R')map[i][j] = 1;
				else if(A=='G')map[i][j] = 2;
				else if(A=='B')map[i][j] = 3;
				else if(A=='P')map[i][j] = 4;
				else if(A=='Y')map[i][j] = 5;
			}
		}

		start();
		System.out.println(answer);
	}

	public static void start() {//시행
		int com = bomb();
		if(com==0)return;
		else answer+=com;
		gravity();
		start();
	}


	public static void gravity() {//시행후 중력에 의해 아래 채우기
		Queue<Integer> grav = new LinkedList<>();
		for(int i = 0; i<6; i++) {
			columncheck(i,grav);
		}
	}

	public static int bomb() { // 지우기
		int combo = 0;
		Queue<int[]> check = bfs();
		while(!check.isEmpty()) {//콤보가 존재한다면
			int x = check.peek()[0];
			int y = check.peek()[1];
			check.poll();
			map[x][y] = 0;//제거
			combo = 1;
		}
		return combo;
	}

	public static void columncheck(int column,Queue<Integer>grav) {//열 체크후 아래쪽부터 채우기
		
		for(int i = 11; i>=0; i--) {
			if(map[i][column]==0)continue;
			grav.offer(map[i][column]);// 0제외 다담기
			map[i][column] = 0;//다 0으로 만들기
		}
		int start = 11;
		while(!grav.isEmpty()) {
			map[start][column] = grav.poll();
			start--;
		}
	}
	
	public static Queue<int[]> bfs() { //지워질 값들을 저장해서 전달
		Queue<int[]>Q = new LinkedList<>();
		Queue<int[]>transfer = new LinkedList<>();//저장 큐
		boolean[][] visit = new boolean[12][6];
		for(int i = 0; i<12; i++) {
			for(int j= 0; j<6; j++) {
				if(map[i][j]<1)continue; // 뿌요가 없으면 패스
				if(visit[i][j])continue; // 이미 방문한 뿌요면 패스
				Q.offer(new int[] {i,j});
				visit[i][j] = true;
				int cnt = 1;
				Queue<int[]> temp = new LinkedList<>();//임시 큐
				while(!Q.isEmpty()) {
					int x = Q.peek()[0];
					int y = Q.peek()[1];
					temp.offer(Q.poll());
					for(int k = 0; k<4; k++) {
						int nx = x+dx[k];
						int ny = y+dy[k];
						if(nx<0||nx>11||ny<0||ny>5)continue;//맵을 벗어날시 패스
						if(map[nx][ny]!=map[x][y])continue;//다른 뿌요면 패스
						if(visit[nx][ny])continue; // 이미 방문한 뿌요면 패스
						visit[nx][ny] = true;//방문 처리
						cnt++;
						Q.offer(new int[] {nx,ny});
					}
				}
				if(cnt>=4) {
					while(!temp.isEmpty()) {
						transfer.offer(temp.poll());
					}
				}
			}
		}

		return transfer;

	}

}
