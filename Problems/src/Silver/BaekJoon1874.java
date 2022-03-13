package Silver;
import java.io.*;
import java.util.*;
public class BaekJoon1874 {
	public static int flag;
	public static int[] arr;
	public static Stack<Integer> stack;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		stack = new Stack<>();
		int x = 1;
		for(int i = 0; i<N; i++) arr[i] = Integer.parseInt(br.readLine());
		for(int i = 0; i<N; i++) {
			int a = arr[i];
			if(stack.isEmpty()) {
				stack.push(x++);
				sb.append("+\n");
			}
			while(a!=stack.peek()&&x<=N+1) {
				stack.push(x);
				sb.append("+\n");
				x++;
			}
			if(x>N+1) {
				flag=1;
				System.out.println("NO");
				break;
			}
			stack.pop();
			sb.append("-\n");
			
		}
		if(flag==0) {
		for(int i = 0; i<stack.size(); i++)System.out.println('-');
		System.out.println(sb);
		}
	}

}
