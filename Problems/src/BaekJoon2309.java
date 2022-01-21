import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//dd
public class BaekJoon2309 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int sum=0;
		int s1 = 0;
		int s2 = 0;
		int temp =0;
		int arr[]=new int[9];
		for(int i=0; i<9;i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}

		for(int i=0; i<9;i++) {
			sum+=arr[i];
		}
		for(int i=0; i<8;i++) {
			for(int j=0; j<8;j++) {
				if(arr[j]>arr[j+1]) {
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		for(int i=0; i<8;i++) {
			for(int j=0;j<9;j++) {
				if(sum-arr[i]-arr[j]==100) {
					if(i==j) {
						continue;
					}
					s1 = i;
					s2 = j;
				}
			}
		}
		for(int i=0; i<9;i++) {
			if(i==s1 || i==s2) {
				continue;
			}
			System.out.println(arr[i]);
		}

	}
} //d
