package Gold;
import java.io.*;
import java.util.*;
public class BaekJoon12865 {
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[] dp = new int[100010]; //dp의 인덱스는 무게. 그 원소는 그 무게에서 고를 수 있는 최대가치
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] arr = new int[2][100010];	
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[0][i] =  Integer.parseInt(st.nextToken()); //각 물건의 무게
			arr[1][i] =  Integer.parseInt(st.nextToken()); // 각 물건의 가치
		}
		for(int i =K-1; i>=0; i--) { //무게는 모두 1이상이므로 K-1kg부터 시작
			int x;
			for(int j = 0; j<N; j++) {
			if(i+arr[0][j]>K)x=-1000000; //최대 무게를 초과하므로 고르지않는다
			else x = dp[i+arr[0][j]]+arr[1][j]; //최대범위를 넘지 않으므로 선택했을 때 최대 가치 리턴
			dp[i] = Math.max(dp[i],x); //가장 최대인 가치를 i kg에 저장
			}
		}
		System.out.println(dp[0]); //무게가 0일때 고를수 있는 최대가치 출력
	}
}


