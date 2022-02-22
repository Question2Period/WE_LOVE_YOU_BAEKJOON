package Graph;
import java.io.*;
import java.util.*;
public class SWEA3289 {
	public static int m,n,a,b,cal;
	public static int[] arr;
	public static StringBuilder sb;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t<=T; t++) {
			 sb= new StringBuilder();
			 sb.append("#"+t+" ");
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			arr=origin(new int[n+1]);
			for(int i = 0; i<m; i++) {
				st = new StringTokenizer(br.readLine());
				cal = Integer.parseInt(st.nextToken());
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				part(cal,a,b);
			}
			System.out.println(sb);
		}
	}
	static int[] origin(int[] x) {
		for(int i = 1; i<x.length; i++) {
			x[i]=i;
		}
		return x;
	}
	
	static void part(int order,int x, int y) {
		if(order==0) {
			arr[y] = arr[x];
		}
		else {
			if(arr[y]==arr[x]) sb.append(1);
			else sb.append(0);
		}
	}

}
