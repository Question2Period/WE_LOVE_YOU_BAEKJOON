package Bronze;
import java.io.*;
public class BaekJoon2592 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int sum = 0;
		int max = -1;
		int maxindex = 0;
		int[] arr= new int[1000];
		for(int i = 0; i<10; i++) {
			int input = Integer.parseInt(br.readLine());
			sum+=input;
			arr[input]++;
		}
		for(int i = 0; i<1000; i++) {
			if(arr[i]>max) {
				max = arr[i];
				maxindex = i;
				
			}
		}
		System.out.println(sum/10);
		System.out.println(maxindex);
	}

}
