package Gold;
import java.io.*;
import java.util.*;
public class BaekJoon11779 {

	static class Node implements Comparable<Node>{
		int p;
		int distance;
		public Node(int p, int distance) {
			this.p = p;
			this.distance = distance;
		}
		@Override
		public int compareTo(Node o) {
			return this.distance-o.distance;
		}
	}
	public static List<Node>[] arr;
	public static List<Node>[] inverse;
	public static int[] distance;
	public static List<Integer> result;
	public static int N,M,start,end;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());//정점수
		M = Integer.parseInt(br.readLine());//간선수
		arr = new ArrayList[N+1];
		inverse = new ArrayList[N+1];
		for(int i =0; i<=N; i++)arr[i] = new ArrayList<>();
		for(int i =0; i<=N; i++)inverse[i] = new ArrayList<>();
		distance = new int[N+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		for(int i =0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			arr[from].add(new Node(to,dist));
			inverse[to].add(new Node(from,dist));
		}
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		distance[start] = 0;
		dijstra();
		System.out.println(distance[end]);
		result = new ArrayList<>();
		dijstra_inverse();
		System.out.println(result.size()+2);
		System.out.print(start+" ");
		for(int i =0; i<result.size(); i++)System.out.print(result.get(i)+" ");
		System.out.println(end);
	}
	
	public static void dijstra() {
		Queue<Node>pq = new PriorityQueue<>();
		pq.offer(new Node(start,0));
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			if(cur.distance!=distance[cur.p])continue;
			for(int i =0; i<arr[cur.p].size(); i++) {
				Node next = arr[cur.p].get(i);
				if(distance[next.p]<=distance[cur.p]+next.distance)continue;
				distance[next.p]=distance[cur.p]+next.distance;
				pq.offer(new Node(next.p,distance[next.p]));
			}
		}
	}
	
	public static void dijstra_inverse() {
		Queue<Node>pq = new PriorityQueue<>();
		pq.offer(new Node(end,distance[end]));
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			if(cur.distance!=distance[cur.p])continue;
			for(int i =0; i<inverse[cur.p].size(); i++) {
				Node next = inverse[cur.p].get(i);
				if(distance[next.p]<distance[cur.p]-next.distance)continue;
				if(distance[next.p]==distance[cur.p]-next.distance) {
					if(next.p==start)return;
					result.add(next.p);
					pq.offer(new Node(next.p,distance[next.p]));
					break;
				}
				
			}
		}
	}

}
