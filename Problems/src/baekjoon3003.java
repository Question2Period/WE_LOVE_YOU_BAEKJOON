import java.util.*;
import java.io.*;

public class BaekJoon3003 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		st= new StringTokenizer(br.readLine());
		sb.append(1-Integer.parseInt(st.nextToken())+" ");
		sb.append(1-Integer.parseInt(st.nextToken())+" ");
		sb.append(2-Integer.parseInt(st.nextToken())+" ");
		sb.append(2-Integer.parseInt(st.nextToken())+" ");
		sb.append(2-Integer.parseInt(st.nextToken())+" ");
		sb.append(8-Integer.parseInt(st.nextToken())+" ");
		System.out.println(sb);
	}
}
