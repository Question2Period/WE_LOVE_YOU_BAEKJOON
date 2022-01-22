import java.io.*;
import java.util.*;
public class BaekJoon4153 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		int arr[]=new int[3];
		while(true){
			str = br.readLine();
			String[] Tri = str.split(" ");
			for(int i=0;i<3;i++) {
				arr[i]=Integer.parseInt(Tri[i]);
			}
			Arrays.sort(arr);
			if(str.equals("0 0 0")) {
				break;
			}
			if(arr[0]*arr[0]+arr[1]*arr[1]==arr[2]*arr[2]) {
				System.out.println("right");
			}
			else {
				System.out.println("wrong");
			}
		}
	}

}
