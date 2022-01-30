package Bronze;
import java.io.*;
import java.util.*;
public class BaekJoon16756 { // 야옹 문제집 Pismo문제

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int temp1 = 0;
		int[] arr = new int[N];
		int Max =(int)Math.pow(10, 9);
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i =0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for(int j = 0; j<N-1;j++) {
			if(Math.abs(arr[j])-Math.abs(arr[j+1])!=Math.abs(arr[j]-arr[j+1])) {
				temp1 = Math.abs(arr[j]-arr[j+1]);
			}
			else {
				temp1 = Math.abs(arr[j])-Math.abs(arr[j+1]);
			}
			if(temp1<Max) {
				Max=temp1;
			}
		}
		System.out.println(Max);
	}

}


//if(Math.abs(Max)-Math.abs(Min)!=Math.abs(Max-Min)) {
//	temp1 = Math.abs(Max-Min);
//}
//else {
//	temp1 = Math.abs(Max)-Math.abs(Min);
//}
//Sum=Math.min(temp1,Sum);
