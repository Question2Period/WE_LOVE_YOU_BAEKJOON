package Silver;
import java.util.*;
import java.io.*;
public class BaekJoon10773 {
	public static Stack<Integer> stack = new Stack<>();
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int sum = 0;
		for(int i = 0; i<N; i++) {
			int x = Integer.parseInt(br.readLine());
			if(x==0)stack.pop();
			else stack.push(x);
		}
		while(!stack.isEmpty()) {
			sum+=stack.pop();
		}
		System.out.println(sum);
	}

}
