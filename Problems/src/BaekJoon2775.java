import java.io.*;
public class BaekJoon2775 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int arr[][]= new int [15][15];
		for(int i = 0; i<15; i++) {
			arr[i][1]=1;
			arr[0][i]=i;
		}
			for(int i=1;i<15;i++) {
				for(int j = 2; j<15;j++) {
					arr[i][j]=arr[i-1][j]+arr[i][j-1];
				}
			}
			int T = Integer.parseInt(br.readLine());
			for(int i = 0; i<T; i++) {
				int k = Integer.parseInt(br.readLine());
				int n = Integer.parseInt(br.readLine());

				System.out.println(arr[k][n]);

			}


		}	

	}
	

