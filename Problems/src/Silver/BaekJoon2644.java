package Silver;
import java.io.*;
import java.util.*;
public class BaekJoon2644 {
	public static int first,last,CountryNumber,n,a,b,m,depth,answer;
	public static int[][] arr;
	public static int[] deep;
	public static Queue<Integer>queue = new ArrayDeque<>();
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine()); //정점 수
		st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken()); // 촌수타깃1
		b = Integer.parseInt(st.nextToken());// 촌수타깃2
		m = Integer.parseInt(br.readLine()); // 간선 수
		deep = new int[n+1];
		arr = new int[n+1][n+1]; //정점 행렬
		for(int i = 1;i<=m; i++ ) { //행렬 원소 입력. 양방향 그래프이다.
			st = new StringTokenizer(br.readLine());
			first = Integer.parseInt(st.nextToken());
			last = Integer.parseInt(st.nextToken());
			arr[first][last]=1;
			arr[last][first]=1;
		}
		bfs(new boolean [n+1],a); //깊이 우선탐색 수행
		if(deep[b]==0)System.out.println(-1);
		else System.out.println(deep[b]-1);
	}
	public static void bfs(boolean[] visited,int start) {
		queue.offer(start);
		visited[start] = true;
		deep[start] = 1;
		while(!queue.isEmpty()) {
			int current = queue.poll();
			for(int i = 1; i<=n; i++) {
				if(!visited[i] && arr[current][i]!=0) {
					queue.offer(i);
					visited[i] = true;
					deep[i]=deep[current]+1;
				}

			}			
		}
	}

}
