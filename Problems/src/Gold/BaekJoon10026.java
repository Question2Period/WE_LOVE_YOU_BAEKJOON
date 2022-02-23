package Gold;
import java.io.*;
import java.util.*;
public class BaekJoon10026 {
	public static char[][] arr;
	public static int[] dx = new int[] {1,-1,0,0};
	public static int[] dy = new int[] {0,0,1,-1};
	public static int n,CountN,CountS;
	public static String str;
	public static boolean[][] VisitedNormal;
	public static boolean[][] VisitedSimilar;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		arr = new char[n+1][n+1];
		VisitedNormal = new boolean[n+1][n+1];
		VisitedSimilar = new boolean[n+1][n+1];
		for(int i =1; i<=n; i++ ) {
			str = br.readLine();
			for(int j = 1; j<=n; j++) {
				arr[i][j]=str.charAt(j-1);
			}
		}
		for(int i =1; i<=n; i++) {
			for(int j =1; j<=n; j++) {
				if(!VisitedNormal[i][j]&&arr[i][j]=='G') {
					dfs(VisitedNormal,'G',i,j);
					CountN++;
				}
			}
		}
		for(int i =1; i<=n; i++) {
			for(int j =1; j<=n; j++) {
				if(!VisitedNormal[i][j]&&arr[i][j]=='B') {
					dfs(VisitedNormal,'B',i,j);
					CountN++;
				}
			}
		}
		for(int i =1; i<=n; i++) {
			for(int j =1; j<=n; j++) {
				if(!VisitedNormal[i][j]&&arr[i][j]=='R') {
					dfs(VisitedNormal,'R',i,j);
					CountN++;
				}
			}
		}
		for(int i =1; i<=n; i++) {
			for(int j =1; j<=n; j++) {
				if(!VisitedSimilar[i][j]&&arr[i][j]=='R'||arr[i][j]=='G') {
					dfsforSimilar(VisitedSimilar,'R','G',i,j);
					CountS++;
				}
			}
		}
		for(int i =1; i<=n; i++) {
			for(int j =1; j<=n; j++) {
				if(!VisitedSimilar[i][j]&&arr[i][j]=='B') {
					dfs(VisitedSimilar,'R',i,j);
					CountS++;
				}
			}
		}
		System.out.println(CountN+" "+CountS);
	}



	public static void dfs(boolean[][] Visited,char a,int x , int y) {
		Visited[x][y]=true;
		for(int i = 0; i<4; i++) {
			int nx=x+dx[i];
			int ny=y+dy[i];
			if(nx>=1 && nx<=n && ny>=1 && ny<=n) {
				if(arr[nx][ny]==a&&!Visited[nx][ny]) dfs(Visited,a,nx,ny);				
			}
		}
	}
	public static void dfsforSimilar(boolean[][] Visited,char a,char b,int x , int y) {
		Visited[x][y]=true;
		for(int i = 0; i<4; i++) {
			int nx=x+dx[i];
			int ny=y+dy[i];
			if(nx>=1 && nx<=n && ny>=1 && ny<=n) {
				if((arr[nx][ny]==a||arr[nx][ny]==b)&&!Visited[nx][ny]) dfsforSimilar(Visited,a,b,nx,ny);				
			}
		}
	}



}
