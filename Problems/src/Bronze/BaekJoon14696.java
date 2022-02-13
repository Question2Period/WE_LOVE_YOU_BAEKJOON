package Bronze;
import java.io.*;
import java.util.*;
public class BaekJoon14696 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][]count = new int[2*N][5];
		StringTokenizer st;
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			for(int j = 0; j<a; j++) {
				count[2*i][Integer.parseInt(st.nextToken())]++;
			}
			st = new StringTokenizer(br.readLine());
			int b = Integer.parseInt(st.nextToken());
			for(int k = 0; k<b; k++) {
				count[2*i+1][Integer.parseInt(st.nextToken())]++;
			}
			if(count[2*i][4]>count[2*i+1][4]) {
				System.out.println("A");
				continue;
			}
			else if(count[2*i][4]<count[2*i+1][4]) {
				System.out.println("B");
				continue;
			}
			else {
				if(count[2*i][3]>count[2*i+1][3]) {
					System.out.println("A");
					continue;
				}
				else if(count[2*i][3]<count[2*i+1][3]) {
					System.out.println("B");
					continue;
				}
				else {
					if(count[2*i][2]>count[2*i+1][2]) {
						System.out.println("A");
						continue;
					}
					else if(count[2*i][2]<count[2*i+1][2]) {
						System.out.println("B");
						continue;
					}
					else {
						if(count[2*i][1]>count[2*i+1][1]) {
							System.out.println("A");
							continue;
						}
						else if(count[2*i][1]<count[2*i+1][1]) {
							System.out.println("B");
							continue;
						}
						else {
							System.out.println("D");
							continue;
						}
					}
				}
			}

		}

	}

}
