import java.io.*;
import java.util.*;
public class SWEA7733 {
	public static int N,limit,max;
	public static int[][] map;
	public static int[] dx = {-1,0,1,0};
	public static int[] dy = {0,1,0,-1};
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t<=T; t++) {
			max = 0; //테스트케이스마다 최대값 초기화
			N = Integer.parseInt(br.readLine());
			map = new int[N+1][N+1];
			for(int i = 1; i<=N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j= 1; j<=N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					limit = Math.max(limit,map[i][j]); //최대개수를 미리 세줘서 100번까지 카운팅 x
				}
			}
			for(int i = 0; i<limit; i++) { 
				// map 최대값이 1일때 0일차를 고려안하면 max=0이 최대가되므로 0부터 시작
				max = Math.max(max, bfs(i)); //bfs한 결과값과 최대값 비교
			}
			sb.append("#"+t+" "+max+"\n");
		}
		System.out.println(sb);
	}
	
	public static int bfs(int a) {//bfs하면서 집합개수 반환
		int cnt = 0;//집합의 개수
		boolean[][] visit = new boolean[N+1][N+1];//방문처리
		for(int i = 1; i<=N; i++) {
			for(int j= 1; j<=N; j++) {
				if(map[i][j]<=a)continue; // 이미 먹힌 치즈는 방문x
				if(visit[i][j])continue; // 방문한 곳도 방문x
				cnt++; // 위 조건 통과시 집합 시작
				Queue<int[]> Q = new LinkedList<>();
				Q.offer(new int[] {i,j});
				visit[i][j] = true; // 큐에 넣어준 후 방문처리
				while(!Q.isEmpty()) { //bfs돌리기
					int x = Q.peek()[0];
					int y = Q.peek()[1];
					Q.poll();
					for(int k =0; k<4; k++) {
						int nx = x+dx[k];
						int ny = y+dy[k];
						if(nx<1||nx>N||ny<1||ny>N)continue; //범위 벗어날 시 무시
						if(visit[nx][ny])continue; // 방문시 재방문 불가
						if(map[nx][ny]<=a)continue; // 이미 먹힌 치즈 방문 x
						visit[nx][ny] = true; // 방문 체크
						Q.offer(new int[] {nx,ny}); // 큐에 다시 넣어준다
					}
				}
			}
		}
		return cnt;
	}
	
	

}
