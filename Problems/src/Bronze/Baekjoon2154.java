package Bronze;
import java.io.*;
public class Baekjoon2154 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<=N; i++) {
			sb.append(i);
		}
		for(int i = 0; i<sb.length();i++) {
			if(sb.substring(i,(N+"").length()+i).equals(N+"")) {
				System.out.println(i);
				break;
			}
		}
	}

}
