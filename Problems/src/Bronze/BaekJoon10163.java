package Bronze;
import java.io.*;
import java.util.*;
public class BaekJoon10163 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][]arr = new int[1002][1002];
		int sum = 0;
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i = 1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			for(int j = x1; j<x1+x2; j++) {
				for(int k = y1; k<y1+y2;k++) {
					arr[j][k]=i;

				}
			}
		}
		for(int i = 1; i<=N; i++) {
			for(int x = 0; x<1002; x++) {
				for(int y =0; y<1002; y++) {
					if(arr[x][y]==i) {
						sum+=i;
					}
				}
			}
			System.out.println(sum/i);
			sum = 0;
		}
	}

}
