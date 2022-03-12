package Beginner;
import java.io.*;
import java.util.*;

public class C_20220312 {
	public static int flag;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][3];
			
			for(int i= 0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				arr[i][0] = Integer.parseInt(st.nextToken()); //x축
				arr[i][1] = Integer.parseInt(st.nextToken()); // y축
			}
			String str = br.readLine();
			for(int j = 0; j<N; j++) arr[j][2] = str.charAt(j);
			Arrays.sort(arr, new Comparator<int[]>(){

				@Override
				public int compare(int[] o1, int[] o2) {
					// TODO Auto-generated method stub
					if(o1[1]==o2[1]) return o1[0]-o2[0];
					else return o1[1]-o2[1];
				}
			});
			for(int i = 0; i<N&&flag==0; i++) {
				int x = arr[i][1];
				int d = arr[i][2];
				if(d=='L')continue;
				while(true) {
					i++;
					if(i>N-1)break;
					if(arr[i][1]!=x) {
						i--;
						break;
					}
					if(arr[i][2]=='L') {
						System.out.println("Yes");
						flag=-1;
						break;
					}
				}
			}
			if(flag==0)System.out.println("No");
	}

}
//A와 B 각각 서로 다른 정수의 수열?
// 조건 1: 같은 자리에 같은 숫자가 나타나게?
// 조건 2 : 다른 자리에 같은 숫자가 나타나게
