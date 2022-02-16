package Bronze;
import java.io.*;
import java.util.*;
public class BaekJoon1592 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		int x = 0;
		int sum = 0;
		arr[0] = 1;
		while(arr[x]!=M) {
			if(arr[x]%2==0) {//짝수
				x-=L;
				if(x<0) x+=N;
				arr[x]++;
			}
			else if(arr[x]%2==1) {//홀수
				x+=L;
				if(x>N-1) x-=N;
				arr[x]++;
			}
		}
		for(int i = 0 ;i<N; i++) {
			sum+=arr[i];
		}
		System.out.println(sum-1);
	}

}
