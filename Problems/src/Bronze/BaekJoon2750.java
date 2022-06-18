package Bronze;
import java.io.*;
import java.util.*;
public class BaekJoon2750 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> pq = new PriorityQueue<>();
		for(int i = 0; i<N; i++) {
			pq.offer(Integer.parseInt(br.readLine()));
		}
		while(!pq.isEmpty())sb.append(pq.poll()).append("\n");
		System.out.println(sb);
	}

}
