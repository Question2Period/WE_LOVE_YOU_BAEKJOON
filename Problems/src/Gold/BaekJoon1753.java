package Gold;
import java.util.*;
import java.io.*;


public class BaekJoon1753 {
    static int V,E,K,u,v,w;
    static int[] distance; // 시작정점에서 자신으로 오는 최소 비용
    static boolean[] visited; // 시작정점에서 자신으로 오는 최소 비용
    static ArrayList[] adjList;
    static class Vertex implements Comparable<Vertex>{
        int no; //정점의 번호
        int minDistance; //출발지에서 자신으로의 최소 비용
        public Vertex(int no, int minDistance) {
            super();
            this.no = no;
            this.minDistance = minDistance;
        }
        @Override
        public int compareTo(Vertex o) {
            // TODO Auto-generated method stub
            return this.minDistance - o.minDistance;
        }
        
    }

    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	StringTokenizer st;
    	st = new StringTokenizer(br.readLine());
    	V = Integer.parseInt(st.nextToken());
    	E = Integer.parseInt(st.nextToken());
    	K = Integer.parseInt(br.readLine());
 
        distance= new int[V+1];
        visited = new boolean[V+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        adjList = new ArrayList[V+1];
        for(int i = 1; i<=V; i++) {
        	adjList[i] = new ArrayList<Vertex>();
        }
        for(int i = 1; i<=E; i++) {
        	st = new StringTokenizer(br.readLine());
        	u = Integer.parseInt(st.nextToken());
        	v = Integer.parseInt(st.nextToken());
        	w = Integer.parseInt(st.nextToken());
        	adjList[u].add(new Vertex(v,w));
        }
        
        dijkstra(K);
        
        for(int j = 1; j<=V; j++) {
        	if(distance[j]==Integer.MAX_VALUE) sb.append("INF\n");
        	else sb.append(distance[j]+"\n");
        }
        System.out.println(sb);
        
        
    }
    
        static void dijkstra(int start) {                   
            PriorityQueue<Vertex> pq = new PriorityQueue<>();
            //distance 배열을 최대값으로 초기화 하기
            distance[start] = 0;
            pq.offer(new Vertex(start, distance[start]));           
            //모든 정점으로 연결되는 최소 비용구하기 위해서 정점 만큼 반복
            //중간에 목적지 도착하면 반복문 벗어나기
            //큐가 빌때까지 반복
            while(!pq.isEmpty()){
                //단계 1: 최소 비용이 확정되지 않은 정점 중에 최소 비용의 정점 선택
                Vertex cur = pq.poll();
                
                //큐에나 나온 정점이 이미 최소비용으로 처리가 된 경우에는 뽑아 온 정점은 무시한다.
                if(visited[cur.no]) {
                    continue;
                }
            	int len = adjList[cur.no].size();
            	for (int i = 0; i<len; i++) {
            		Vertex next = (Vertex) adjList[cur.no].get(i);
            		
            		// cost가 더 작을때만 갱신하고 PQ에 넣기
            		if (distance[next.no] > cur.minDistance + next.minDistance ) {
            			distance[next.no] = cur.minDistance + next.minDistance;
            			pq.offer(new Vertex(next.no, distance[next.no]));
            		}
            	}
                
            }

    }

}
