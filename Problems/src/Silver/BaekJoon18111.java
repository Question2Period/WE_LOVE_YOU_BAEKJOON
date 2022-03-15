package Silver;
import java.io.*;
import java.util.*;
public class BaekJoon18111 {
	public static int[][] arr;
	public static int sec,height,M,N,B,mintime,realtime,index;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());//행
		M = Integer.parseInt(st.nextToken());//열
		B = Integer.parseInt(st.nextToken());//블록 수
		arr = new int[N+1][M+1];
		for(int i =1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j =1; j<=M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		mintime = Integer.MAX_VALUE;
		for(int i = 0; i<=256; i++) check(i);
		System.out.println(mintime+" "+index);
	}
	
	public static void check(int x) {
		int block = B;
		realtime = 0; // 현재 블록의 시간
		for(int i = 1; i<=N; i++)
			for(int j = 1; j<=M; j++) {
				int cost = arr[i][j]-x; //값이 음수이면 +1, 값이 양수이면 +2
				if(cost>0)realtime+=(cost*2);
				else realtime-=cost;
				block+=cost;
			}
		if(block<0)return;
		if(mintime>realtime) {
			mintime = realtime;
			index = x;
		}
		else if(mintime==realtime) {
			if(x>index) index = x;
		}
	}

}
