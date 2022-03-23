package Silver;
import java.io.*;
import java.util.*;
public class BaekJoon11725 {
	public static int N;
	public static int[] parent;
	public static boolean[] visit;
	public static List<Integer>[] arr;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		arr = new ArrayList[N+1];
		for(int i =1; i<=N; i++)arr[i] = new ArrayList<>();
		for(int i =1; i<N; i++ ) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a].add(b);
			arr[b].add(a);
		}
		parent = new int[N+1];
		visit = new boolean[N+1];
		dfs(1);
		for(int i = 2; i<=N; i++)System.out.println(parent[i]);
	}

	public static void dfs(int x) {
		visit[x] = true;
		for(int j= 0; j<arr[x].size(); j++ ) {
			int a = arr[x].get(j);
			if(visit[a])continue;
			visit[a] = true;
			parent[a] =x;
			dfs(a);
		}
	}

}
