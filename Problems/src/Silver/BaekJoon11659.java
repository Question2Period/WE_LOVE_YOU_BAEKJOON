package Silver;
import java.io.*;
import java.util.*;
public class BaekJoon11659 {
	public static int[] arr;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		arr = new int[N+1];
		for(int i = 1; i<=N; i++)arr[i] = arr[i-1]+Integer.parseInt(st.nextToken());
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			System.out.println(arr[y]-arr[x-1]);
		}
	}

}
