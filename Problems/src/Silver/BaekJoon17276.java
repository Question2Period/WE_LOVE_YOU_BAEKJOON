package Silver;
import java.io.*;
import java.util.*;
public class BaekJoon17276 {
	public static int[][] arr;
	public static int[][] copy;
	public static int T,n,d;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		for(int t = 0; t<T; t++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			arr = new int[n+1][n+1];
			copy = new int[n+1][n+1];
			for(int i = 1; i<=n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 1; j<=n; j++) {
					arr[i][j]=Integer.parseInt(st.nextToken());
					copy[i][j]=arr[i][j];
				}
			}
			if(d>=0)d/=45;
			else d=(d+360)/45;
			while(d-->0) {
				spin();
			}
			for(int i = 1; i<=n; i++) {
				for(int j = 1; j<=n; j++) {
					System.out.print(copy[i][j]+" ");
				}
				System.out.println();
			}
		}
	}
	public static void spin() {
		for(int i = 1; i<=n; i++) {
			for(int j = 1; j<=n; j++) {
				if(i==j)copy[i][j]=arr[n/2+1][j];
				else if(j==n/2+1)copy[i][j]=arr[i][i];
				else if(i+j==n+1)copy[i][j]=arr[i][n/2+1];
				else if(i==n/2+1)copy[i][j]=arr[n+1-j][j];
				else copy[i][j]=arr[i][j];
			}
		}
		for(int i = 1; i<=n; i++) {
			for(int j = 1; j<=n; j++) {
				arr[i][j]=copy[i][j];
			}
		}
	}
}
