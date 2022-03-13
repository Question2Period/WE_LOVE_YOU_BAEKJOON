package Silver;
import java.io.*;
import java.util.*;
public class BaekJoon1929 {
	public static boolean[] Visited;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		Visited = new boolean[N+1];
		Visited[0] = true;
		Visited[1] = true;
		for(int i = 2; i<=Math.sqrt(N+1); i++) {
			if(Visited[i])continue;
			for(int j=i*i; j<=N; j=j+i ) {
				Visited[j] = true;
			}
		}
		for(int i = M; i<=N; i++) {
			if(!Visited[i])System.out.println(i);
		}
	}
	

}
