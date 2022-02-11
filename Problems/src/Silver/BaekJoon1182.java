package Silver;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class BaekJoon1182 {
	public static int N;
	public static int M;
	public static int [] arr = new int[110];
	static boolean []visited  = new boolean[110];
	public static void recur(int cur, int size){
		if(cur == N){
			for(int i=0; i<N; i++){
				System.out.print(arr[i] + " ");
			}
			System.out.println("");
			return ;
		}
		for(int i=0;i<size;i++){
			if(visited[i]){
				continue; //사용중 이라면 건너뜀
			}
			arr[cur] = i;
			visited[i] = true; //사용중인지
			recur(cur+1,size);
			visited[i] = false; //출력이 되었다면 해제
		}

	}
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		for(int i = 1; i<=N; i++) {
		recur(0,i);
		}
	}
}