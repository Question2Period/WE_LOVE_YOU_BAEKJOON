package Silver;
import java.io.*;
import java.util.*;
public class BaekJoon17219 {
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		TreeMap<String,String> map = new TreeMap<>();
		for(int i =0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			map.put(st.nextToken(), st.nextToken());
		}
		for(int i = 0; i<M; i++) {
			String str = br.readLine();
			sb.append(map.get(str)).append("\n");
		}
		System.out.println(sb);
	}

}
