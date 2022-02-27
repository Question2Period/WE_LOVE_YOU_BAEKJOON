package Regular;
import java.io.*;
import java.util.*;
public class A_20220227 {
	public static char a;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		String S = br.readLine();
		Stack<Character> stack = new Stack<>();
		if(N==1)System.out.println(S);
		else {
			stack.push(S.charAt(0));
			for(int i = 1; i<N; i++) {
				a = S.charAt(i);
				if(stack.peek()=='B') {
					if(a=='A') {
						stack.pop();
						stack.push(a);
						stack.push('B');
					}
					else if(a=='B') {
						stack.pop();
						stack.push('A');
					}
					else stack.push(a);
				}
				else stack.push(a);
			}
		}
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		System.out.println(sb.reverse());
	}

}
