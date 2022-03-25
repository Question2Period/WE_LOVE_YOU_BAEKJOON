package Gold;
import java.io.*;
import java.util.*;
public class BaekJoon16562 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] relative = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i =1; i<=N; i++)relative[i] = Integer.parseInt(st.nextToken());
		ArrayList<Integer>[] arr = new ArrayList[N+1];
		for(int i =0; i<=N; i++)arr[i] = new ArrayList<>();
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			arr[A].add(B);
			arr[B].add(A);
		}
		Queue<Integer> Q = new LinkedList<>();
		boolean[] visit = new boolean[N+1];
		int sum = 0;
		for(int i = 1; i<=N; i++) {
			if(visit[i])continue;
			int min = relative[i];
			Q.offer(i);
			visit[i] = true;
			while(!Q.isEmpty()) {
				int cur = Q.poll();
				for(int j = 0; j<arr[cur].size(); j++) {
					int next = arr[cur].get(j);
					if(visit[next])continue;
					visit[next] = true;
					min = Math.min(min, relative[next]);
					Q.offer(next);
				}
			}
			sum+=min;
		}
		
		if(sum<=k)System.out.println(sum);
		else System.out.println("Oh no");
	}

}
