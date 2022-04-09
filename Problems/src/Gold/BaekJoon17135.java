package Gold;
import java.io.*;
import java.util.*;
public class BaekJoon17135 {
	public static int N,M,D,max;
	public static int[][] map;
	public static int[][] mapcopy;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());//행
		M = Integer.parseInt(st.nextToken());//열
		D = Integer.parseInt(st.nextToken());//거리제한
		map = new int[N+2][M+1];
		mapcopy = new int[N+2][M+1];
		for(int i = 1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j= 1; j<=M; j++) {
				mapcopy[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		archor(0,1);
		System.out.println(max);
	}
	
	public static void archor(int cur, int start) { //배열 N+1번 행 중 3자리에 궁수 넣기
		if(cur==3) {
			for(int i =1; i<=N+1;i++) 
				for(int j= 1; j<=M; j++) map[i][j] = mapcopy[i][j];
			//전투 시뮬레이션 돌릴 배열 복사
			max = Math.max(battle(), max); //각 위치마다 잡을 수 있는 최대 적 구하기
		}
		for(int i = start; i<=M; i++) { // 조합
			mapcopy[N+1][i]++;
			archor(cur+1,i+1);
			mapcopy[N+1][i]--;
		}
	}
	
	public static int battle() {
		int kills = 0; // 잡은 적의 수
		while(true) {
			if(checkfield())break;//필드에 적이 없을 경우 종료
			for(int i = 1; i<=M; i++) {
				if(map[N+1][i]==0)continue; // 궁수가 없는 타워일시 패스
				kills+=attack(N+1,i);//현재 궁수가 잡을 수 있는 값 찾아서 더해주기
			}
			pushed(); //모든 궁수가 화살 쏜 후 적 한칸씩 이동. 배열 1칸씩 아래로 밀기
		}
		
		return kills; 
	}
	
	public static boolean checkfield() { //필드에 적이 있는지 검사
		boolean TF = true;
		for(int i = 1;i<=N; i++) {
			for(int j= 1; j<=M; j++) {
				if(map[i][j]==1)TF= false;
				else if(map[i][j]==3)map[i][j]=0; //3으로 마킹해놓은 적 죽이기
				
			}
		}
		
		return TF;
	}
	
	public static int attack(int a,int b) {//실제 공격해서 제거
		int[] enemy = pick(a,b);
		int x = enemy[0];
		int y = enemy[1];
		if(x==-1&&y==-1)return 0;
		if(map[x][y]==1) {//최초 적 제거
			map[x][y]=3;//0으로 만들면 겹쳤을때 문제 생기므로 3으로 마킹
			return 1;//제거 횟수 카운트
		}
		else if(map[x][y]==3)return 0; // 이미 같은 적을 누군가 쐇으므로 카운트x
		else return 0; 
	}
	
	public static void pushed() {//배열 밀기~
		for(int i = N; i>=2; i--) {
			for(int j= 1; j<=M; j++) {
				map[i][j] = map[i-1][j];
			}
		}
		for(int i = 1;i<=M; i++)map[1][i] = 0;
	}
	
	public static int[] pick(int a,int b) {//죽일 적 고르기.현재 궁수의 위치 매개변수 
		int dist = 100000;
		int geti = -1;
		int getj = -1;
		for(int i =1;i<=N; i++) {
			for(int j = 1; j<=M; j++) {
				if(map[i][j]==0)continue; // 적이 없다면 지나친다.
				int si = getdistance(a,b,i,j); //거리 구해오기
				if(si>D)continue;//거리 제한보다 적이 멀리있으면 패스
				if(si<dist) {//거리가 더 짧을 경우 정보 갱신
				dist = si;
				geti =i;
				getj = j;
				}
				else if(si==dist) {//거리가 같은 경우
					if(j<getj) {//새로운 경우가 더 왼쪽에 있을 시 갱신
						geti = i;
						getj = j;
					}
				}
			}
		}
		
		return new int[] {geti,getj}; //제거 적의 위치 반환
		
	}
	
	public static int getdistance(int a,int b,int x, int y) {
		//적과의 거리. 매개변수는 궁수의 위치,거리 잴 적의 위치
		return (a-x)+Math.abs(b-y);
	}

}
