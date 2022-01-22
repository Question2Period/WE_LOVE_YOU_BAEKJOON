import java.io.*;
public class BaekJoon2562 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int arr[]=new int[9];
		int max = 0;
		int max_index=0;
		for(int i=0;i<9;i++) {
			arr[i]=Integer.parseInt(br.readLine());
			if(arr[i]>max) {
				max=arr[i];
				max_index=i;
			}
		}
		System.out.println(max);
		System.out.println(max_index+1);

	}

}
