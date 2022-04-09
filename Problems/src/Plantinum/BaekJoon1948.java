package Plantinum;
import java.io.*;
import java.util.*;
public class BaekJoon1948 {
	public static int [] dist; 
	public static int []in;
	public static int N,M;
	public static boolean visited[];
	public static class Node{
		int dest;
		int cost;
		public Node(){}
		public Node(int a,int b){
			dest = a;
			cost = b;
		}
	}
	public static ArrayList<Node> adj[];
	public static ArrayList<Node> inverse[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		in = new int[N+1]; //차수 배열
		dist = new int[N+1];//각 정점에서의 거리
		adj = new ArrayList[N+1];// 정방향 그래프
		inverse = new ArrayList[N+1];//역방향 그래프
		for(int i=1;i<=N;i++){
			adj[i] = new ArrayList<Node>();
			inverse[i] = new ArrayList<Node>();
		}
		M = Integer.parseInt(br.readLine());
		for(int i=0;i<M;i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());//시작 정점번호
			int end = Integer.parseInt(st.nextToken());//도착 정점번호
			int cost = Integer.parseInt(st.nextToken());//간선 가중치
			adj[start].add(new Node(end,cost)); 
			inverse[end].add(new Node(start,cost)); 
			in[end]++; //차수 증가
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(st.nextToken());
		int e= Integer.parseInt(st.nextToken());
		Queue<Node> q = new LinkedList<Node>(); 
		q.offer(new Node(s,0));
		exit:while(!q.isEmpty()){ //위상정렬로 거리 계산
			Node cur = q.poll();
			for(int i=0;i<adj[cur.dest].size();i++){
				Node next = adj[cur.dest].get(i);
				if(cur.cost + next.cost > dist[next.dest]){ // 최대값을 찾는 다익스트라
					dist[next.dest] = cur.cost + next.cost;
				}
				in[next.dest]--;
				if(in[next.dest]==0){//차수가 0이면 집어넣기
					q.offer(new Node(next.dest,dist[next.dest]));
					if(next.dest == e) break exit; //다음 정점이 끝일 경우 탈출
				}
			}
		}
		System.out.println(dist[e]);//최대 거리
        
		visited = new boolean[N+1];
		q = new LinkedList<Node>();
		q.offer(new Node(e,dist[e]));
		int ans = 0; //최대일때 사용한 노선 수
		while(!q.isEmpty()){
			Node cur = q.poll();
			if(visited[cur.dest])continue;//이미 방문한 정점
			visited[cur.dest] = true;
			if(cur.dest == s)break; // 시작정점에 돌아왔을 시 끝
			for(int i=0;i<inverse[cur.dest].size();i++){//역추적하면서 간선을 사용한 정점 찾기
				Node next = inverse[cur.dest].get(i);
				if(cur.cost - next.cost == dist[next.dest]){//정방향 다익때 선택된 정점이었을 경우
					ans++; // 간선수 증가
					q.offer(new Node(next.dest,cur.cost-next.cost));
				}
			}
		}
		System.out.println(ans);
	}

}