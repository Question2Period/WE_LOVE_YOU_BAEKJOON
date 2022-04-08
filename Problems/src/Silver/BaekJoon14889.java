package Silver;
import java.io.*;
import java.util.*;
public class BaekJoon14889 {
	public static int N,min,mapsum;
	public static int[][] map;
	public static int[] store;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		min= Integer.MAX_VALUE;
		map = new int[N+1][N+1];
		for(int i= 1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j= 1; j<=N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				mapsum+=map[i][j];
			}
		}
		store = new int[N/2];
		NcR(0,0);
		System.out.println(min);
	}
	
	public static void NcR(int cnt,int start) {
		if(cnt==N/2) {
			min = Math.min(min,calculation(store));
			return;
		}
		for(int i = start; i<N; i++) {
			store[cnt] = i+1;
			NcR(cnt+1,i+1);
		}
		
	}
	
	public static int calculation(int[] store) {
		int sum1 = 0;
		int sum2 = 0;
		int[] another =new int[N/2+1];
		int cnt = 1;
		for(int i = 1; i<=N; i++) {
			if((Arrays.binarySearch(store,i))<0) {
				another[cnt] = i;
				cnt++;
			}
		}
		for(int i= 0; i<N/2; i++) { 
			for(int j = 0; j<N/2; j++) {
				if(j==i)continue;
				sum1+=map[store[i]][store[j]];
				sum2+=map[another[i+1]][another[j+1]];
			}
		}
		return Math.abs(sum1-sum2);
	}

}
