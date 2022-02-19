package Silver;
import java.io.*;
import java.util.*;
public class BaekJoon10866 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String order = "";
		int num = 0;
		int count = 0;
		String str;
		Deque<Integer> Q = new ArrayDeque<>();
		int N = Integer.parseInt(br.readLine());
		for(int i =0; i<N; i++) {
			count = 0;
			str = br.readLine();
			if(str.length()>9) {
				st = new StringTokenizer(str);
				order = st.nextToken();
				num = Integer.parseInt(st.nextToken());
				if(order.equals("push_front"))Q.offerFirst(num);
				else Q.offerLast(num);
			}
			else if(str.equals("pop_front")) {
				if(Q.isEmpty()) {
					System.out.println(-1);
					continue;
				}
				System.out.println(Q.poll());
			}

			else if(str.equals("pop_back")) {
				if(Q.isEmpty()) {
					System.out.println(-1);
					continue;
				}
				System.out.println(Q.pollLast());
			}
			else if(str.equals("size")) {
				System.out.println(Q.size());
			}
			else if(str.equals("empty")) {
				if(Q.isEmpty()) System.out.println(1);
				else System.out.println(0);
			}
			else if(str.equals("front")) {
				if(Q.isEmpty()) {
					System.out.println(-1);
					continue;
				}
				System.out.println(Q.peekFirst());
			}
			else {
				if(Q.isEmpty()) {
					System.out.println(-1);
					continue;
				}
				System.out.println(Q.peekLast());
			}
			
		}

	}

}
