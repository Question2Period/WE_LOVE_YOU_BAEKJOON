import java.util.*;
public class Solution {
	public static int[][]arr;
	public static int stone,h,w,n; 
	public static String str; 
	public static int[] dx = {1,-1,1,0}; //하대각,상대각,좌우,상하
	public static int[] dy = {1,1,0,1};
	public static Queue<stones>Q = new LinkedList<>();
	public static int flag,count,countotal;
	    public int solution(int h, int w, int n, String[] board) {
		StringTokenizer st;
		arr = new int[h+1][w+1]; //바둑판
		for(int i = 1; i<=h;i++) {
			str = board[i-1];
			for(int j= 1; j<=w; j++) {
				stone = str.charAt(j-1)-'0';
				arr[i][j]=stone;
				if(stone==1)Q.offer(new stones(i,j)); //바둑돌이 놓인 위치 큐에 저장
			}
		}
		int answer = check(Q,h,w,n); //재귀
        return answer;
	}
	static int check(Queue<stones> Q,int h, int w, int n) { //승부 체크
		while(!Q.isEmpty()) { //모든 바둑알 체크시 종료
			stones a =  Q.poll(); // 바둑알 정보 가져오기
			int x = a.i; //바둑알의 바둑판 행 위치
			int y = a.j; // 바둑알의 바둑판 열 위치
			for(int i =0; i<4; i++) { //하대각,상대각,좌우,상하 체크
				flag=0;
				count = 0; //같은 바둑돌 개수 체크
				for(int j =1; j<=n-1; j++) {
					int nx = x+j*dx[i];
					int ny = y+j*dy[i];
					if(nx<1||nx>h||ny<1||ny>w)break;
					if(arr[nx][ny]!=1)break; //4칸내로 다른 색이거나 돌이 없으면 현재 방향 종료
					count++;//같은 돌 있을 시 개수 세기
				}
				if(count==n-1) {//현재방향으로 n목이 되었을 겨우
					flag = 1;
					int p = x-dx[i];
					int q = y-dy[i];
					if(p>=1&&p<=h&&q>=1&&q<=w)
						if(arr[p][q]==1) {//첫 돌의 뒤쪽 체크 - n+1목일시 초기화
							flag=0;
						}
					if(flag!=0) {
						p = x+n*dx[i];
						q = y+n*dy[i];
						if(p>=1&&p<=h&&q>=1&&q<=w)//마지막 돌의 앞쪽 체크- n+1목일시 초기화
							if(arr[p][q]==1) {
								flag=0;
							}
					}

				}
				if(flag==1)countotal++;
			}
		}
		return countotal; //승부 결과 반환
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