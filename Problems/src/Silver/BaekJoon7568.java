package Silver;
import java.io.*;
import java.util.*;
public class BaekJoon7568 { 

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int count = 0;
		int[] answer = new int[N+1];
		int[][] arr = new int[N+1][4];
		for(int i = 1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][1] = Integer.parseInt(st.nextToken()); //키
			arr[i][2] = Integer.parseInt(st.nextToken()); //몸무게
			arr[i][3] = i; //몸무게
		}
		Arrays.sort(arr, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				if(o1[1]==o2[1]) return o1[2]-o2[2];
				else return o1[1]-o2[1];
			}
		
		});

		for(int j=1; j<=N-1; j++) {
			count = 1;
			for(int k = j+1; k<=N; k++) {
				if(arr[j][2]<arr[k][2]&&arr[j][1]!=arr[k][1]) count++;
			}
			answer[arr[j][3]]=count;
		}
		answer[arr[N][3]]=1;
		for(int x = 1; x<=N; x++) System.out.print(answer[x]+" ");
	}

}

