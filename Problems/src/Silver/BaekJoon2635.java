package Silver;
import java.io.*;
import java.util.*;
public class BaekJoon2635 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] answer = new int[30000];
		int[] arr = new int[30000];

		int a = 0;
		int b = 0;
		int count = 0;
		int max = Integer.MIN_VALUE;
		for(int j =0; j<answer.length; j++) {
			answer[j] = -1;
		}
		for(int i = N/2; i<N;i++) {
			count = 2;
			arr[0]=N;
			arr[1]=i;
			while(true) {
				a = arr[count-1];
				b = arr[count-2];
				if(b-a<0) {
					break;
				}
				arr[count]=b-a;
				count++;

			}
			if(count>max) {
				max = count;
				for(int x = 0; x<max; x++) {
					answer[x]=arr[x];
				}
			}
		}
		if(N!=1) {
			System.out.println(max);
			for(int j =0; j<answer.length; j++) {
				if(answer[j]!=-1) {
					System.out.print(answer[j]+" ");
				}
			}
		}
		else {
			System.out.println(4);
			System.out.println("1 1 0 1");
		}
	}

}
