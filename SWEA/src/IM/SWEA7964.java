package IM;
import java.io.*;
import java.util.*;
public class SWEA7964 {
	public static int city,distance,count,check;
	public static int[] PourEating;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T= Integer.parseInt(br.readLine());
		for(int t = 1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			city = Integer.parseInt(st.nextToken());//도시 수
			distance = Integer.parseInt(st.nextToken()); //제한거리
			PourEating = new int[city+1]; //차원관문 여부 배열
			count=0; // 설치 횟수
			st = new StringTokenizer(br.readLine());
			for(int i = 1; i<=city; i++)PourEating[i]=Integer.parseInt(st.nextToken());
			for(int j=1;j<=city-distance;j++) {
				check = 0;
				if(j==1&&PourEating[j]==0) { //첫 시작이 0일시
				for(int k = 1; k<=distance; k++) { //거리안에 1이 있는지 체크
					if(PourEating[j+k]==1) check++; //
				}
				if(check==0)PourEating[j]=1; //1이 없다면 시작을 1로 바꿔준다
				count++; // 설치 횟수+1
				}
				else { // 첫 시작 이후
					for(int k = 1; k<=distance; k++) { //거리 안 1이 있는지 체크
						if(PourEating[j+k]==1) { 
							check++;
							break;
						}
					}
					if(check==0) {PourEating[j+distance]=1; //하나도 없다면 제한 거리 만큼 떨어진 도시에 관문 설치
					count++;//설치 횟수 +1
					}
				}
			}
			System.out.println("#"+t+" "+count);
		}
	}

}
