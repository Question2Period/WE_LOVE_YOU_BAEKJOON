package Gold;
import java.io.*;
import java.util.*;
public class BaekJoon16509 {
	public static int kingR,kingC,cnt;
	public static int[]dx = {-1,0,1,0};//상우하좌
	public static int[]dy = {0,1,0,-1};
	public static int[][]side = {{-1,1},{1,1},{1,-1},{-1,-1}};//1시부터 시계방향
	public static int[][] move = {{-3,-2},{-3,2},{-2,3},{2,3},{3,2},{3,-2},{2,-3},{-2,-3}};
	public static boolean[][] map;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st  = new StringTokenizer(br.readLine());
		int startR = Integer.parseInt(st.nextToken());
		int startC = Integer.parseInt(st.nextToken());
		st  = new StringTokenizer(br.readLine());
		kingR = Integer.parseInt(st.nextToken());
		kingC = Integer.parseInt(st.nextToken());
		map = new boolean[10][9];
		bfs(startR,startC);
		System.out.println(cnt);
	}
	
	public static void bfs(int row, int column) {
		Queue<int[]> Q = new LinkedList<>();
		Q.offer(new int[] {row,column,0});
		map[row][column] =true;
		outer : while(!Q.isEmpty()) {
			int x = Q.peek()[0];
			int y = Q.peek()[1];
			cnt = Q.peek()[2];
			if(x==kingR&&y==kingC)break outer;
			Q.poll();
			for(int i = 0; i<8;i++) {
				int nx =x+move[i][0];
				int ny =y+move[i][1];
				if(nx<0||nx>9||ny<0||ny>8)continue;
				if(map[nx][ny])continue;
				if(visit(x,y,i)<0)continue;
				map[nx][ny] = true;
				Q.offer(new int[] {nx,ny,cnt+1});
			}
		}
	}
	
	public static int visit(int x,int y,int kind) {
		int nx = 0;
		int ny = 0;
		if(kind==0||kind==1) {
			nx =x+dx[0];
			ny = y+dy[0];
			if(nx==kingR&&ny==kingC)return -1;
			if(kind==0) {
				if(nx+side[3][0]==kingR&&ny+side[3][1]==kingC)return -1;
			}
			else {
				if(nx+side[0][0]==kingR&&ny+side[0][1]==kingC)return -1;
			}
		}
		else if(kind==2||kind==3) {
			nx =x+dx[1];
			ny = y+dy[1];
			if(nx==kingR&&ny==kingC)return -1;
			if(kind==2) {
				if(nx+side[0][0]==kingR&&ny+side[0][1]==kingC)return -1;
			}
			else {
				if(nx+side[1][0]==kingR&&ny+side[1][1]==kingC)return -1;
			}
		}
		else if(kind==4||kind==5) {
			nx =x+dx[2];
			ny = y+dy[2];
			if(nx==kingR&&ny==kingC)return -1;
			if(kind==4) {
				if(nx+side[1][0]==kingR&&ny+side[1][1]==kingC)return -1;
			}
			else {
				if(nx+side[2][0]==kingR&&ny+side[2][1]==kingC)return -1;
			}
		}
		else {
			nx =x+dx[3];
			ny = y+dy[3];
			if(nx==kingR&&ny==kingC)return -1;
			if(kind==6) {
				if(nx+side[2][0]==kingR&&ny+side[2][1]==kingC)return -1;
			}
			else {
				if(nx+side[3][0]==kingR&&ny+side[3][1]==kingC)return -1;
			}
		}
		return 1;
	}

}
