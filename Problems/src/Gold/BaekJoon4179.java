package Gold;
import java.io.*;
import java.util.*;
public class BaekJoon4179 {
	public static int[] dx = {-1,0,1,0};
	public static int[] dy = {0,1,0,-1};
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int[][] map = new int[R+1][C+1]; // 사용 맵
		
		Queue<int[]> human = new LinkedList<>();
		Queue<int[]> htemp = new LinkedList<>();
		
		Queue<int[]> fire = new LinkedList<>();
		Queue<int[]> ftemp = new LinkedList<>();
		for(int i = 1; i<=R; i++) {
			String str = br.readLine();
			for(int j = 1; j<=C; j++) {
				char a = str.charAt(j-1);
				if(a=='#')map[i][j] = -1; //벽
				else if(a=='J') {
					human.offer(new int[] {i,j});
					map[i][j] = 1; // 방문
				}
				else if(a=='F') {
					fire.offer(new int[] {i,j});
					map[i][j] = -4; // 불
				}
			}
		}
		int flag=0;
		outer : while(true) {
			while(!human.isEmpty()) {
				int x = human.peek()[0];
				int y = human.peek()[1];
				human.poll();
				if(map[x][y]==-4)continue; // 지금 있는 자리에 이미 불이 있다면 실패
				if(x==1||x==R||y==1||y==C) {//가장 자리 도착
					flag=map[x][y];
					break outer;
				}
				for(int i = 0; i<4; i++) {
					int nx = x+dx[i];
					int ny = y+dy[i];
					if(nx<1||nx>R||ny<1||ny>C)continue; // 범위 벗어나면 불가
					if(map[nx][ny]!=0)continue; //다음 지역이 불이나 벽이면 이동불가
					map[nx][ny]=map[x][y]+1;
					htemp.offer(new int[]{nx,ny});
				}
			}
			if(htemp.isEmpty())break;
			while(!htemp.isEmpty()) {
				human.offer(htemp.poll());
			}
			
			while(!fire.isEmpty()) {
				int x = fire.peek()[0];
				int y = fire.peek()[1];
				fire.poll();
				for(int i = 0; i<4; i++) {
					int nx = x+dx[i];
					int ny = y+dy[i];
					if(nx<1||nx>R||ny<1||ny>C)continue; // 범위 벗어나면 불가
					if(map[nx][ny]==-4||map[nx][ny]==-1)continue; //다음 지역이 불이나 벽이면 이동불가
					map[nx][ny]=-4;
					ftemp.offer(new int[]{nx,ny});
				}
			}
			while(!ftemp.isEmpty()) {
				fire.offer(ftemp.poll());
			}
		}
		if(flag==0)System.out.println("IMPOSSIBLE");
		else System.out.println(flag);
		
		
		
	}

}
