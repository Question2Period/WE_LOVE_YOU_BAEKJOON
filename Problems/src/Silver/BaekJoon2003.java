package Silver;
import java.io.*;
import java.util.*;
public class BaekJoon2003 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		int M = Integer.parseInt(st.nextToken());
		st= new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
//		Arrays.sort(arr);
		int count = 0;
		int a = 0;
		int b = 0;
		int sum;
		while(a!=N&&b!=N) {
			sum = 0;
			for(int i =a;i<=b;i++) {
				sum+= arr[i];
			}
			if(sum<M) {
				b++;
			}
			else if(sum>M){
				a++;
			}
			else {
				count++;
				a++;
			}
		}
		System.out.println(count);
	}

}
