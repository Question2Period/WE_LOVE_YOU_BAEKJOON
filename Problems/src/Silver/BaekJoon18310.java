package Silver;
import java.io.*;
import java.util.*;
public class BaekJoon18310 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int sum = 0;
		int temp = 0;
		int Min = Integer.MAX_VALUE;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i =0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sum+=arr[i];
		}
		Arrays.sort(arr);
		sum/=N;
		for(int i = 0; arr[i]<sum+1; i++) {
			for(int j = 0; j<N;j++) {
				temp+=Math.abs(arr[j]-arr[i]);
			}
			if(temp<Min) {
				Min = temp;
			}
			temp = 0;
		}
		System.out.println(Min);
	}

}
