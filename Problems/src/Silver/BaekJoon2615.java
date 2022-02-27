package Silver;
import java.io.*;
import java.util.*;
public class BaekJoon2615 {
	public static int[][]arr;
	public static int stone; 
	public static int[] dx = {1,-1,1,0}; //하대각,상대각,좌우,상하
	public static int[] dy = {1,1,0,1};
	public static Queue<stones>Q = new LinkedList<>();
	public static int flag,count,garo,sero;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		arr = new int[20][20]; //바둑판
		for(int i = 1; i<=19;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j= 1; j<=19; j++) {
				stone = Integer.parseInt(st.nextToken());
				arr[i][j]=stone;
				if(stone==1||stone==2)Q.offer(new stones(i,j)); //바둑돌이 놓인 위치 큐에 저장
			}
		}
		System.out.println(check(Q)); //재귀
		if(flag!=0)System.out.println(garo+" "+sero); //승부가 났을 시 출력
	}
	public static int check(Queue<stones> Q) { //승부 체크
		while(!Q.isEmpty()&&flag==0) { //모든 바둑알 체크 끝나거나 승부가 났을 경우 종료
			stones a =  Q.poll(); // 바둑알 정보 가져오기
			int x = a.i; //바둑알의 바둑판 행 위치
			int y = a.j; // 바둑알의 바둑판 열 위치
			for(int i =0; i<4; i++) { //하대각,상대각,좌우,상하 체크
				count = 0; //같은 바둑돌 개수 체크
				for(int j =1; j<=4; j++) {
					int nx = x+j*dx[i];
					int ny = y+j*dy[i];
					if(nx<1||nx>19||ny<1||ny>19)continue;
					if(arr[nx][ny]!=arr[x][y])break; //4칸내로 다른 색이거나 돌이 없으면 현재 방향 종료
					if(arr[nx][ny]==arr[x][y])count++;//같은 돌 있을 시 개수 세기
				}
				if(count==4) {//현재방향으로 오목이 되었을 겨우
					if(arr[x][y]==1) flag=1;//검은돌 : 1, 흰돌 :2로 설정		
					else flag = 2;
					garo = x;
					sero = y;
					int p = x-dx[i];
					int q = y-dy[i];
					if(p>=1&&p<=19&&q>=1&&q<=19)
						if(arr[p][q]==arr[x][y]) {//첫 돌의 뒤쪽 체크 - 6목일시 초기화
							garo =0;
							sero =0;
							flag=0;
						}
					if(flag!=0) {
						p = x+5*dx[i];
						q = y+5*dy[i];
						if(p>=1&&p<=19&&q>=1&&q<=19)//마지막 돌의 앞쪽 체크- 6목일시 초기화
							if(arr[p][q]==arr[x][y]) {
								garo =0;
								sero =0;
								flag=0;
							}
					}

				}
				if(flag==1||flag==2)break; //승부가 나면 탈출
			}
		}
		return flag; //승부 결과 반환
	}
}
class stones { //행,열 정보를 담기 위한 클래스
	int i;
	int j;
	public stones(int x, int y) {
		this.i = x;
		this.j = y;
	}
}