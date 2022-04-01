package Gold;
import java.io.*;
import java.util.*;
public class BaekJoon2206 {
	public static int[] dx = {0,1,0};
	public static int[] dy = {1,0,-1};
	public static int flag;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N+1][M+1];
		int[][][] dp = new int[N+1][M+1][2];
		for(int i = 1; i<=N; i++) {
			String str = br.readLine();
			for(int j = 1; j<=M; j++) {
				int a = str.charAt(j-1)-'0';
				map[i][j] = a;
			}
		}
		Queue<int[]>Q = new LinkedList<>();
		Q.offer(new int[] {1,1,1});
		dp[1][1][0]= 1; // 벽안뚫은 최소거리
		dp[1][1][1]= 0; // 벽뚫은 최소거리
		while(!Q.isEmpty()) {
			int x = Q.peek()[0];
			int y = Q.peek()[1];
			int cnt = Q.peek()[2];
			if(x==N&&y==M) {
				System.out.println(cnt);
				flag=-1;
				break;
			}
			Q.poll();
			for(int i =0; i<3; i++) {
				int ax = x+dx[i];
				int ay = y+dy[i];
				if(ax<1||ax>N||ay<1||ay>M)continue;
				if(map[ax][ay]==0) {//빈공간			
					if(dp[x][y][1]!=0) {//이전에 벽뚫은 전적이 있다면
						dp[ax][ay][1]=cnt+1; 
						
					}
					else {//한번도 뚫은적 없다면
						dp[ax][ay][0]=cnt+1;
					}
					Q.offer(new int[] {ax,ay,cnt+1});
				}
				else {//벽
					if(dp[x][y][1]!=0)continue; //이전에 벽뚫은 전적이 있다면 더이상 못뚫으므로 그냥 진행		
					//한번도 뚫은적 없다면
					dp[ax][ay][1]=cnt+1;
					Q.offer(new int[] {ax,ay,cnt+1});
				}
			}
		}
		if(flag==0)System.out.println(-1);
	}

}
