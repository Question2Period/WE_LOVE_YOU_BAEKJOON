package Gold;
import java.io.*;
import java.util.*;
public class BaekJoon20040 {
	public static int[] parent;
	public static int n,m,a,b,flag;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		parent = new int[n];
		for(int i = 0; i<n; i++)parent[i] = i;
		for(int i = 0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			if(find(a)==find(b)) {
				System.out.println(i+1);
				flag = -1;
				break;
			}
			union(a,b);
		}
		if(flag==0)System.out.println(0);
	}
	
	public static void union(int x, int y) {
		x = find(x);
		y = find(y);
		parent[x] = y;
	}
	
	public static int find(int x) {
		if(x==parent[x])return x;
		else return parent[x] = find(parent[x]);
	}

}
