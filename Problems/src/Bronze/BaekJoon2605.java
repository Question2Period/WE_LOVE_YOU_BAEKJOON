package Bronze;
import java.io.*;
import java.util.*;
public class BaekJoon2605 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<Integer> list = new ArrayList<>();
		list.add(-1);
		StringTokenizer st= new StringTokenizer(br.readLine());
		for(int i = 1; i<=N; i++) {
			int a = Integer.parseInt(st.nextToken());
			list.add(i-a, i);
		}
		for(int j=1; j<=N;j++) {
			System.out.print(list.get(j)+" ");
		}
	}

}
