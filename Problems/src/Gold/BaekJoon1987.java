package Gold;
import java.io.*;
import java.util.*;
public class BaekJoon1987 { //알파벳. 나중에 그래프?로 다시 풀어보자
	public static int[] Visited= new int[91]; // 사용한 알파벳인지 여부 체크 A(63)~Z(90)
	public static int[][] arr; // 입력 2차원 배열
	public static StringTokenizer st; 
	public static int R,C,Max;
	public static String str;

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken()); // 행
		C = Integer.parseInt(st.nextToken()); // 열
		arr = new int[R+1][C+1]; // 벽을 쳐주기위해 +1씩 해주었다(패딩)
		for(int i = 1; i<=R; i++) { // 배열 내용 채우기
			str = br.readLine();
			for(int j = 1; j<=C; j++) {
				arr[i][j] = str.charAt(j-1);
			}
		}
		Visited[arr[1][1]]++; // 시작 위치의 알파벳 사용 체크
		Max = Integer.MIN_VALUE; // 최대 이동 횟수
		recur(1,1,1); // (1,1)에서 출발하고 시작 위치도 카운트하므로 (1,1,1)로 재귀 호출
		System.out.println(Max); // 최대값 Max 출력
	}

	public static void recur(int y,int x, int cnt) { 
		if(y-1>=1 && Visited[arr[y-1][x]]==0) { //상
			Visited[arr[y-1][x]]++; //사용 체크
			recur(y-1,x,cnt+1); // 그다음 위치로 이동
			Visited[arr[y-1][x]]--; // 안된다면 사용한 횟수 차감
		}
		if(y+1<=R && Visited[arr[y+1][x]]==0) { // 하
			Visited[arr[y+1][x]]++; 
			recur(y+1,x,cnt+1);
			Visited[arr[y+1][x]]--;
		}
		if(x-1>=1 && Visited[arr[y][x-1]]==0) { //좌
			Visited[arr[y][x-1]]++;
			recur(y,x-1,cnt+1);
			Visited[arr[y][x-1]]--;
		}
		if(x+1<=C && Visited[arr[y][x+1]]==0) {//우
			Visited[arr[y][x+1]]++;
			recur(y,x+1,cnt+1);
			Visited[arr[y][x+1]]--;
		}
		if(cnt>Max) Max = cnt; //최댓값 비교
		return; // 종료
	}

}
