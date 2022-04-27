package Gold;
import java.io.*;
import java.util.*;
public class BaekJoon17352 {
	public static int N,a,b;
	public static int[] parent;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		parent = new int[N+1];
		for(int i = 1; i<=N; i++)parent[i] = i;
		for(int i = 0; i<N-2; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			union(a,b);
		}
		for(int i = 2; i<=N; i++) {
			if(find(1)!=find(i)) {
				System.out.println(1+" "+i);
				break;
			}
		}
	}

	public static void union(int x, int y) {
		x = find(x);
		y = find(y);
		parent[x] = y;
	}
	
	public static int find(int x) {
		if(parent[x]==x)return x;
		else return parent[x] = find(parent[x]);
	}
}
