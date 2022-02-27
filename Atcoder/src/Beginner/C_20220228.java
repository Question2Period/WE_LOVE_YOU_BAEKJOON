package Beginner;
import java.io.*;
import java.util.*;
import java.util.*;
public class C_20220228 {
	public static boolean[][]arr;
	public static String str;
	public static int[] dx = {1,2,3,4,5};
	public static int[] dy = {1,2,3,4,5};
	public static int[][]remember;
	public static int flag,countx,county,countside,N;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new boolean[N][N];
		for(int i = 0; i<N; i++) {
			str = (br.readLine());
			for(int j = 0; j<N; j++) {
				if(str.charAt(j)=='#') arr[i][j]=true;
			}
		}
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				if(!arr[i][j])continue;
				if(checkx(i,j)==-1) break;				
			}
			if(flag==-1) {
				System.out.println("Yes");
				break;
			}
		}
		if(flag!=-1)System.out.println("No");
		
	}

	public static int checkx(int x, int y) {
		countx = 0;
		county = 0;
		countside = 0;
		for(int i = 0; i<5; i++) {
			int nx = x+dx[i];
			int ny = y;
			if(nx<0||nx>N-1)continue;
			if(arr[nx][ny])countx++;
			if(countx==3) {
				flag=-1;
				break;
			}
		}
		if(flag!=-1) {
			for(int i = 0; i<5; i++) {
				int nx = x;
				int ny = y+dy[i];
				if(ny<0||ny>N-1)continue;
				if(arr[nx][ny])county++;
				if(county==3) {
					flag=-1;
					break;
				}
			}
			if(flag!=-1) {
				for(int i = 0; i<5; i++) {
					int nx = x+dx[i];
					int ny = y+dy[i];
					if(nx<0||nx>N-1||ny<0||ny>N-1)continue;
					if(arr[nx][ny])countside++;
					if(countside==3) {
						flag=-1;
						break;
					}
				}
			}
		}
		return flag;
	}
	
}
