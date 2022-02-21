package Silver;
import java.io.*;
import java.util.*;

public class BaekJoon1260 { // 다음엔 인접 리스트로 풀어보자
	public static Queue<Integer> queue = new ArrayDeque<>();
	public static int to, from,N,M,V;
	public static boolean[] visited;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		visited = new boolean[N+1];
		int[][] arr = new int[N+1][N+1];
		for(int i =1; i<=M; i++) {
			st = new StringTokenizer(br.readLine());
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			arr[from][to]++;
			arr[to][from]++;
		}
		dfs(arr,new boolean[N+1],V);
		System.out.println();
//		bfs(arr,new boolean[N+1],V);
	}
	public static void dfs(int[][] x, boolean[] visited, int current) {
		visited[current] = true;
		System.out.print(current+" ");
		for(int i = 1; i<=N; i++) {
			if(!visited[i] && x[current][i]!=0) dfs(x,visited,i);
		}
	}

	public static void bfs(int[][] x,boolean[] visited,int start) {
		queue.offer(start);
		visited[start] = true;
		while(!queue.isEmpty()) {
			int current = queue.poll();
			System.out.print(current+" ");
			for(int i = 1; i<=N; i++) {
				if(!visited[i] && x[current][i]!=0) {
					queue.offer(i);
					visited[i] = true;
				}
			}
		}
	}



}


