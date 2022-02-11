package Silver;
import java.io.*;
import java.util.*;
public class BaekJoon14465 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 신호등 개수
		int K = Integer.parseInt(st.nextToken()); // 연속했으면 하는 개수
		int B = Integer.parseInt(st.nextToken()); // 고장난 신호등 개수
		int[] arr = new int[N];
		for(int i = 0; i<B; i++) {
			arr[Integer.parseInt(br.readLine())-1]=1;
		}
		int p1 = 0;
		int p2 = K-1;
		if(K-1==0) {
			p2++;
		}
		int min = Integer.MAX_VALUE;

		while(p2!=N) {
			int sum = 0;
			for(int i = p1;i<=p2;i++) {
				sum+=arr[i];
			}
			if(sum<min) {
				min = sum;
			}
			p2++;
			p1++;
			
		}
		System.out.println(min);
	}

}
