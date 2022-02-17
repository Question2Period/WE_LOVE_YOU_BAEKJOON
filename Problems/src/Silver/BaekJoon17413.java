package Silver;
import java.io.*;
import java.util.*;
public class BaekJoon17413 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=  new StringBuilder();
		String str = br.readLine();
		Stack<Character> stack = new Stack<>();
		for(int i = 0; i<str.length(); i++) {
			switch (str.charAt(i)) {
			case '<': 
				if(stack.isEmpty()) {
					stack.push('<'); 
					continue;
				}
				while(!stack.isEmpty()) {
					sb.append(stack.pop());
				}
				System.out.print(sb);
				sb.delete(0, sb.length());
				stack.push('<');
				break;
			case '>': 
				while(stack.peek()!='<') {
					sb.append(stack.pop());
				}
				sb.append(stack.pop());
				sb.reverse();
				sb.append(">");
				System.out.print(sb);
				sb.delete(0, sb.length());
				break;
			case 32 : 
				if(stack.get(0).equals('<')) {
					stack.push((char)32);
					continue;
				}
				while(!stack.isEmpty()) {
					sb.append(stack.pop());
				}
				sb.append(" ");
				System.out.print(sb);
				sb.delete(0, sb.length());
				break;			

			default: stack.push(str.charAt(i));
			break;
			}
		}
		if(!stack.isEmpty()) {
			while(!stack.isEmpty()) {
				sb.append(stack.pop());
			}
			System.out.print(sb);
		}
	}

}
