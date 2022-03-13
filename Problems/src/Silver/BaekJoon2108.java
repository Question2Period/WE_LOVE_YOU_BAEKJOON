package Silver;
import java.io.*;
import java.util.*;
public class BaekJoon2108 {
	public static int sum,dif,count,index1,index2,max1,max2,most;
	public static int[] arr;
	public static int[] countingplus = new int[4001];
	public static int[] countingminus = new int[4001];

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int num;
		arr = new int[N];
		for(int i = 0; i<N; i++) {
			num=Integer.parseInt(br.readLine());
			arr[i] = num;
			sum+=num;
			if(num>=0)countingplus[num]++;
			else countingminus[-num]++;
		}
		for(int i =0; i<4001; i++) {
			if(max1>countingplus[i]) {
				max1 = countingplus[i];
				index1 = i;
			}
		}
		if(index1!=4000) {
			for(int i = index1+1; i<4001; i++) {
				if(max1==countingplus[i]) {
					index1 = i;
					break;
				}
			}
		}
		for(int i =0; i<4001; i++) {
			if(max2>countingminus[i]) {
				max2 = countingminus[i];
				index2 = i;
			}
		}
		if(index2!=1) {
			for(int i = index2-1; i>0; i--) {
				if(max2==countingminus[i]) {
					index2 = i;
					break;
				}
			}
		}
		if(max1>max2)most = index1;
		else most = -index2;
		Arrays.sort(arr);
		System.out.printf("%.0f\n",((double)sum/(double)N));
		System.out.println(arr[N/2]);
		System.out.println(most);
		System.out.println(arr[N-1]-arr[0]);
	}

}
