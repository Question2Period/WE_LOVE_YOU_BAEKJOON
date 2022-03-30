package Silver;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
public class BaekJoon2751 { // 수 정렬하기 2(실버5) - 다음에는 counting sort(계수정렬로 풀어보자)

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		for(int i = 0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		for(int i = 0; i<arr.length;i++) {
			bw.write(arr[i]+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
