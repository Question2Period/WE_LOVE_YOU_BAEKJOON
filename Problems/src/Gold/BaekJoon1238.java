package Gold;
import java.io.*;
import java.util.*;
public class BaekJoon1238 {
	
	static class Node implements Comparable<Node>{
		int No;
		int cost;
		public Node(int No, int cost) {
			this.No = No;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.cost-o.cost;
		}
		
		
		
		
	}
	public static List<List<Node>> arr,come;
	public static int[] dist,dist_back;
	public static int N,M,X,back,Max;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		Max = Integer.MIN_VALUE;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); //정점의 개수
		int M = Integer.parseInt(st.nextToken()); //간선의 수
		int X = Integer.parseInt(st.nextToken()); //도착정점
		arr = new ArrayList<>();
		come = new ArrayList<>();
		for(int i = 0; i<=N; i++) {
			arr.add(new ArrayList<>());
			come.add(new ArrayList<>());
		}
		dist = new int[N+1];
		dist_back = new int[N+1];
		Arrays.fill(dist,Integer.MAX_VALUE);
		Arrays.fill(dist_back, Integer.MAX_VALUE);
		for(int i = 1; i<=M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			arr.get(start).add(new Node(end,cost));	
			come.get(end).add(new Node(start,cost));
		}
		dijstra(X,arr,dist);
		dijstra(X,come,dist_back);
		for(int i = 1; i<=N; i++) {
			Max = Math.max(dist[i]+dist_back[i], Max);
		}
		System.out.println(Max);
		
		
	}
	
	public static void dijstra(int point,List<List<Node>> map,int[] distance) {
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		pq.offer(new Node(point,0));
		distance[point] = 0;
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			int location = node.No;
			int cost = node.cost;
//			int look = distance[location];
//			int size = map.get(location).size();
			if(cost!=distance[location])continue;
			for(int i = 0; i<map.get(location).size(); i++) {
				Node dot = map.get(location).get(i);
//				int a = dot.No;
//				int b = dot.cost;
//				int c = distance[dot.No];
//				int d = distance[location]+dot.cost;
				if(distance[dot.No]<=distance[location]+dot.cost)continue;
				distance[dot.No] = distance[location]+dot.cost;
				pq.offer(new Node(dot.No,distance[dot.No]));
			}
		}
	}


}
