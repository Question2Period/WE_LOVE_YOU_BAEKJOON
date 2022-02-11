package Gold;
import java.io.*;
import java.util.*;
public class BaekJoon2467 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int p1 = 0;
		int p2 = N-1;
		int sum = 0;
		int answer1 = 0;
		int answer2 = 0;
		int min = Integer.MAX_VALUE;
		while(p1!=p2) {
			sum = arr[p1]+arr[p2];	
			if(sum>=0 ) {
				p2--;
				continue;
			}
			else if(sum<0) {
				p1++;
				continue;
			}
			if(Math.abs(sum)<Math.abs(min)) {
			min = sum;
			answer1 = p1;
			answer2 = p2;
			}

		}	
		System.out.print(arr[p1]+" "+arr[p2]);
	}

}
//else {
//	if(p1==p2) {
//		continue;
//	}
//	answer1 = p1;
//	answer2 = p2;
//	break;
//}
