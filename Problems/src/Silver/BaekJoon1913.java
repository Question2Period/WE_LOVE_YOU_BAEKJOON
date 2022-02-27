package Silver;
import java.io.*;
import java.util.*;
public class BaekJoon1913 {
	public static int[] dx = {1,0,-1,0};
	public static int[] dy = {0,1,0,-1};
	public static int[][] arr;
	public static int N,Var,answerX,answerY,flag;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		Var = Integer.parseInt(br.readLine());
		arr = new int[N+1][N+1];
		Snail(1,1);
		for(int i = 1; i<=N; i++) {
			for(int j = 1; j<=N; j++) {
				bw.write(arr[i][j]+" ");
			}
			bw.write("\n");
		}
		if(answerX==0&&answerY==0) {
			answerX=N/2+1;
			answerY=N/2+1;
		}
		bw.write(answerX+" "+answerY);
		bw.flush();
		bw.close();
		br.close();
	}
	public static void Snail(int x, int y) {
		arr[x][y]=N*N;
		while(flag!=1) {
			for(int i = 0; flag!=1&&i<4; i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				while(true) {
					if(arr[x][y]==Var) {
						answerX = x;
						answerY = y;
					}
					if(nx<1||ny<1||nx>N||ny>N)break;
					if(arr[nx][ny]!=0)break;
					arr[nx][ny]=arr[x][y]-1;
					x = nx;
					y = ny;
					if(arr[x][y]==1) {
						flag=1;
						break;
					}
					nx+=dx[i];
					ny+=dy[i];
				}
				
			}
		}
	}
}
