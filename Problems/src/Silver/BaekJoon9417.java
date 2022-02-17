package Silver;
import java.io.*;
import java.util.*;
public class BaekJoon9417 {
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int temp = 0;
		int N = Integer.parseInt(br.readLine());
		int[] arr;
		for(int i = 0; i<N; i++) {
			int max = Integer.MIN_VALUE;
			st = new StringTokenizer(br.readLine());
			int M = st.countTokens();
			arr = new int[M];
			for(int j= 0; j<M; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			for(int k = 0; k<M-1; k++) {
				for(int z = 1; k+z<M; z++) {
					int a = Math.max(arr[k], arr[k+z]);
					int b = Math.min(arr[k], arr[k+z]);
					if(a%b==0) {max=Math.max(max, Math.abs(b)); continue;
					}
					while(a%b>0) {
						a%=b;
						temp = a;
						a = b;
						b = temp;
					}
					max = Math.max(max, Math.abs(b));
				}
			}
			System.out.println(max);
		}
	}

}
