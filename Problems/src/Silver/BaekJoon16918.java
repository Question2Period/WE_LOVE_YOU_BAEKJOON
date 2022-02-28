package Silver;
import java.io.*;
import java.util.*;
public class BaekJoon16918 {
	public static int R,C,N;
	public static String str;
	public static Character[][] arr;
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,1,-1};
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		Queue<int[]>Q = new LinkedList<>();
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		int choice = N%4;
		arr = new Character[R+1][C+1];
		for(int i = 1; i<=R; i++) {
			str = br.readLine();
			for(int j =1; j<=C; j++) {
				arr[i][j] = str.charAt(j-1);
				if(arr[i][j]=='O') {
					Q.offer(new int[]{i,j}); //큐에 넣기
				}
			}
		}
		switch (choice) {
		case 0:
		case 2:
			for(int i =1; i<=R; i++) {
				for(int j =1; j<=C; j++) {
					System.out.print(0);
				}
				System.out.println();
			}
			break;
		case 1:
			for(int i =1; i<=R; i++) {
				for(int j =1; j<=C; j++) {
					System.out.print(arr[i][j]);
				}
				System.out.println();
			}
			break;

		case 3:
			check(Q);
			break;

		}
		
	}
	public static void check(Queue<int[]> Q) {
		for(int i =1; i<=R; i++) {
			for(int j =1; j<=C; j++) {
				arr[i][j] = 'O';
			}
		}
		while(!Q.isEmpty()) {
			int[] var=Q.poll();
			int x= var[0];
			int y= var[1];
			for(int i = 0; i<4; i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				if(nx<1||ny<1||nx>R||ny>C)continue;
				if(arr[nx][ny]=='.')continue;
				arr[nx][ny]='.';
			}
			arr[x][y]='.';
		}
		for(int i =1; i<=R; i++) {
			for(int j =1; j<=C; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
	}
}
