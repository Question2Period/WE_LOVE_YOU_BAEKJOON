package Gold;
import java.io.*;
import java.util.*;
public class BaekJoon18116 {
	public static int[] parent = new int[1000001];
	public static int[] count = new int[1000001];
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		Arrays.fill(count, 1);
		for(int i = 1; i<=1000000; i++)parent[i] = i;
		for(int i =0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			String order = st.nextToken();
			int a = Integer.parseInt(st.nextToken());
			if(order.equals("I")) {
			int b = Integer.parseInt(st.nextToken());
			union(a,b);
			}
			else {
				sb.append(count[find(a)]).append("\n");
			}
		}
		System.out.println(sb);
		
	}
	
	public static void union(int x,int y) {
		x = find(x);
		y = find(y);
		if(x==y)return;
		parent[x] = y;
		count[y]+=count[x];
	}
	
	public static int find(int x) {
		if(x==parent[x]) return x;
		else return parent[x] = find(parent[x]);
	}
	

}
