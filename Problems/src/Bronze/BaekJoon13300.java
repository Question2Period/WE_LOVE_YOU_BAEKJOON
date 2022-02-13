package Bronze;
import java.io.*;
import java.util.*;

public class BaekJoon13300 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int room = 0;
		int[][] man = new int[7][2];
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			if(Integer.parseInt(st.nextToken())==0) {
				man[Integer.parseInt(st.nextToken())][0]++;
			}
			else {
				man[Integer.parseInt(st.nextToken())][1]++;
			}
		}
		for(int i =1; i<=6; i++) {
			for(int j = 0; j<2; j++) {
				room+=man[i][j]/K;
				if(man[i][j]%K!=0)
				room++;
			}
		}
		System.out.println(room);
	}

}
