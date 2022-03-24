package Silver;
import java.io.*;
import java.util.*;
public class BaekJoon2667 {
	public static int[][] arr;
	public static boolean[][] visit;
	public static int[] x = {-1,0,1,0};
	public static int[] y = {0,1,0,-1};
	public static Queue<int[]>Q = new LinkedList<>();
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		int N = Integer.parseInt(br.readLine());
		arr  = new int[N+1][N+1];
		visit  = new boolean[N+1][N+1];
		for(int i = 1; i<=N; i++) {
			str = br.readLine();
			for(int j= 1; j<=N; j++) {
				arr[i][j] = str.charAt(j-1)-'0';
			}
		}
		List<Integer> list = new ArrayList<>();
		for(int i = 1; i<=N; i++) {
			for(int j= 1; j<=N; j++) {
				if(arr[i][j]==1&&!visit[i][j]) {
					Q.offer(new int[] {i,j});
					int cnt = 0;
					visit[i][j] = true;
					while(!Q.isEmpty()) {
						cnt++;
						int ax = Q.peek()[0];
						int ay = Q.peek()[1];
						Q.poll();
						for(int k =0; k<4; k++) {
							int dx = ax+x[k];
							int dy = ay+y[k];
							if(dx<1||dx>N||dy<1||dy>N)continue;
							if(visit[dx][dy])continue;
							if(arr[dx][dy]==0)continue;
							Q.offer(new int[] {dx,dy});
							visit[dx][dy] = true;
						}
					}
					list.add(cnt);
				}
			}
		}
		
		Collections.sort(list);
		System.out.println(list.size());
		for(int i =0; i<list.size(); i++)System.out.println(list.get(i));
		
		
	}

}
