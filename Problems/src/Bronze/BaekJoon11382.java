package Bronze;
import java.io.*;
import java.util.*;
public class BaekJoon11382 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long a = 0;
		for(int i =0; i<3; i++)a+=Long.parseLong(st.nextToken());
		System.out.println(a);
	}

}
