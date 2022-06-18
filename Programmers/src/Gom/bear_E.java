package Gom;
import java.io.*;
import java.util.*;
public class bear_E {
	public static int N,M;
	public static List<Integer>[] map;
	public static boolean[] Ralo;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());//정점
		M = Integer.parseInt(st.nextToken());//간선
		map = new ArrayList[N+1];
		for(int i = 0; i<=N; i++)map[i] = new ArrayList<>();
		for(int i =0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			map[A].add(B);
		}
		int S = Integer.parseInt(br.readLine());
		Ralo = new boolean[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i =0; i<S; i++)Ralo[Integer.parseInt(st.nextToken())]=true;
		
		Queue<Integer> Q = new LinkedList<>();
		int flag = 0;
		Q.add(1);
		boolean Possible = true;
		boolean fans = false;
		if(Ralo[1])System.out.println("Yes");
		else if(map[1].size()==0)System.out.println("yes");
		else {
		while(!Q.isEmpty()) {
			Possible = false;
			fans = false;
			int cur = Q.poll();
			if(map[cur].size()==0)Possible = true;
			for(int i =0; i<map[cur].size(); i++) {
				int next = map[cur].get(i);
				if(Ralo[next]) {
					fans = true;
					continue;
				}
				Q.add(next);
				Possible = true;
			}
		}
		if(Possible&&!fans)System.out.println("yes");
		else System.out.println("Yes");
		}
		
	}

}
