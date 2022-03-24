package Silver;
import java.io.*;
import java.util.*;
public class BaekJoon1697 {
	public static int flag;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] arr = new int[100001];
		boolean[] visit = new boolean[100001];
		Queue<Integer> Q = new LinkedList<>();
		Q.offer(N);
		visit[N] = true;
		while(!Q.isEmpty()&&flag==0) {
			int x = Q.poll();

			int[] dx = {-1,1,x};
			for(int i=0; i<3; i++) {
				int ax = x+dx[i];
				if(ax<0||ax>100000)continue;
				if(visit[ax])continue;
				arr[ax] = arr[x]+1;
				visit[ax] = true;
				if(ax==K) {
					flag=1;
					break;
				}
				Q.offer(ax);
			}
			
		}
		System.out.println(arr[K]);
	}

}
