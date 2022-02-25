package Silver;
import java.io.*;
import java.util.*;
public class BaekJoon1244 {
	public static int N,student,CastleStar,number,arraycount;
	public static int[] arr;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1]; //스위치 배열
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i<=N; i++) { //배열 입력
			arr[i]=Integer.parseInt(st.nextToken());
		}
		student = Integer.parseInt(br.readLine()); //학생 수
		for(int j = 0; j<student;j++ ) {
			st = new StringTokenizer(br.readLine());
			CastleStar = Integer.parseInt(st.nextToken()); //성별
			number = Integer.parseInt(st.nextToken()); //번호
			check(CastleStar,number);
		}
		for(int i=1; i<=N; i++) { //20개씩 나눠서 출력
			System.out.print(arr[i] + " ");
			if(i % 20 == 0)
				System.out.println();
		}		
	}
	
	public static void check(int MW, int num) { //반전
		int max = 0;
		switch (MW) {
		case 1: //남자일 때
			for(int i = 1;num*i<=N; i++) { //배수 반전
				if(arr[num*i]==1)arr[num*i]=0;
				else arr[num*i]=1;
			}
			break;

		case 2: // 여자일 때
			for(int i = 1; num-i>=1&&num+i<=N; i++) {
				if(arr[num-i]==arr[num+i]) { //좌우대칭 체크
					max = i;
					continue;
				}
				break;
			}
				for(int k = num-max; k<=num+max; k++) { //최대 좌우대칭 구간 모두 반전
					if(arr[k]==0)arr[k]=1;
					else arr[k]=0;
				}
			break;
		}
	}

}
