package Gold;
import java.io.*;
import java.util.*;
public class BaekJoon2436 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int Max = Integer.parseInt(st.nextToken());
		int Min = Integer.parseInt(st.nextToken());
		int flag = 0;
		int num1= 0;
		int num2= 0;
		int x = Min/Max;
		for(int i = 1; i*i<x; i++) {
			if(x%i==0) {
				for(int j =2; j<num1; j++) {
					if(i%j==0&&(x/i)%j==0) {
						flag=1;
						break;
					}
				}
				if(flag==0) {
				num1 = i;
				num2 = x/i;	
				}
			}
			flag = 0;
		}
		if(Min!=Max) {
		System.out.printf("%d %d",num1*Max,num2*Max);
		}
		else {
			System.out.printf("%d %d",Max,Max);
		}
	}

}
