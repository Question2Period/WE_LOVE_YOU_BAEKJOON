package Gold;
import java.io.*;
import java.util.*;
public class BaekJoon2458 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());//학생수
		int M = Integer.parseInt(st.nextToken());//비교횟수
		int[][] map = new int[N+1][N+1];
		for(int i =0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a][b] = 1;
		}
		for(int k = 1; k<=N; k++) { // 경유 정점
			for(int i = 1; i<=N; i++) { // 시작 정점
				if(map[i][k]==0)continue;
				for(int j = 1; j<=N; j++) { //목표 정점
					if(map[k][j]==0||j==i)continue;//자기 자신이거나 경유-목표 없을시 스킵
					if(map[i][j]==0)map[i][j]=map[i][k]+map[k][j];
					else map[i][j] = Math.min(map[i][j], map[i][k]+map[k][j]);
				}
			}
		}
		
		int[] count = new int[N+1];
		for(int i = 1; i<=N; i++) { //열
			for(int j= 1; j<=N; j++) { //행
				if(i==j)continue;
				if(map[i][j]+map[j][i]!=0)count[i]++;
	}
}
		
		int cnt = 0;
		for(int i= 1; i<=N; i++)if(count[i]>=N-1)cnt++;
		System.out.println(cnt);
			
		
	}

}
