import java.io.*;
import java.util.*;
public class SWEA5656 {
	public static int[] dx = {-1,0,1,0};
	public static int[] dy = {0,1,0,-1};
	public static int N,W,H,brick,max;
	public static int[][] map;
	public static boolean[][] visit;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int t = 1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			Q = new LinkedList<>();
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());//열
			H = Integer.parseInt(st.nextToken());//행
			map  = new int[H+1][W+1];
			for(int i = 1; i<=H; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 1; j<=W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i =0; i<N; i++) {
				visit = new boolean[H+1][W+1];
				collision(0,N);
			}
			
		}
	}
	
	public static void collision(int column,int cnt) { //한 행에서 구슬 부딪히는 시도
		if(column>H)return; // 범위 벗어날 시 리턴
		if(cnt==N)return; // 횟수 다사용시 리턴
		for(int j = 1; j<=W; j++) {
			for(int i= column; i<=H; i++) {
				if(!check(i,j))continue; //벽돌이 없다면 그 열의 다음행에 벽돌이 있는지 계속 체크
				if(visit[i][j])break;
				action(i,j,map[i][j]);//만약 벽돌이 있다면?
				visit[i][j] = true;
				break;
			}
		}
		collision(column+1,int cnt);
	}

	public static boolean check(int row, int column) { // 실제 벽돌이 존재하는지 체크하는 메서드
		if(map[row][column]!=0)return true;
		else return false;
	}
	
	public static void action(int row, int column,int type) { // 벽돌 깨기를 수행하는 메서드
		for(int i =0; i<4; i++) {
			for(int j =0; j<type; j++) {
			int nx = row+dx[i]*j;
			int ny = column+dy[i]*j;
			if(nx<1||nx>H||ny<1||ny>W)continue;
			if(map[nx][ny]==0)continue;
			brick++;
			map[nx][ny] =0;			
			}
		}
	}
}
