package Gold;
import java.io.*;
import java.util.*;
public class BaekJoon1967 {
	public static int n,start,max;
	public static boolean[] visit;
	public static List<int[]>[] tree;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		tree = new ArrayList[n+1];
		for(int i =0; i<=n; i++)tree[i] = new ArrayList<>();
		for(int i = 0; i<n-1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			tree[a].add(new int[] {b,cost});//양방향 간선
			tree[b].add(new int[] {a,cost});
		}
		max =-1;
		dfs(1,-1,0);
		max =-1;
		dfs(start,-1,0);
		System.out.println(max);
		
	}
	
	public static void dfs(int cur,int parent,int dis) {
		if(dis>max) {
			max = dis;
			start = cur;
		}
		for(int i= 0; i<tree[cur].size(); i++) {
			int[] next = tree[cur].get(i);
			if(next[0]==parent)continue;
			dfs(next[0],cur,dis+next[1]);
		}
	}

}
