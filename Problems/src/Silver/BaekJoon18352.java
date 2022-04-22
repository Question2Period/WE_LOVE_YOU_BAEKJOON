package Silver;
import java.io.*;
import java.util.*;
public class BaekJoon18352 {

	static class Node implements Comparable<Node>{
		int p;
		int dis;
		
		public Node(int p, int dis) {
			this.p = p;
			this.dis = dis;
		}
		public int compareTo(Node o) {
			return this.dis-o.dis;
		}
	}
	
	public static int n,m,k,x,a,b;
	public static List<Integer>[] map;
	public static int[] dist;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());//정점 수
		m = Integer.parseInt(st.nextToken());//간선 수
		k = Integer.parseInt(st.nextToken());//가중치 값
		x = Integer.parseInt(st.nextToken());//시작 정점
		dist = new int[n+1];
		map = new ArrayList[n+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		for(int i = 0; i<=n; i++)map[i] = new ArrayList<>();
		for(int i = 0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			map[a].add(b);
		}
		
		dijstra();
		StringBuilder sb = new StringBuilder();
		int num = 0;
		for(int i =1; i<=n; i++) {
			if(dist[i]==k) {
				sb.append(i+"\n");
				num++;
			}
		}
		if(num!=0)System.out.println(sb);
		else System.out.println(-1);
		
	}
	
	public static void dijstra() {
		Queue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(x,0));
		dist[x] = 0;
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			int p = cur.p;
			int d = cur.dis;
			if(d!=dist[p])continue;
			for(int i =0; i<map[p].size(); i++) {
				int next = map[p].get(i);
				if(dist[next]<=dist[p]+1)continue;
				dist[next] = dist[p]+1;
				pq.offer(new Node(next,dist[next]));
			}
		}
	}

}
