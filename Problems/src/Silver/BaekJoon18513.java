package Silver;
import java.io.*;
import java.util.*;
public class BaekJoon18513 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		TreeSet<Integer> set = new TreeSet<>();
		st = new StringTokenizer(br.readLine());
		Queue<Integer> Q = new LinkedList<>();
		long answer = 0;
		int dis = 1;
		for(int i= 0; i<N; i++) {
			int input = Integer.parseInt(st.nextToken());
			Q.offer(input);
			set.add(input);
		}
		exit : while(!Q.isEmpty()) {
			int time = Q.size();
			for(int i = 0; i<time; i++) {
				int cur = Q.poll();
				int left = cur-1;
				int right = cur+1;
				if(!set.contains(left)) {
					Q.offer(left);
					answer+=dis;
					set.add(left);
					if(--K==0)break exit;
				}
				if(!set.contains(right)) {
					Q.offer(right);
					answer+=dis;
					set.add(right);
					if(--K==0)break exit;
				}
			}
			dis++;
		}
		System.out.println(answer);
	}

}
