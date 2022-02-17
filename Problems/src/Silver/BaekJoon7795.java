package Silver;
import java.io.*;
import java.util.*;
public class BaekJoon7795 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int[] arr1;
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t<T; t++) {
			int sum = 0;
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			arr1 = new int[N];
			int M = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i<N; i++) {
				arr1[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			Arrays.sort(arr1);
			for(int x = 0; x<M; x++) {
				int a = Integer.parseInt(st.nextToken());
				int b = Arrays.binarySearch(arr1, a);
				if(b>=0) {
					sum+=(N-b-1);
					int z =b;
					b++;
					while(b!=N&&arr1[b]==arr1[z]) {
						sum--;
						b++;
					}

				}
				else {
					sum+=(N+b+1);
				}
			}
			System.out.println(sum);
		}
	}

}
