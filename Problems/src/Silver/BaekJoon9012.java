package Silver;
import java.io.*;
import java.util.*;
public class BaekJoon9012 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		Stack<Character> stack= new Stack<>();  
		for(int i = 0; i<T; i++) {
			String str = br.readLine(); 
			int flag = 0;
			for(int j = 0; j<str.length(); j++) {
				if(str.charAt(j)=='(') {
					stack.push('(');
				}
				else if(stack.empty()) {
					System.out.println("NO");
					flag++;
					break;
				}
				else {
					stack.pop();
				}	
			}
			if(stack.empty()&&flag==0) {
				System.out.println("YES");
			}
			else if(!stack.empty()&&flag==0){
				System.out.println("NO");
			}
			stack.clear();
		}

	}

}
