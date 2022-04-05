package Gold;
import java.io.*;
import java.util.*;
public class BaekJoon15961 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 접시 수
		int d = Integer.parseInt(st.nextToken()); // 초밥 가짓수
		int k = Integer.parseInt(st.nextToken()); // 연속 그릇
		int c = Integer.parseInt(st.nextToken()); // 쿠폰번호
		int max = -1;
		int[] dish = new int[N+k];
		int num = 0;
		HashSet<Integer> set;
		for(int i =0; i<N; i++)dish[i] = Integer.parseInt(br.readLine());
		for(int i =N; i<N+k; i++)dish[i] = dish[i-N];
		for(int i = 0; i<=N; i++) {
			set = new HashSet<>();
			set.add(c);
			for(int j = 0; j<k; j++) {
				set.add(dish[i+j]);
			}
			i=i+k-1;
			max = Math.max(set.size(), max);
		}
		System.out.println(max);
		
	}

}
