package Gold;
import java.io.*;
import java.util.*;
public class BaekJoon1717 {
	public static int n,m,a,b;
	public static int[] ancestor;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		ancestor = new int[n+1];
		for(int i = 0; i<=n; i++)ancestor[i] = i;
		for(int i = 0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int seq = Integer.parseInt(st.nextToken());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			switch (seq) {
			case 0:
				union(a,b);
				break;

			case 1:
				if(same(a,b))sb.append("YES\n");
				else sb.append("NO\n");
				break;
			}
		}
		System.out.println(sb);
	}
	
	public static void union(int x, int y) {
		int a = find(x);
		int b = find(y);
		ancestor[a] = b;
	}
	
	public static int find(int x) {
		if(ancestor[x]==x)return x;
		else return ancestor[x]=find(ancestor[x]);
	}
	
	public static boolean same(int x, int y) {
		if(find(x)==find(y))return true;
		else return false;
	}

}
