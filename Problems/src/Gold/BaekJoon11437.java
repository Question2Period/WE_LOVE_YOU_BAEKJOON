package Gold;
import java.io.*;
import java.util.*;
public class BaekJoon11437 {
	public static int N,M;
	public static List<Integer>[] map;
	public static boolean[] visit;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new ArrayList[N+1];
		for(int i =0; i<=N; i++)map[i] = new ArrayList<>();
		for(int i = 0; i<N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			map[to].add(from);
		}
		M = Integer.parseInt(br.readLine());
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			visit = new boolean[N+1];
			dfs(n1);
			dfs(n2);
		}
	}
	
	public static void dfs(int cur) {
		if(visit[cur]) {
			System.out.println(cur);
			return;
		}
		visit[cur] = true;
		if(map[cur].size()==0)return;
		int next = map[cur].get(0);
		dfs(next);
		
	}

}
