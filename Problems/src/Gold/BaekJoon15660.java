package Gold;
import java.io.*;
import java.util.*;
public class BaekJoon15660 {
	public static int N,M,max,sum1,sum2,sum3,sum4,trytime,area;
	public static int[][] map;
	public static boolean[][] visit;
	public static int[][] ref1 = {{0,1},{0,2},{1,0},{2,0}}; // 기본 3줄짜리가 있는 테트로미노. 0~1은 누워있는 형태, 2~3은 서있는 형태
	public static int[][] t1 = {{0,3},{3,0}};//1*4 테트로미노 0번은 누워있고 1번은 서있다 청록
	public static int[][] t2 = {{1,2},{-1,2},{1,0},{-1,0},{2,1},{2,-1},{0,1},{0,-1}}; 
	//0~3번까지는 누워있는 경우, 4~7번은 서있는 경우 주황
	public static int[][] t3 = {{1,1},{-1,1},{1,1},{1,-1}}; //0~1번까지는 누워있는 경우, 2~3번은 서있는 경우 핑크
	public static int[][] ref2 = {{0,1},{1,0}}; // 0번누워있는것, 1번은 서있는 것  
	public static int[][] t4 = {{1,0},{1,1},{0,1},{1,1}}; // 0~1번누워있는것, 2~3번은 서있는 것 노랑
	public static int[][] t5 = {{1,0},{-1,1},{-1,0},{1,1},{0,-1},{1,1},{0,1},{1,-1}}; // 0~3번누워있는것, 4~7번은 서있는 것 초록이



	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N+1][M+1];
		for(int i = 1; i<=N; i++) {
			st=  new StringTokenizer(br.readLine());
			for(int j = 1; j<=M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i = 1; i<=N; i++) {
			for(int j = 1; j<=M; j++) {
				area = 0;
				visit = new boolean[N+1][M+1];
				decide1(i,j);
				decide2(i,j);
			}
		}
		System.out.println(max);
	}

	public static void decide1(int x, int y) {
		boolean lay = true;
		boolean stand = true;
		sum1 =map[x][y];
		sum2 = map[x][y];
		for(int i = 0; i<4; i++) {
			int nx = x+ref1[i][0];
			int ny = y+ref1[i][1];
			if(nx<1||nx>N||ny<1||ny>M) {
				if(i<2)lay=false;
				else stand =false;
				continue;
			}
			if(i<2)sum1+=map[nx][ny];
			else sum2+=map[nx][ny];
		}
		if(!lay&&!stand)return;
		max = Math.max(max,blue(x,y,lay,stand));
		max = Math.max(max,orange(x,y,lay,stand));
		max = Math.max(max,pink(x,y,lay,stand));
	}

	public static void decide2(int x, int y) {
		boolean lay = true;
		boolean stand = true;
		sum3 = map[x][y]; //눕
		sum4 = map[x][y]; //서
		for(int i = 0; i<2; i++) {
			int nx = x+ref2[i][0];
			int ny = y+ref2[i][1];
			if(nx<1||nx>N||ny<1||ny>M) {
				if(i==0)lay=false;
				else stand =false;
				continue;
			}
			if(i==0)sum3+=map[nx][ny];
			else sum4+=map[nx][ny];
		}
		if(!lay&&!stand)return;
		max = Math.max(max,green(x,y,lay,stand));
		max = Math.max(max,yellow(x,y,lay,stand));
	}

	public static int blue(int x, int y, boolean lay, boolean stand){
		int cnt = 0;
		if(lay) { //누운거 가능할 때
			int nx = x+t1[0][0];
			int ny = y+t1[0][1];
			if(!(nx<1||nx>N||ny<1||ny>M))cnt = map[nx][ny]+sum1;
		}
		if(stand) {
			int nx = x+t1[1][0];
			int ny = y+t1[1][1];
			if(!(nx<1||nx>N||ny<1||ny>M))cnt = Math.max(cnt,map[nx][ny]+sum2);
		}
		return cnt;
	}

	public static int orange(int x, int y, boolean lay, boolean stand){
		int cnt = 0;
		if(lay) { //누운거 가능할 때
			for(int i =0; i<4; i++) {
				int nx = x+t2[i][0];
				int ny = y+t2[i][1];
				if(nx<1||nx>N||ny<1||ny>M) continue;
				cnt = Math.max(cnt,map[nx][ny]+sum1);
			}
		}
		if(stand) {
			for(int i =4; i<8; i++) {
				int nx = x+t2[i][0];
				int ny = y+t2[i][1];
				if(nx<1||nx>N||ny<1||ny>M)continue;
				cnt = Math.max(cnt,sum2+map[nx][ny]);
			}
		}
		return cnt;
	}

	public static int pink(int x, int y, boolean lay, boolean stand){
		int cnt = 0;
		if(lay) { //누운거 가능할 때
			for(int i =0; i<2; i++) {
				int nx = x+t3[i][0];
				int ny = y+t3[i][1];
				if(nx<1||nx>N||ny<1||ny>M) continue;;
				cnt = Math.max(cnt,map[nx][ny]+sum1);
			}
		}
		if(stand) {
			for(int i =2; i<4; i++) {
				int nx = x+t3[i][0];
				int ny = y+t3[i][1];
				if(nx<1||nx>N||ny<1||ny>M)continue;
				cnt = Math.max(cnt,sum2+map[nx][ny]);
			}
		}
		return cnt;
	}

	public static int green(int x, int y, boolean lay, boolean stand){
		int cnt = 0;
		int suma = 0;
		int sumb = 0;
		outer : if(lay) { //누운거 가능할 때
			for(int i =0; i<2; i++) {
				int nx = x+t5[i][0];
				int ny = y+t5[i][1];
				if(nx<1||nx>N||ny<1||ny>M) break;
				suma+=map[nx][ny];
			}
			for(int i =2; i<4; i++) {
				int nx = x+t5[i][0];
				int ny = y+t5[i][1];
				if(nx<1||nx>N||ny<1||ny>M) break outer;
				sumb+=map[nx][ny];
			}
			cnt = Math.max(suma,sumb)+sum3;
		}
		suma = 0;
		sumb = 0;
		out2 : if(stand) {
			for(int i =4; i<6; i++) {
				int nx = x+t5[i][0];
				int ny = y+t5[i][1];
				if(nx<1||nx>N||ny<1||ny>M)break;
				suma+=map[nx][ny];
			}
			for(int i =6; i<8; i++) {
				int nx = x+t5[i][0];
				int ny = y+t5[i][1];
				if(nx<1||nx>N||ny<1||ny>M)break out2;
				sumb+=map[nx][ny];
			}
			cnt = Math.max(cnt,Math.max(suma, sumb)+sum4);
		}
		return cnt;
	}

	public static int yellow(int x, int y, boolean lay, boolean stand){
		int cnt = 0;
		int suma = 0;
		int sumb = 0;
		outer : if(lay) { //누운거 가능할 때
			for(int i =0; i<2; i++) {
				int nx = x+t4[i][0];
				int ny = y+t4[i][1];
				if(nx<1||nx>N||ny<1||ny>M) break outer;
				suma+=map[nx][ny];
			}
			cnt = suma+sum3;
		}
		out2 : if(stand) {
			for(int i =2; i<4; i++) {
				int nx = x+t4[i][0];
				int ny = y+t4[i][1];
				if(nx<1||nx>N||ny<1||ny>M)break out2;
				sumb+=map[nx][ny];
			}
			cnt = Math.max(cnt,sumb+sum4);
		}
		return cnt;
	}
	

}
