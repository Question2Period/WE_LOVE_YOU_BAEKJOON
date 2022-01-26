import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
public class BaekJoon2798 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		int[] arr=new int[N];
		for(int i = 0; i<N; i++) {
			arr[i]=Integer.parseInt(st1.nextToken());
		}
		Arrays.sort(arr);
		int sum = arr[0] + arr[1] + arr[2];
		for(int j = 0; j<N-2;j++) {
			for(int k = j+1; k<N-1; k++) {
				for(int x =k+1;x<N;x++ ) {
					if(arr[j]+arr[k]+arr[x]<=M&&arr[j]+arr[k]+arr[x]>sum) {
						sum = arr[j]+arr[k]+arr[x];
					}
				}
	
			}
		}
		System.out.println(sum);
	}

}
