package Gold;
import java.io.*;
import java.util.*;
public class BaekJoon1707 {
	public static int[] parent;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int i = 0; i<T; i++) {
			st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			parent = new int[V+1];
			for(int j = 1; j<=V; j++)parent[j] = j;
			for(int j = 0; j<E; j++) {
				st = new StringTokenizer(br.readLine());
				int A = Integer.parseInt(st.nextToken()); 
				int B = Integer.parseInt(st.nextToken()); 
			}
		}
		
		
	}

}
