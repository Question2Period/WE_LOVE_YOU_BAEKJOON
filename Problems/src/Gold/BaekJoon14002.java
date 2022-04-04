package Gold;
import java.io.*;
import java.util.*;
public class BaekJoon14002 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N+1]; //입력 수열
		int[] count = new int[N+1]; //길이 수열
		int max = 1;
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i<=N; i++)arr[i] = Integer.parseInt(st.nextToken());
		for(int i =1; i<=N; i++) {
			count[i] = 1;
			for(int j= 1; j<i; j++) {
				if(arr[i]>arr[j]) {
					if(count[i]<=count[j])count[i] = count[j]+1;
				}
				max = Math.max(max, count[i]);
			}
		}
		Stack<Integer> stack = new Stack<>();
		int value = max;

			for(int i = N; i>0; i--) {
				if(value==count[i]) {
					stack.push(arr[i]);
					value--;
				}
				
			}
			

		System.out.println(max);
		while(!stack.isEmpty())System.out.print(stack.pop()+" ");

		
		
	}

}
