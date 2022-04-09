package Gold;
import java.io.*;
import java.util.*;
public class BaekJoon2623 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());//정점 수
		int M = Integer.parseInt(st.nextToken());//간선 집합 수
		int[] degree = new int[N+1]; // 차수 저장 배열
		List<Integer>[] arr = new ArrayList[N+1]; // 인접리스트 선언
		for(int i =0; i<=N; i++)arr[i] = new ArrayList<>();
		
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int before = Integer.parseInt(st.nextToken()) ;// 이전 정점 저장
			for(int j = 0; j<num-1; j++) {
				int current = Integer.parseInt(st.nextToken());
				arr[before].add(current);//간선정보 저장
				degree[current]++; // 들어가는 쪽의 차수 증가
				before = current;//스왑
			}
		}
		Queue<Integer> Q = new LinkedList<>();
		for(int i = 1; i<=N; i++) {
			if(degree[i]==0)Q.offer(i);
		}
		ArrayList<Integer> result = new ArrayList<>();
		while(!Q.isEmpty()) {
			int cur = Q.poll();
			result.add(cur);
			for(int i= 0; i<arr[cur].size(); i++) {
				int next = arr[cur].get(i);
				degree[next]--;
				if(degree[next]==0)Q.offer(next);
			}
		}
		if(result.size()!=N)System.out.println(0);
		else {
			for(int i =0; i<result.size(); i++) {
				System.out.println(result.get(i));
			}
		}
		
		
		
	}

}
