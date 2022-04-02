package Gold;
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
public class BaekJoon2206{
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); //행
		int M = Integer.parseInt(st.nextToken()); // 열
		int flag=0; //탈출불가 여부 체크
		int[][] map = new int[N][M]; // 미로
		int[][] dis = new int[N][M]; // 미로
		for(int i = 0; i<N; i++) 
			for(int j = 0; j<M; j++) 
				dis[i][j] = Integer.MAX_VALUE;

		
		int[] dx = {-1,0,1,0}; //되돌아가는 것은 최소가 될 수 없으므로 윗방향 제외
		int[] dy = {0,1,0,-1};
		boolean[][] visit = new boolean[N][M]; //방문체크 배열. [][][0]번째는 벽안뚫은 방문, [][][1]은 벽뚫은 방문

		for(int i = 0; i<N; i++) {
			String str = br.readLine();
			for(int j = 0; j<M; j++) {
				int a = str.charAt(j)-'0';
				map[i][j] = a;
			} // 미로 만들기
		}
		Queue<int[]>Q = new LinkedList<>();
		Q.offer(new int[] {0,0,1,0}); //행 좌표, 열 좌표, 이동거리, 벽붕괴횟수
		visit[0][0]= true; // 첫 출발은 무조건 빈공간이므로 0,0번쨰 방문체크
		while(!Q.isEmpty()) {
			int x = Q.peek()[0]; // 현재 행 좌표
			int y = Q.peek()[1]; // 현재 열 좌표
			int cnt = Q.peek()[2];//현재 좌표의 최소거리
			int crash = Q.peek()[3];//벽 붕괴여부.
			Q.poll();
			for(int i =0; i<4; i++) {
				int ax = x+dx[i]; 
				int ay = y+dy[i];
				if(ax<0||ax>N-1||ay<0||ay>M-1)continue; //범위 밖일시 제외
				if(dis[ax][ay]<=cnt+1)continue;
				if(map[ax][ay]==0) {//빈공간			
					if(visit[ax][ay])continue; // 방문한 적 있다면 제외
					visit[ax][ay] = true;
					dis[ax][ay] = cnt+1;
					Q.offer(new int[] {ax,ay,cnt+1,crash}); //거리를 1칸 늘려주고 다시 큐에 담기
				}
				else {//벽
					if(crash==1)continue; //이전에 벽 뚫은 적이 있거나 방문한 적 있다면 제외		
					//한번도 뚫은적 없다면
					visit[ax][ay]=true;
					dis[ax][ay]=cnt+1;
					Q.offer(new int[] {ax,ay,cnt+1,crash+1}); //거리,뚫은 횟수 증가시키고 다시 큐에 담기
				}

			}
		}
		if(dis[N-1][M-1]==Integer.MAX_VALUE)System.out.println(-1);
		else System.out.println(dis[N-1][M-1]);
	}

}