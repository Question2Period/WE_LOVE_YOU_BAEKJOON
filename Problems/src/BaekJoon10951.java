import java.io.*;
import java.util.*;
public class BaekJoon10951 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String str;
		while((str=br.readLine())!=null) {
			st = new StringTokenizer(str);
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());	
			System.out.println(a+b);
	}

	}
}
