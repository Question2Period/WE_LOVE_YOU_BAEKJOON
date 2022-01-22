import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
public class BaekJoon10818 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int arr[]=new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		System.out.print(arr[0]+" ");		
		System.out.println(arr[N-1]);
	}
}
//int max = 0;
//int min = 0;
//String[] str = br.readLine().split(" ");
//for(int i=0; i<N; i++) {
//	if(Integer.parseInt(str[i])>max) {
//		
//	}
//}
