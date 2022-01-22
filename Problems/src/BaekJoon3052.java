import java.io.*;
import java.util.*;
public class BaekJoon3052 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int arr[]=new int[10];
		int count = 0;
		int namuzi[]=new int[42];
		for(int i=0;i<10;i++) {
			arr[i]=Integer.parseInt(br.readLine())%42;
			namuzi[arr[i]]++;
		}
		for(int i=0;i<42;i++) {
			if(namuzi[i]!=0) {
				count++;
			}
		}
		System.out.println(count);

	}
}
