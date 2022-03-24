package Silver;
import java.io.*;
import java.util.*;
public class BaekJoon1389 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		List<Integer>[] arr = new ArrayList[N+1];
		for(int i= 0; i<=N; i++)arr[i] = new ArrayList<>();
		for(int i= 0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a].add(b);
			arr[b].add(a);
		}
		int min = Integer.MAX_VALUE;
		int index = 0;
		for(int i = 1; i<=N; i++) {
		Queue<Integer> Q = new LinkedList<>();
		boolean[] visit = new boolean[N+1];
		Q.offer(i);
		visit[i] = true;
		int[] sum = new int[N+1];
		while(!Q.isEmpty()) {
			int cur = Q.poll();
			for(int j =0; j<arr[cur].size(); j++) {
				int a = arr[cur].get(j);
				if(visit[a])continue;
				visit[a] = true;
				sum[a] = sum[cur]+1;
				Q.offer(a);
			}		
		}
		int kevin = 0;
		for(int k=1; k<=N; k++)kevin+=sum[k];
		if(kevin<min) {
			min = kevin;
			index = i;
		}
		else if(kevin==min) {
			index=Math.min(index, i);
		}
		}
		System.out.println(index);
	}

}
