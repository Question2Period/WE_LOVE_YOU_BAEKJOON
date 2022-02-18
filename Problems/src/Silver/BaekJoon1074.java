package Silver;
import java.io.*;
import java.util.*;
public class BaekJoon1074 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); //배열 크기
		int r = Integer.parseInt(st.nextToken()); //행
		int c = Integer.parseInt(st.nextToken()); //열
		int used = 0; //편의를 위해 2의 승수를 받을 변수
		int answer = 0; // 정답 위치의 수
		while(N>1) { // 2*2 배열 크기까지 검색범위가 감소하면 탈출
			used = (int)Math.pow(2,N-1);
			if(r>=0 && r<=used-1 && c>=0 && c<=used-1) { //1사분면
				
			}
			else if(r>=0 && r<=used-1 && c>=used && c<=used*2-1) {//2사분면
				c-=used; // 탐색 범위 사분면의 범위로 변경
				answer+=(int)Math.pow(2, 2*N-2); // 사분면의 첫 원소를 더해줌 
			}
			else if(r>=used && r<=used*2-1 && c>=0 && c<=used-1) {//3사분면
				r-=used;
				answer+=(int)Math.pow(2, 2*N-2)*2;
			}
			else{//4사분면
				r-=used;
				c-=used;
				answer+=(int)Math.pow(2, 2*N-2)*3;
			}
			N--; // 배열의 크기 N-1
		}
		//배열의 크기가 2*2가 되었을때
		if(r==0 && c==1) { //0행 1열 : 1
			answer+=1;
		}
		else if(r==1 && c==0) { // 1행 0열 : 2
			answer+=2;
		}
		else if(r==1 && c==1) { // 1행 1열 : 3
			answer+=3;
		}
		System.out.println(answer);
	}

}
