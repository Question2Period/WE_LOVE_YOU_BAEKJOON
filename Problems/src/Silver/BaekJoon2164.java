package Silver;
import java.io.*;
import java.util.*;
public class BaekJoon2164 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> Q = new ArrayDeque<>();
		for(int i = 1; i<=N; i++) {
			Q.offer(i);
		}
		while(Q.size()!=1) {
			Q.poll();
			Q.offer(Q.poll());
		}
		System.out.println(Q.poll());
	}

}
