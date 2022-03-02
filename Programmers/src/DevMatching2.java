import java.io.*;
import java.util.*;
public class DevMatching2 {
	public static int[][] arr;
	public static int[][] copy;
	public static int[] dx = {0,1,0,-1};
	public static int[] dy = {1,0,-1,0};
	public static int num,count,flag,min;
	public static void main(String[] args) throws IOException{
		
		int rows = 3;
		int columns = 3;
		
		 int[][]queries ={{1,1,2,2},{1,2,2,3},{2,1,3,2},{2,2,3,3}};
		
		num = 1;
		arr = new int[rows+1][columns+1];
		copy = new int[rows+1][columns+1];
		for(int i = 1; i<=rows; i++) {
			for(int j = 1; j<=columns; j++) {
				arr[i][j] = num++;
			}
		}
		int[] answer = new int[queries.length];
		for(int i = 0;i<queries.length; i++) {
			check(queries[i][0],queries[i][1],queries[i][2],queries[i][3]);
			answer[i] = min;
		}
		for(int i = 0; i<answer.length; i++) System.out.print(answer[i]+" ");
	}
	public static void check(int a,int b, int c, int d) {
		count = 0;
		min=Integer.MAX_VALUE;
		int x= a;
		int y = b;
		while(flag!=-1) {
			for(int i = 0; i<4&&flag!=-1; i++) {
				int nx = x;
				int ny = y;
				while(true) {
					nx+=dx[i];
					ny+=dy[i];
					if(nx<a||nx>c||ny<b||ny>d)break;
					if((nx>a&&nx<c)&&(ny>b&&ny<d)) break;
					copy[nx][ny]=arr[x][y];
					count++;
					x = nx;
					y = ny;
					min = Math.min(min, arr[x][y]);
					if(count==(2*c+2*d-2*a-2*b)) {
						flag=-1;
						break;
					}
				}
			}
		}
		flag=0;
		for(int i = 1; i<arr.length; i++) {
			for(int j = 1; j<arr[0].length; j++) {
				if(copy[i][j]==0)continue;
				arr[i][j]=copy[i][j];
			}
		}
	}
}
