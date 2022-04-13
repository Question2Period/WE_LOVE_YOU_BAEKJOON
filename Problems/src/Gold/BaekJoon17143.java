package Gold;
import java.io.*;
import java.util.*;
public class BaekJoon17143 {

	static class shark{
		int x; //행 좌표
		int y; // 열좌표
		int velo; //속력
		int dir; // 상어방향
		int big; // 상어 가중치

		public shark(int x,int y,int velo,int dir,int big) {
			this.x = x;
			this.y = y;
			this.velo = velo;
			this.dir = dir;
			this.big = big;
		}
	}
	public static int row,column,m,r,c,s,d,z,sum;
	public static shark[][] map,temp;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		row = Integer.parseInt(st.nextToken());
		column = Integer.parseInt(st.nextToken());
		map = new shark[row+1][column+1]; // 원본 배열
		temp = new shark[row+1][column+1]; //복사할 배열
		m = Integer.parseInt(st.nextToken());
		for(int i = 0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			s = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			z = Integer.parseInt(st.nextToken());
			map[r][c] = new shark(r,c,s,d,z); // 원본 배열에 상어정보 넣기
		}
		fishing(); //낚시 시작
		System.out.println(sum); // 상어 가중치 합 출력
	}

	public static void fishing() {
		for(int i = 1; i<=column; i++) {//1번째 열부터 상어 수집
			sum+=getshark(i);//i번째 열의 가장 처음 만나는 상어의 가중치를 더해준다.
			if(i!=column)timeflow();//마지막 열에서 상어를 잡은 후에는 상어 이동을 해주지 않아도된다.
		}
	}

	public static void timeflow() {//1초 경과후 배열 변화 

		for(int i = 1; i<=row; i++) { 
			for(int j= 1; j<=column; j++) {
				if(map[i][j]==null)continue; //상어가 없다면 제외

				sharkmove(map[i][j]); // 상어 자리 찾기
			}
		}
		duplicate(); // 1초 후 변한 모든 상어 좌표의 움직임 변화를 반영한다
	}

	public static int getshark(int time) {//가장 가까운 상어 잡기
		int size = 0; // 상어가 없다면 0 반환
		for(int i = 1; i<=row; i++) {
			if(map[i][time]==null)continue; // 상어가없다면 다음 행 탐색
			size = map[i][time].big; // 최초 상어의 가중치 저장
			map[i][time]=null; // 잡았으니 null로 만들어 없애준다
			break;
		}
		return size;
	}

	public static void sharkmove(shark x) {//각 종류에따른 움직임
		
		int ndir = x.dir; //이동 후 방향
		int nbig = x.big; //가중치 비교용
		int d = x.velo; // 남은 이동거리
		int nx = x.x; // 이동 행 좌표
		int ny = x.y; // 이동 열 좌표
		if(d==0)return; // 속력이 0이라면 
			switch(ndir) {//현재 방향에 따라 다르게 처리
			case 1: //상
				d%=((row-1)*2); //2*(행or열-1)하면 위치와 방향 변함x
				if(d<=nx-1) {//남은 이동거리가 왕복이 아닐때
					nx-=d;//이동거리만큼 현재 좌표에서 빼준다
				}
				else if(d>nx-1+row-1) {//남은 이동거리동안 벽에 두번 부딪히는 경우(방향은 그대로)
					nx=row-(d-(nx-1+row-1));
				}
				else {//남은 이동거리동안 벽에 한번 부딪히는 경우(방향이 바뀐다)
					nx=1+(d-(nx-1));
					ndir = 2;
				}
				break;
			case 3://우
				d%=((column-1)*2); //2*(행or열-1)하면 위치와 방향 변함x
				if(d<=column-ny) {//남은 이동거리가 왕복이 아닐때
					ny+=d;
				}
				else if(d>column-ny+column-1) {//남은 이동거리동안 벽에 두번 부딪히는 경우(방향은 그대로)
					ny=1+(d-(column-ny+column-1));
				}
				else {//남은 이동거리동안 벽에 한번 부딪히는 경우(방향이 바뀐다)
					ny=column-(d-(column-ny));
					ndir = 4;
				}
				break;
			case 2://하
				d%=((row-1)*2); //2*(행or열-1)하면 위치와 방향 변함x
				if(d<=row-nx) {//남은 이동거리가 왕복이 아닐때
					nx+=d;
				}
				else if(d>row-nx+row-1) {//남은 이동거리동안 벽에 두번 부딪히는 경우(방향은 그대로)
					nx=1+(d-(row-nx+row-1));
				}
				else {//남은 이동거리동안 벽에 한번 부딪히는 경우(방향이 바뀐다)
					nx=row-(d-(row-nx));
					ndir = 1;
				}


				break;
			case 4://좌
				d%=((column-1)*2); //2*(행or열-1)하면 위치와 방향 변함x
				if(d<=ny-1) {//남은 이동거리가 왕복이 아닐때
				ny-=d;
				}
				else if(d>ny-1+column-1) {//남은 이동거리동안 벽에 두번 부딪히는 경우(방향은 그대로)
					ny=column-(d-(ny-1+column-1));
				}
				else {//남은 이동거리동안 벽에 한번 부딪히는 경우(방향이 바뀐다)
					ny=1+(d-(ny-1));
					ndir = 3;
				}
				break;
			}
		



		if(temp[nx][ny]!=null) { // 다른 상어가 있다면 큰상어가 작은 놈 먹어치움
			if(nbig>temp[nx][ny].big) {//기존의 상어보다 가중치가 크다면 값 갱신
				temp[nx][ny].velo  = x.velo;
				temp[nx][ny].big = nbig;
				temp[nx][ny].dir = ndir;
			}
		}
		else temp[nx][ny] = new shark(nx,ny,x.velo,ndir,nbig); //비어있다면 현재 상어 정보 넣기

	}

	public static void duplicate() { //temp배열->map배열
		for(int i = 1; i<=row; i++) { 
			for(int j= 1; j<=column; j++) {

				if(temp[i][j]==null) {
					map[i][j] = null;
					continue;
				}
				map[i][j] = new shark( temp[i][j].x,temp[i][j].y,temp[i][j].velo,temp[i][j].dir,temp[i][j].big);
			}
		}
		temp = new shark[row+1][column+1]; // 다음 계산을 위해 temp배열 초기화
	}

}

//for(int i = 1; i<=row; i++) {
//for(int j= 1; j<=column; j++) {
//	if(map[i][j]==null)continue; // 상어가없다면 제외. 널포인터 방지
//	if(map[i][j].velo==0)temp[i][j] = map[i][j];//속력이 0이면 미리 제자리에 넣는다.
//}
//}
//if(map[i][j].velo==0)continue;
//map[i][j] = temp[i][j];
