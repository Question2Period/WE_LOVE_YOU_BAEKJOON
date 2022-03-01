package Usaco;
import java.io.*;
import java.util.*;
public class Bronze3 {
	public static int N,count,flag;
	public static String str;
	public static char index;
	public static char[][] arr;
	public static boolean[][] visited;
	public static boolean[] visitedx;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new char[4][6]; // 갖고있는 블록으로 2차원 배열을 채웠다
		for(int i = 0; i<4; i++) {
			str = br.readLine();
			for(int j = 0; j<6; j++) {
				index = str.charAt(j);
				arr[i][j] = index;
			}	
		}

		for(int i = 0; i<N; i++) {
			count=0; // 블록에 단어의 철자가 있으면 카운트
			visitedx = new boolean[4]; // 블록 방문 체크
			str = br.readLine();
			for(int j = 0; j<str.length(); j++) {
				flag = 0;
				index = str.charAt(j);
				for(int x =0; x<4; x++) {
					if(visitedx[x])continue; // 이미 방문한 행이라면 다음 행 검사
					for(int y= 0; y<6; y++) {
						if(index==arr[x][y]) { // 철자를 찾았을 때
							flag=-1; //분기를 위해 flag 변화
							count++; // 단어 철자가 있으므로 count+1
							visitedx[x] = true; // 이 행 방문처리
							break;
						}
					}
					if(flag==-1)break;
				}

			}
			if(count!=str.length())System.out.println("NO"); // 개수와 길이가 다르면 No
			else System.out.println("YES");
		}
	}
}
