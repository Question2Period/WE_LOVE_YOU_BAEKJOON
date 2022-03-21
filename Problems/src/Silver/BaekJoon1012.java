package Silver;
import java.io.*;
import java.util.*;
public class BaekJoon1012 {
	public static boolean[][] visit;
	public static int[]  row = {-1,0,1,0}; //상하좌우, 행
	public static int[]  col = {0,1,0,-1};//상하좌우, 열
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());//열
			int N = Integer.parseInt(st.nextToken()); //행
			int K = Integer.parseInt(st.nextToken()); //간선
			int[][] arr = new int[N][M];
			for(int i = 0; i<K; i++) {
				st = new StringTokenizer(br.readLine());
				int garo = Integer.parseInt(st.nextToken());
				int sero = Integer.parseInt(st.nextToken());
				arr[sero][garo]++;
			}
			int count = 0;
			visit = new boolean[N][M];
			Queue<int[]> Q = new LinkedList<>();
			for(int i = 0; i<N; i++) {
				for(int j= 0; j<M; j++) {
					if(visit[i][j]||arr[i][j]==0)continue;
					Q.add(new int[]{i,j});
					while(!Q.isEmpty()) {
						int x = Q.peek()[0];
						int y = Q.peek()[1];
						Q.poll();
						for(int k =0; k<4; k++) {
							int dx = x+col[k];
							int dy = y+row[k];
							if(dx<0||dx>N-1||dy<0||dy>M-1||arr[dx][dy]!=1)continue;
							if(visit[dx][dy])continue;
							Q.offer(new int[] {dx,dy});
							visit[dx][dy] = true;
						}
					}
					count++;
				}
				
			}
			System.out.println(count);
		}
	}
}
