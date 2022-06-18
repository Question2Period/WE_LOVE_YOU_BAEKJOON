package Gold;
import java.io.*;
import java.util.*;
public class BaekJoon13913 {

	static class Node implements Comparable<Node>{
		int x;
		int d;
		public Node(int x, int d) {
			this.x = x;
			this.d = d;
		}
		
		public int compareTo(Node o) {
			return this.d-o.d;
		}
	}
	public static List<Node>[] map;
	public static int[] dis;
	public static int n,k;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());//시작
		k = Integer.parseInt(st.nextToken());//도착
		map = new ArrayList[100001];
		for(int i = 0; i<=100000; i++)map[i] = new ArrayList<>();
		for(int i = 0; i<=100000; i++) {
			int dx1 = i-1;
			int dx2 = i+1;
			int dx3 = 2*i;
			if(dx1>=0)map[i].add(new Node(dx1,1));
			if(dx2<=100000)map[i].add(new Node(dx2,1));
			if(dx3<=100000)map[i].add(new Node(dx3,0));
		}
		dis = new int[100001];
		Arrays.fill(dis, 111111);
		System.out.println(dijstra(n,k));
	}

	public static int dijstra(int start,int end) {
		dis[start] = 0;
		Queue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start,0));
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			int cx = cur.x;
			int cd = cur.d;
			if(cd!=dis[cx])continue;
			for(int i = 0; i<map[cx].size(); i++) {
				Node next = map[cx].get(i);
				int nx = next.x;
				int nd = next.d;
				if(dis[nx]<=dis[cx]+nd)continue;
				dis[nx] = dis[cx]+nd;
				pq.offer(new Node(nx,dis[nx]));
			}
		}
		
		return dis[end];
	}
	
}
