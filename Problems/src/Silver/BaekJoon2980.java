package Silver;
import java.io.*;
import java.util.*;
public class BaekJoon2980 { //도로와 신호등 실버 4

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); //신호등 개수
		int L = Integer.parseInt(st.nextToken()); // 도로 길이
		int time = 0; // 소요 시간
		int[][] arr = new int[N][3]; //신호등 정보 담을 배열
		for(int i = 0; i<N; i++) { // 2차원 배열 원소 입력
			st= new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			arr[i][2] = Integer.parseInt(st.nextToken());
		}
		if(arr[0][0]<arr[0][1]) {
			time = arr[0][1];
		}
		else {
			time = arr[0][0];
		}
		//첫 신호등 위치가 빨간불의 주기보다 크면 신호등 위치를 더해주고, 아니라면 그 주기를 더해줍니다.
		for(int i = 1; i<N; i++) { // 2번째 신호등부터 반복-조건문
			time+=(arr[i][0]-arr[i-1][0]); // 먼저 이전 신호등과의 거리만큼 시간에 더해줍니다.
			if(time%(arr[i][1]+arr[i][2])>=arr[i][1]) {
				continue;
			}
			else {
				time+=(arr[i][1]-time%(arr[i][1]+arr[i][2]));
			}
			//현재 소요 시간이 i번째 신호등의 빨간불 주기라면 남은 빨간불 시간 만큼 time에 더해주고 
			//파란불 주기라면 더하지 않고 지나갑니다.
		}
		System.out.println(time+L-arr[N-1][0]); 
		// 신호등이 없으므로 이전 시간에 (전체 도로길이 - 마지막 신호등 위치)를 더해줍니다
	}

}
