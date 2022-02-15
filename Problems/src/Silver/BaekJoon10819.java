package Silver;
import java.io.*;
import java.util.*;
public class BaekJoon10819 {
	public static int N;
	public static int Max;
	public static int Sum;
	public static StringTokenizer st;
	public static int[] arr;
	public static int[] arr1;
	public static boolean[] visited;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		visited = new boolean[N];
		arr = new int[N];
		arr1 = new int[N];
		for(int i = 0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		recur(0);
		System.out.println(Max);
	}
	public static void recur(int index) {
		if(index==N) {
			for(int j = 0; j<N-1; j++) {
				Sum+=Math.abs(arr1[j]-arr1[j+1]);
			}
			if(Sum>Max) {
				Max = Sum;
			}
			Sum = 0;
			return;
		}
		for(int i = 0; i<N; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			arr1[index] = arr[i];
			recur(index+1);
			visited[i] = false;
		}
	}
}
