package Silver;
import java.io.*;
import java.util.*;
public class BaekJoon1427 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = br.readLine();
		Queue<Integer> pq = new PriorityQueue<>();
		for(int i = 0; i<str.length(); i++) {
			int index = str.charAt(i)-'0';
			pq.offer(index);
		}
		while(!pq.isEmpty()) {
			sb.append(pq.poll());
		}
		System.out.println(sb.reverse());
		
		
	}

}
