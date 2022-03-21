package Silver;
import java.io.*;
import java.util.*;
public class BaekJoon2606 {
	public static boolean[] visit;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int com = Integer.parseInt(br.readLine()); //전체 정점 수
		int net = Integer.parseInt(br.readLine()); // 전체 간선 수
		List<Integer>[] arr=new ArrayList[com+1];
		visit = new boolean[com+1];
		for(int i = 1; i<=com; i++)arr[i] = new ArrayList<>();
		for(int i = 0; i<net; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			arr[A].add(B);
			arr[B].add(A);
		}
		Queue<Integer> Q = new LinkedList<>();
		Q.offer(1);
		int cnt = -1;
		visit[1] =true;
		while(!Q.isEmpty()) {
			int cur = Q.poll(); //정점 번호
			cnt++;
			for(int i= 0; i<arr[cur].size(); i++) { //그 정점의 인접 정점수 만큼 반복
				int next = arr[cur].get(i); //인접 정점
				if(visit[next])continue;
				Q.add(next);
				visit[next] = true;
			}
		}
		System.out.println(cnt);
	}

}
