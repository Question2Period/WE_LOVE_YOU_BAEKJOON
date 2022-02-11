package Silver;
import java.io.*;
import java.util.*;
public class BaekJoon11899 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		Stack<Character> stack = new Stack<>();
		int count = 0;
		int sum = 0;
		for(int i = 0; i<str.length(); i++) {
			if(str.charAt(i)=='(') {
				stack.push('(');
				count++;
			}
			else {
				if(count<=0) {
				sum++;
				}
				else {
					count--;
					stack.pop();
				}
			}
		}
System.out.println(sum+count);
	}

}
