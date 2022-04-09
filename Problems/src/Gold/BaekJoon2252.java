package Gold;
import java.io.*;
import java.util.*;
public class BaekJoon2252 {
	public static int N,M;
	public static List<Integer>[] arr;
	public static int[] degree;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new ArrayList[N+1];
		degree = new int[N+1];
		for(int i = 0; i<=N; i++)arr[i] = new ArrayList<>();
		for(int i =0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a].add(b); // a가 b앞에 있다
			degree[b]++;// 차수 올리기
		}
		Queue<Integer> Q = new LinkedList<>();
		
		for(int i= 1; i<=N; i++) {
			if(degree[i]!=0)continue;
			Q.offer(i); //차수가 0인 정점들을 모두 큐에 넣는다.
		}
		
		while(!Q.isEmpty()) {
			int cur = Q.poll();
			sb.append(cur+" ");
			for(int i = 0; i<arr[cur].size(); i++) {
				int next = arr[cur].get(i); // 현재 정점과 연결된 다음 정점
				degree[next]--;//진입차수 1감소
				if(degree[next]==0)Q.offer(next);
					//진입차수가 0이 되었다면 다시 큐에 넣는다.
			}
		}
		
		System.out.println(sb);
	}

}
