package Graph;
import java.io.*;
import java.util.*;
public class SWEA7465 {
	public static int N,M,LiverLineX,LiverLineY,count;
	public static int[][] arr;
	public static List<Integer> list;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int t= 1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			count = 0;
			arr = new int[N+1][N+1];
			 list= new ArrayList<>();
			for(int k = 1; k<=N; k++) list.add(k);
			for(int i = 0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				LiverLineX = Integer.parseInt(st.nextToken());
				LiverLineY = Integer.parseInt(st.nextToken());
				arr[LiverLineX][LiverLineY]=1;
				arr[LiverLineY][LiverLineX]=1;
			}
			for(int j =1; j<=N; j++) {
			dfs(arr,new boolean[N+1],j);
			if(list.isEmpty()&&j!=1) break;
			count++;
			}
			if(!list.isEmpty())count+=list.size();
			System.out.println("#"+t+" "+count);
		}
	}
	public static void dfs(int[][] x, boolean[] visited, int current) {
		visited[current] = true;
		if(list.contains(current))list.remove(list.indexOf(current));
		for(int i = 1; i<=N; i++) {
			if(!visited[i] && x[current][i]!=0) dfs(x,visited,i);
		}
	}

}
