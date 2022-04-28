package Gold;
import java.io.*;
import java.util.*;
public class BaekJoon20955 {
	public static int n,m,u,v,count;
	public static int[] parent;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());//정점 개수
		m = Integer.parseInt(st.nextToken());//간선 개수
		parent = new int[n+1];
		for(int i = 1; i<=n; i++)parent[i] = i;
		for(int i = 0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			union(u,v);
		}
		
		Set<Integer> s = new TreeSet<>();
		for(int i= 1; i<=n; i++)s.add(find(i));
		System.out.println(count+s.size()-1);
	}
	
	public static void union(int x,int y) {
		x = find(x);
		y = find(y);
		if(x==y)count++;
		parent[x] = y;
	}
	
	public static int find(int x) {
		if(x==parent[x])return x;
		else return parent[x] = find(parent[x]);
	}

}
