import java.io.*;
import java.util.*;
public class SWEA1263 {
	public static int[][] map;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t<=T; t++) {
			int min = Integer.MAX_VALUE;
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 사람 수
			map = new int[N+1][N+1];
			for(int i = 1; i<=N; i++)
				for(int j = 1; j<=N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			
			for(int k = 1; k<=N; k++) { // 경유 정점
				for(int i = 1; i<=N; i++) { // 시작 정점
					if(map[i][k]==0)continue;
					for(int j= 1; j<=N; j++) { // 목표 정점
						if(map[k][j]==0||i==j)continue;
						if(map[i][j]==0)map[i][j] = map[i][k]+map[k][j]; // 직통 루트가 없다면
						else map[i][j]=Math.min(map[i][j], map[i][k]+map[k][j]); // 직접 가는 경로가 존재할 때
					}
				}
			}
			for(int i = 1; i<=N; i++) {
				int sum = 0;
				for(int j= 1; j<=N; j++) {
					sum+=map[i][j];
				}
				min = Math.min(min, sum);
			}
			
			
			sb.append("#"+t+" "+min+"\n");
		}
		System.out.println(sb);
	}

}
