package Silver;
import java.io.*;
import java.util.*;
public class BaekJoon1446 {
	
	static class Node implements Comparable<Node>{
		int x; //정점 번호
		int cost;//가중치
		public Node(int x, int cost) {
			this.x = x;
			this.cost = cost;
		}		
		public int compareTo(Node o) { // 가중치 오름차순 정렬
			return this.cost-o.cost;
		}		
	}	
	public static List<Node>[] map;
	public static int[] dist;
	public static int N,D,from,to;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		dist = new int[D+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		map  = new ArrayList[D+1];
		for(int i = 0; i<=D; i++)map[i] = new ArrayList<>();
		for(int i = 0; i<D; i++)map[i].add(new Node(i+1,1));
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if(to>D)continue; //도착 지점이 범위벗어날시 제외
			if(c>to-from)continue; // 지름길이 아니므로 제외
			map[from].add(new Node(to,c));
		}
		System.out.println(dijstra());
	}	
	public static int dijstra() {
		Queue<Node> pq = new PriorityQueue<>(); //우선순위 큐 구현
		dist[0] = 0;
		pq.offer(new Node(0,0));
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			int x = cur.x;
			int cost = cur.cost;
			if(cost!=dist[x])continue;
			for(int i = 0; i<map[x].size(); i++) {
				int nx = map[x].get(i).x;
				int ncost = map[x].get(i).cost;
				if(nx>D)continue;
				if(dist[nx]<=dist[x]+ncost)continue;
				dist[nx] = dist[x]+ncost;
				pq.offer(new Node(nx,dist[nx]));
			}
		}
		return dist[D];
	}
}
