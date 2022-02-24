package Gold;
import java.io.*;
import java.util.*;

public class BaekJoon7576 { //무조건 다시풀기. 왜 bfs인가? 토마토가 동시에 익기 때문->너비 우선
	static int[] dx = {-1,1,0,0,0,0};
	static int[] dy = {0,0,-1,1,0,0};
	static int x,y,z;
	static int[][] map;
	static boolean[][] visited;
	static Queue<dot> tomato = new LinkedList<dot>();
	static int day = 0;
	static boolean flag = true;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;
		st = new StringTokenizer(br.readLine());

		y = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());

		map = new int[x][y];
		visited = new boolean[x][y];

		for(int j=0; j<x; j++) {
			st = new StringTokenizer(br.readLine());
			for(int k=0; k<y; k++) {
				map[j][k] = Integer.parseInt(st.nextToken());
				if(map[j][k] == 1) {
					tomato.add(new dot(j,k));
				}
			}

		}

		while(true) {        
			bfs(tomato);
			if(!flag) {
				break;
			}
			day++;
		}
		check();
	}

	static void bfs(Queue<dot> tomato) {
		int size = tomato.size();

		for(int i=0; i<size; i++) {
			dot d = tomato.poll();
			int x1 = d.x;
			int y1 = d.y;

			for(int j=0; j<6; j++) {
				int x2 = x1 + dx[j];
				int y2 = y1 + dy[j];
				if( x2>=0 && x2<x && y2>=0 && y2<y && map[x2][y2] == 0) {
					map[x2][y2] = 1;
					tomato.add(new dot(x2,y2));
				}
			}
		}

		if(tomato.size() == 0) {
			flag = false;
			return;
		}
	}
	public static void check() {
		for(int j=0; j<x; j++) {
			for(int k=0; k<y; k++) {
				if(map[j][k] == 0) {
					System.out.println(-1);
					return;
				}
			}
		}
		System.out.println(day);
	}
}

class dot {
	int x;
	int y;

	public dot(int x,int y) {
		this.x = x;
		this.y = y;
	}
}