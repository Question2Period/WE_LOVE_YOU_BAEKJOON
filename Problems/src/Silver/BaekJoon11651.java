package Silver;
import java.io.*;
import java.util.*;
public class BaekJoon11651 {
	public static int[][] arr;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		arr = new int[N][2];
		for(int i =0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr, new Comparator<int[]>(){

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				if(o1[1]==o2[1])return o1[0]-o2[0];
				else return o1[1]-o2[1];
			}
		});
		for(int i = 0; i<N; i++) {
			System.out.print(arr[i][0]+" "+arr[i][1]);
			System.out.println();
		}
	}

}
