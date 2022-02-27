package IM;
import java.io.*;
import java.util.*;
public class SWEA1220 {
	public static int[][] arr;
	public static int[] dx= {-1,1};
	public static int N,nx,count,npole;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for(int i = 1; i<=10; i++) {
			count = 0;
			N = Integer.parseInt(br.readLine());
			arr = new int[N+1][N+1];
			for(int j = 1; j<=N; j++) {
				st = new StringTokenizer(br.readLine());
				for(int k = 1; k<=N; k++) {
					arr[j][k]=Integer.parseInt(st.nextToken());
				}
			}
			for(int y = 1; y<=N; y++) {
				npole = 0;
				for(int x= 1; x<=N; x++) {
					
					if(arr[x][y]==2) {
						if(npole==1) {
							count++;
						}
						npole = 0;
					}
					else if(arr[x][y]==1) npole = 1;
				}
			}
			System.out.println("#"+i+" "+count);
		}

	}

}
