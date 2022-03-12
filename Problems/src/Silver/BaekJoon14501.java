package Silver;
import java.io.*;
import java.util.*;
public class BaekJoon14501 {
	public static int N,Max;
	public static int[][] arr;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		arr = new int[2][N+2];			
			for(int j= 1; j<=N; j++) {
				st = new StringTokenizer(br.readLine());
				arr[0][j] = Integer.parseInt(st.nextToken());
				arr[1][j] = Integer.parseInt(st.nextToken());
			}
			check(1,0);
		System.out.println(Max);
	}
	
	public static void check(int day,int total) {
		if(day==N+1)Max = Math.max(Max, total);
		if(day>N) return;
		check(day+arr[0][day],total+arr[1][day]);
		check(day+1,total);		
	}
}
