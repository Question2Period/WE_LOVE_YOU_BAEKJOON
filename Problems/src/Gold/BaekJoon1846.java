package Gold;
import java.io.*;
import java.util.*;
public class BaekJoon1846 {
	public static StringBuilder sb;
	public static int N,flag;
	public static int[][] map;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		map = new int[N+1][N+1];
		dfs(1,1,0);
//		for(int i =1; i<=N; i++) {
//			for(int j = 1; j<=N; j++) {
//				if(map[i][j]==1)sb.append(j+"\n");
//			}
//		}
//		if(sb.length()==0)System.out.println(-1);
//		else System.out.println(sb);
		if(sb.length()==0)System.out.println(-1);
		else System.out.println(sb);
	}

	public static void dfs(int x,int y,int cnt) {
		int checkR =0;//행체크
		int checkC =0;//열체크
		for(int i = 1; i<=N; i++) {
			if(map[i][i]==1)return;
			if(map[i][N+1-i]==1)return;
			checkR+=map[x][i];
			checkC+=map[i][y];
			if(checkR>1||checkC>1)return;
		}
		if(cnt==N) {
			if(flag==0)
			for(int i =1; i<=N; i++) {
				for(int j = 1; j<=N; j++) {
					if(map[i][j]==1)sb.append(j+"\n");
				}
			}
			flag=1;
			return;
		}
		for(int i =1; i<=N; i++) {
			for(int j= 1; j<=N; j++) {
				if(map[i][j]==1)continue;
				map[i][j] = 1;
				dfs(i,j,cnt+1);
				map[i][j] = 0;
			}
		}
	}
}
