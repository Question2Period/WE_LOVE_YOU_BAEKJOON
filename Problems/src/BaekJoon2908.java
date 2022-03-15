import java.io.*;
import java.util.*;
public class BaekJoon2908 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String A = st.nextToken();
		String B = st.nextToken();
		System.out.println(A.substring(A.length()-1, 0));
	}
}
