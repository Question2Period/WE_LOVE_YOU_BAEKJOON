package Silver;
import java.io.*;
import java.util.*;
public class BaekJoon10814 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[][]arr = new String[N+1][3];
		for(int i = 1; i<=N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String age = st.nextToken();
			String name = st.nextToken();
			arr[i][1] = age;
			arr[i][2] = name;
		
		}
		arr[0][1] = "0";
		Arrays.sort(arr, new Comparator<String[]>() {

			@Override
			public int compare(String[] o1, String[] o2) {
				// TODO Auto-generated method stub
				return Integer.parseInt(o1[1])-Integer.parseInt(o2[1]);
			}
			
		});
		
		for(int k = 1; k<=N; k++) {
			System.out.println(arr[k][1]+" "+arr[k][2]);
		}		
	}
}