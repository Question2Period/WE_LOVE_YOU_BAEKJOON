package Silver;
import java.io.*;
import java.util.*;
public class BaekJoon10845 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String order = "";
		int num = 0;
		int count = 0;
		String str;
		Queue<Integer> Q = new ArrayDeque<>();
		int N = Integer.parseInt(br.readLine());
		for(int i =0; i<N; i++) {
			count = 0;
			str = br.readLine();
			if(str.length()>4&&str.charAt(4)==32) {
				st = new StringTokenizer(str);
				order = st.nextToken();
				num = Integer.parseInt(st.nextToken());
				Q.offer(num);
			}
			else if(str.equals("pop")) {
				if(Q.isEmpty()) {
					System.out.println(-1);
					continue;
				}
				System.out.println(Q.poll());
			}
			else if(str.equals("front")) {
				if(Q.isEmpty()) {
					System.out.println(-1);
					continue;
				}
				System.out.println(Q.peek());
			}
			else if(str.equals("back")) {
				if(Q.isEmpty()) {
					System.out.println(-1);
					continue;
				}
				while(count!=Q.size()-1) {
					Q.offer(Q.poll());
					count++;
				}
				System.out.println(Q.peek());
				Q.offer(Q.poll());
			}
			else if(str.equals("size")) {
				System.out.println(Q.size());
			}
			else {
				if(Q.isEmpty()) System.out.println(1);
				else System.out.println(0);
			}
		}
	}

}
