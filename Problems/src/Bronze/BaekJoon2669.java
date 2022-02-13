package Bronze;
import java.io.*;
import java.util.*;
public class BaekJoon2669 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][]arr = new int[101][101];
		int sum = 0;
		StringTokenizer st;
		for(int i = 0; i<4; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			for(int j = x1; j<x2; j++) {
				for(int k = y1; k<y2;k++) {
					if(arr[j][k]!=1) {
					arr[j][k]=1;
					sum++;
					}
				}
			}
		}

		System.out.println(sum);
		
		
	}

}
