package Silver;
import java.io.*;
import java.util.*;
public class BaekJoon2961 {
	public static StringTokenizer st;
	public static int N;
	public static int S;
	public static int B;
	public static int Min;
	public static int MulS=1;
	public static int SumB;
	public static List<int[]> arr;
	public static int[] Sin;
	public static int[] Bitter;
	public static boolean[] Visited; 
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new ArrayList<>();
		Sin = new int[N];
		Bitter = new int[N];
		Visited = new boolean[N];
		for(int i = 0; i<N; i++) {
			st= new StringTokenizer(br.readLine());
			S = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			arr.add(new int[]{S,B});
		}
		difference(0,Integer.MAX_VALUE);
		System.out.println(Min);

	}
	public static void difference(int index,int Min) {
		if(index == N) {
			Min = Math.min(Math.abs(MulS-SumB),Min);
			MulS = 1;
			SumB = 0;
		}
		for(int i = 0; i< N; i++) {
			if(Visited[i]) continue;
			Visited[i] = true;
			MulS *= arr.get(i)[0];
			SumB += arr.get(i)[1];
			difference(index+1,Min);
			Visited[i] = false;
		}
	}
}
