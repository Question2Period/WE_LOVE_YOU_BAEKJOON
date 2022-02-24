package Gold;
import java.io.*;
import java.util.*;

public class BaekJoon10026 {
	static int n;
	static int[][] arr;
	static boolean[][] Visited;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n+1][n+1];
		Visited = new boolean[n+1][n+1];
		int count=0;
		int rgcount=0;		
		for(int i=1; i<=n; i++) {
			String[] color = br.readLine().split("");
			for(int j=1; j<=n; j++) {
				if(color[j].equals("R")) {
					arr[i][j] = 1;
				}else if(color[j].equals("G")) {
					arr[i][j] = 2;
				}else {
					arr[i][j] = 3;
				}
				
			}
		}				
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				for(int k=1; k<4; k++) {
					if(!Visited[i][j] && arr[i][j] == k) {
						dfs(i,j,k);
						count++;
					}
				}
			}
		}		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				if(arr[i][j] ==1 ) {
					arr[i][j] = 2;
				}
			}
		}		
		Visited = new boolean[n+1][n+1];
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				for(int k=2; k<4; k++) {
					if(!Visited[i][j] && arr[i][j] == k) {
						dfs(i,j,k);
						rgcount++;
					}
				}
			}
		}
		System.out.println(count+" "+rgcount);	
	}	
	static void dfs(int x, int y, int color) {
		
		Visited[x][y] = true;
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx <1 || ny <1 || nx>n || ny>n) continue;
			if(Visited[nx][ny]) continue;
			
			if(arr[nx][ny] == color) {
				dfs(nx,ny, color);
			}
		}
		
	}
}