package Gold;
import java.io.*;
import java.util.*;
public class BaekJoon15683 {
	public static int min,N,M,cnt;
	public static List<int[]> direction;//
	public static int[][]arr; //입력 배열
	public static int[][]ex; // 입력 배열 복사
	public static Queue<int[]>Q; //cctv 위치 담을 큐
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());//행
		M = Integer.parseInt(st.nextToken());//열
		arr = new int[N+1][M+1];
		for(int i =1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j =1; j<=M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]==0||arr[i][j]==6)continue;
			}
		}
		min = Integer.MAX_VALUE;
		direction = new ArrayList<>();
		for(int x = 1; x<=4;x++)
			for(int y = 1; y<=2; y++)
				for(int z = 1; z<=4; z++)
					for(int w = 1; w<=4; w++) {
						direction.add(new int[] {x,y,z,w});
					}
		for(int a = 0; a<128; a++) {
			cnt=0;
			Q = new LinkedList<>();
			ex = new int[N+1][M+1];
			for(int i =1; i<=N; i++)
				for(int j=1; j<=M; j++) {
					ex[i][j] = arr[i][j];
					if(arr[i][j]==0||arr[i][j]==6)continue;
					Q.offer(new int[] {i,j,arr[i][j]});
				}
			
				while(!Q.isEmpty()) {
					int x = Q.peek()[0];
					int y = Q.peek()[1];
					int TV = Q.peek()[2];
					Q.poll();
					switch (TV) {
					case 1:
						int a1 = direction.get(a)[0];
						cctv1(x,y,a1);
						break;
					case 2:
						cctv2(x,y,direction.get(a)[1]);
						break;
					case 3:
						cctv3(x,y,direction.get(a)[2]);
						break;
					case 4:
						cctv4(x,y,direction.get(a)[3]);
						break;
					case 5:
						cctv5(x,y);
						break;
					}
				}
			for(int i =1; i<=N; i++)
				for(int j=1; j<=M; j++) if(ex[i][j]!=-1)cnt++;			
			min = Math.min(cnt, min);
		}
		System.out.println(min);
	}

	public static void cctv1(int x, int y, int dir) {
		switch (dir) {
		case 1: //윗방향
			while(true) {
				int ax = x-1;
				if(ax<1)break;
				if(ex[ax][y]==6)break;
				if(ex[ax][y]<1) {
					ex[ax][y]=-1;
				}
				x=ax;
			}
			break;			
		case 2: //오른쪽
			while(true) {
				int ay = y+1;
				if(ay>M)break;
				if(ex[x][ay]==6)break;
				if(ex[x][ay]<1)ex[x][ay]=-1;
				y=ay;
			}
			break;
		case 3: //아래
			while(true) {
				int ax = x+1;
				if(ax>N)break;
				if(ex[ax][y]==6)break;
				if(ex[ax][y]<1)ex[ax][y]=-1;
				y=ax;
			}
			break;
		case 4:
			while(true) {//왼쪽
				int ay = y-1;
				if(ay<1)break;
				if(ex[x][ay]==6)break;
				if(ex[x][ay]<1)ex[x][ay]=-1;
				y=ay;
			}
			break;
		}
	}

	public static void cctv2(int x, int y, int dir) {
		switch (dir) {
		case 1:
			cctv1(x,y,1);
			cctv1(x,y,3);
			break;		
		case 2:
			cctv1(x,y,2);
			cctv1(x,y,4);
			break;
		}
	}

	public static void cctv3(int x, int y, int dir) {
		switch (dir) {
		case 1:
			cctv1(x,y,1);
			cctv1(x,y,2);
			break;			
		case 2:
			cctv1(x,y,2);
			cctv1(x,y,3);
			break;
		case 3:
			cctv1(x,y,3);
			cctv1(x,y,4);
			break;
		case 4:
			cctv1(x,y,4);
			cctv1(x,y,1);
			break;
		}
	}

	public static void cctv4(int x, int y, int dir) {
		switch (dir) {
		case 1:
			cctv1(x,y,1);
			cctv1(x,y,2);
			cctv1(x,y,3);
			break;		
		case 2:
			cctv1(x,y,2);
			cctv1(x,y,3);
			cctv1(x,y,4);
			break;				
		case 3:
			cctv1(x,y,3);
			cctv1(x,y,4);
			cctv1(x,y,1);
			break;		
		case 4:
			cctv1(x,y,4);
			cctv1(x,y,1);
			cctv1(x,y,2);
			break;
		}
	}

	public static void cctv5(int x, int y) {		
		cctv1(x,y,1); //상
		cctv1(x,y,2); //우
		cctv1(x,y,3); //하
		cctv1(x,y,4); //좌
	}

}
