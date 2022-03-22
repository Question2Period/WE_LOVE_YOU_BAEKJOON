package Silver;
import java.io.*;
import java.util.*;
public class BaekJoon11724 {
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		List<Integer>[]arr = new ArrayList[N+1];
		boolean[] visit = new boolean[N+1];
		for(int i = 0; i<=N; i++)arr[i] = new ArrayList<>();
		for(int i = 0; i<M; i++) {
			st  = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a].add(b);
			arr[b].add(a);
		}
		int count = 0;
		Queue<Integer>Q = new LinkedList<>();
		for(int i = 1; i<=N; i++) {
			if(visit[i])continue;
			Q.add(i);
			visit[i] = true;
			while(!Q.isEmpty()) {
				int cur = Q.poll();
				for(int j = 0; j<arr[cur].size(); j++) {
					int next= arr[cur].get(j);
					if(visit[next])continue;
					visit[next] =true;
					Q.add(next);
				}
			}
			count++;
		}
		System.out.println(count);
	}

}
