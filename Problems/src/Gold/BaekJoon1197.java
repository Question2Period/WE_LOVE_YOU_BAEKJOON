package Gold;
import java.io.*;
import java.util.*;
public class BaekJoon1197 {
	
	static class Node implements Comparable<Node>{
		int x;
		int y;
		int d;
		public Node(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}
		public int compareTo(Node o) {
			return this.d-o.d;
		}
		
	}
	
	public static int V,E,A,B,C,sum;
	public static int[] road;
	public static Queue<Node> pq;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		road = new int[V+1];
		pq = new PriorityQueue<>();
		for(int i = 1; i<=V; i++)road[i] = i;
		for(int i = 0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			pq.offer(new Node(A,B,C));
		}
		int cnt = 0;
		for(int i = 0; i<E; i++) {
			Node cur = pq.poll();
			if(find(cur.x)==find(cur.y))continue;
			union(cur.x,cur.y);
			sum+=cur.d;
			if(cnt==V-1)break;
		}
		System.out.println(sum);
	}
	
	public static int find(int a) {
		if(a==road[a])return a;
		else return road[a] = find(road[a]);
	}
	
	public static void union(int a, int b) {
		a = find(a);
		b = find(b);
		int min = Math.min(a, b);
		int max = Math.max(a, b);
		road[max] = min;
	}

}
