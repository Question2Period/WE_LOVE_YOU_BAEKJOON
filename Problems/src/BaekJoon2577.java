import java.io.*;
public class BaekJoon2577 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());
		int arr[]= new int[10];
		String str = Integer.toString(A*B*C);
		String STR[] = str.split("");
		for(int i=0;i<str.length();i++) {
			arr[Integer.parseInt(STR[i])]++;
		}
		for(int i=0;i<10;i++) {
			System.out.println(arr[i]);
		}
	}
}
