package Gold;
import java.io.*;
import java.util.*;
public class BaekJoon2636 {
	public static int cnt,cheese,row,column,time;
	public static int[][] arr;
	public static boolean[][] visit;
	public static int[] dx = {0,1,0,-1}; //열
	public static int[] dy = {-1,0,1,0}; //행
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		row = Integer.parseInt(st.nextToken()); // 세로(행)
		column = Integer.parseInt(st.nextToken());//가로(열)
		arr = new int[row+1][column+1];
		for(int i = 1; i<=row; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j<=column; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]==1)cheese++;
			}
		}
		for(int i = 1; i<=row&&cheese!=0; i++)
			for(int j = 1; j<=column&&cheese!=0; j++) {
				cnt = 0;
				time++;
				visit = new boolean[row+1][column+1];
				bfs(1,1);
			}
		System.out.println(time);
		System.out.println(cnt);
	}
	
	
	public static void bfs(int hang,int yal) {
		Queue<int[]> Q = new LinkedList<>();
		Q.add(new int[] {hang,yal});
		visit[hang][yal] =true;
		while(!Q.isEmpty()) {
			int x = Q.peek()[0];//행
			int y = Q.peek()[1];//열
			Q.poll();
			for(int i = 0; i<4; i++) {
				int ax = x+dx[i];
				int ay = y+dy[i];
				if(ax<1||ax>row||ay<1||ay>column)continue;
				if(visit[ax][ay])continue;
				if(arr[ax][ay]==1) {
					cheese--;
					cnt++;
					arr[ax][ay]=0;
				}
				else Q.add(new int[] {ax,ay});
				visit[ax][ay] =true;
			}
		}
	}
	

}
