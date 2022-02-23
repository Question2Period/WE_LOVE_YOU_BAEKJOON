package Silver;
import java.io.*;
import java.util.*;
public class BaekJoon4963 {
	public static int[][] arr;
	public static int[] dx = new int[] {1,-1,0,0,-1,1,-1,1};
	public static int[] dy = new int[] {0,0,1,-1,-1,-1,1,1};
	public static int n,w,count;
	public static boolean[][] Visited;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String str;
		while(true) {
			str=br.readLine();
			st = new StringTokenizer(str);
		w = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		if(w==0 && n==0) break;
		arr = new int[n+1][w+1];
		Visited = new boolean[n+1][w+1];
		for(int i =1; i<=n; i++ ) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j<=w; j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		count = 0;
		for(int i =1; i<=n; i++) {
			for(int j =1; j<=w; j++) {
				if(!Visited[i][j]&&arr[i][j]==1) {
					dfs(i,j);
					count++;
				}
			}
		}
		System.out.println(count);
		}
	}
	
	public static void dfs(int x , int y) {
		Visited[x][y]=true;
		for(int i = 0; i<8; i++) {
			int nx=x+dx[i];
			int ny=y+dy[i];
			if(nx>=1 && nx<=n && ny>=1 && ny<=w) {
				if(arr[nx][ny]==1&&!Visited[nx][ny]) dfs(nx,ny);				
			}
		}
	}
	
	
	
}
