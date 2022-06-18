package Gold;
import java.io.*;
import java.util.*;
public class BaekJoon4386 {

	static class point{
		double x;
		double y;
		int num;
		public point(double x, double y,int num) {
			this.x = x;
			this.y = y;
			this.num = num;
		}
	}
	
	static class Node implements Comparable<Node>{
		point a;
		point b;
		double r;
		public Node(point a, point b) {
			this.a = a;
			this.b = b;
			this.r = Math.sqrt(Math.pow(a.x-b.x, 2)+Math.pow(a.y-b.y, 2));
		}
		
		public int compareTo(Node o) {
			return (int) (this.r-o.r);
		}
	}



	public static int n;
	public static double nx,ny,sum;
	public static point[] arr;
	public static Queue<Node> pq;
	public static int[] parent;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		parent = new int[n+1];
		arr = new point[n+1];
		for(int i = 1; i<=n; i++)parent[i] = i;
		for(int i = 1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			nx = Double.parseDouble(st.nextToken());
			ny = Double.parseDouble(st.nextToken());
			arr[i] = new point(nx,ny,i);
		}
		pq = new PriorityQueue<>();
		for(int i = 1; i<=n; i++) {
			for(int j = i+1; j<=n; j++) {
				pq.offer(new Node(arr[i],arr[j]));
			}
		}
		int cnt = 0;
		while(!pq.isEmpty()) {
			if(cnt>n)break;
			
			Node cur = pq.poll();
			int p1 = cur.a.num;
			int p2 = cur.b.num;
			if(find(p1)==find(p2))continue;
			union(p1,p2);
			sum+=cur.r;
			cnt++;
		}
		System.out.printf("%.2f",sum);
		
	}
	
	public static int find(int p) {
		if(parent[p]==p)return p;
		else return parent[p] = find(parent[p]);	
	}
	
	public static void union(int p1, int p2) {
		p1 = find(p1);
		p2 = find(p2);
		int ax = Math.min(p1, p2);
		int ay = Math.max(p1, p2);
		parent[ax] = ay;
	}

}
