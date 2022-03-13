package Silver;
import java.io.*;
import java.util.*;
public class BaekJoon1966 {
	public static ArrayDeque<int[]>Q;
	public static ArrayDeque<int[]>Q2;
	public static int N,M,count;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t<T; t++) {
			Q = new ArrayDeque<>();
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i<N; i++) {
				int a = Integer.parseInt(st.nextToken());
				int[] temp = {a,i};
				Q.offer(temp);
			}
			count = 1;
			while(true) {
				Q2 = Q.clone();
				Q2.poll();
				while(!Q2.isEmpty()) {
					int x = Q2.peek()[0];
					int y = Q.peek()[0];
					if(x>y)break;
					Q2.poll();
				}
				if(Q2.isEmpty()) {
					int index = Q.poll()[1];
					if(index==M) {
						System.out.println(count);
						break;
					}
					count++;			
				}
				else {
					Q.offer(Q.poll());
				}			
			}
		}
	}

}
