package Silver;
import java.io.*;
import java.util.*;
public class BaekJoon4949 {
	public static Stack<Character> stack;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		while(true) {
			stack = new Stack<>();
			int flag = 0;
			str = br.readLine();
			if(str.equals("."))break;
			for(int i = 0; i<str.length()&&flag==0; i++) {
				char a = str.charAt(i);
				switch (a) {
				case '(':
				case '[':
					stack.push(a);
					break;

				case ']' : 
					if(stack.isEmpty()||stack.peek()!='[') {
						System.out.println("no");
						flag=-1;
					}
					else stack.pop();
					break;
				case ')' : 
					if(stack.isEmpty()||stack.peek()!='(') {
						System.out.println("no");
						flag=-1;
					}
					else stack.pop();
					break;
				}
			}
			if(flag==-1)continue;
			if(stack.isEmpty())System.out.println("yes");
			else System.out.println("no");
		}

	}
}
