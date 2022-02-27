package IM;
import java.io.*;
import java.util.*;
public class BaekJoon7236 {
	public static int size,nx,ny,Max,count;
	public static int[][] pool;
	public static int[] dx = {0,1,1,1,0,-1,-1,-1};//열 12시부터 시작
	public static int[] dy = {-1,-1,0,1,1,1,0,-1};//행
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			Max = 1;
			size = Integer.parseInt(br.readLine());
			pool = new int[size+1][size+1];
			for(int i =1; i<=size; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j= 1; j<=size; j++) {
					if(st.nextToken().equals("W"))pool[i][j]=1;
				}
			}
			check(pool);
			System.out.println("#"+t+" "+Max);
			
		}
	}
	public static void check(int[][] arr) {
		for(int i =1; i<=size; i++) {
			for(int j =1; j<=size; j++) {
				count = 0;
				if(pool[i][j]==1)
				for(int k = 0; k<8; k++) {
					nx = j+dx[k];
					ny = i+dy[k];
					if(nx<1||nx>size||ny<1||ny>size)continue;
					if(pool[ny][nx]==1) count++;
				}
				Max = Math.max(Max, count);
			}
		}
	}

}
