package Silver;
import java.io.*;
import java.util.*;
public class BaekJoon11866 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		Queue<Integer> Q = new ArrayDeque<Integer>();
		if(N==1)System.out.println("<1>");
		else {
			for(int i = 1; i<=N;i++) {
				Q.offer(i);
			}
			while(Q.size()!=1) {
				for(int j = 1; j<K; j++) {
					Q.offer(Q.poll());
				}
				sb.append(Q.poll()+", ");

			}
			sb.append(Q.poll()+">");
			System.out.println(sb);
		}
	}
}
