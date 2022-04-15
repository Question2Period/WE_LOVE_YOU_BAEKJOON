package Gold;
import java.io.*;
import java.util.*;
public class BaekJoon15681 {
	public static int N,R,Q,U,V;
	public static int[] sub;
	public static List<Integer>[] tree;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		tree = new ArrayList[N+1];
		sub = new int[N+1];
		for(int i = 1; i<=N; i++)tree[i] = new ArrayList<>();
		for(int i = 1; i<N; i++) { 
			st = new StringTokenizer(br.readLine());
			U = Integer.parseInt(st.nextToken());
			V = Integer.parseInt(st.nextToken());
			tree[U].add(V);
			tree[V].add(U);
		}
		dfs(R,-1);
		for(int i=0; i<Q; i++) {
			int ans = Integer.parseInt(br.readLine());
			System.out.println(sub[ans]);
		}
		
	}
	
	public static int dfs(int cur, int par) {
		sub[cur] = 1;
		for(int i = 0; i<tree[cur].size(); i++) {
			int nxt = tree[cur].get(i);
			if(nxt==par)continue;
			sub[cur]+=dfs(nxt,cur);
		}
		return sub[cur];
		
		
	}

}
