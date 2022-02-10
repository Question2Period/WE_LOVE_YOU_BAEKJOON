package Bronze;
import java.io.*;
import java.util.*;
/*
 구현 아이디어 : 2차원 배열을 이용하면 간단하게 풀 수 있다. 넉넉하게 101*101크기의 배열을 선언하고
 입력받은 좌표값을 기준으로 10*10만큼의 범위들을 기본 값인 0->1으로 변환해준다. 1로 바꿀때마다
 넓이를 받는 변수 sum에 1을 더해준다. 단, 다음번에 범위가 겹치는 것을 고려하여 if문으로 원소가 1이
 아닐 경우에만 변환 작업을 수행한다.
 */
public class BaekJoon2563 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[][] arr=new int[101][101]; // 흰 색종이
		int sum = 0;
		int N = Integer.parseInt(br.readLine()); // 좌표 갯수
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			 int x = Integer.parseInt(st.nextToken()); // x좌표
			 int y = Integer.parseInt(st.nextToken()); // y좌표
			 for(int j =0; j<10; j++) {
				 for(int k = 0; k<10; k++) {
					 if(arr[x+j][y+k]==0) { //배열의 원소가 0이면 1로 변환 후 넓이 sum에 +1
						 arr[x+j][y+k]=1;
						 sum++;
					 }
					 else {
						 continue; //조건없으면 넓이 겹치는걸 해결해 줄 수 없음.
					 }
				 }
			 }
		}
		System.out.println(sum); // 넓이 출력
		
	}

}