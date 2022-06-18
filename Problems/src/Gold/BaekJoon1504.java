package Gold;
import java.io.*;
import java.util.*;
public class BaekJoon1504 {
	
	static class Node implements Comparable<Node>{
		int x;
		int d;
		public Node(int x,int d) {
			this.x = x;
			this.d = d;
		}
		public int compareTo(Node o) {
			return this.d-o.d;
		}
	}
	public static final int INF = 200000*1000;
	public static int N,E,a,b,c,v1,v2;
	public static List<Node>[] map;
	public static int[] dis;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		map = new ArrayList[N+1];
		for(int i = 0; i<=N; i++)map[i] = new ArrayList<>();
		for(int i = 0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			map[a].add(new Node(b,c));
			map[b].add(new Node(a,c));
		}
		st = new StringTokenizer(br.readLine());
		v1 = Integer.parseInt(st.nextToken());
		v2 = Integer.parseInt(st.nextToken());
		int way1 = dijstra(1,v1)+dijstra(v1,v2)+dijstra(v2,N);
		int way2 = dijstra(1,v2)+dijstra(v2,v1)+dijstra(v1,N);
		if(way1>=INF&&way2>=INF)System.out.println(-1);
		else System.out.println(Math.min(way1,way2));
	}
	
	public static int dijstra(int start,int end) {
		dis = new int[N+1];
		Arrays.fill(dis, INF);
		dis[start] = 0;
		Queue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start,0));
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			int cpoint = cur.x;
			int cdist = cur.d;
			if(cdist!=dis[cpoint])continue;
			for(int i =0; i<map[cpoint].size(); i++) {
				Node next = map[cpoint].get(i);
				int npoint = next.x;
				int ndist = next.d;
				if(dis[cpoint]+ndist>=dis[npoint])continue;
				dis[npoint] = dis[cpoint]+ndist;
				pq.offer(new Node(npoint, dis[npoint]));
			}
		}
		return dis[end];
	}

}
