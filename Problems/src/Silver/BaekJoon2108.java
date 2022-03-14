package Silver;
import java.io.*;
import java.util.*;
public class BaekJoon2108 {
	public static int sum,dif,max,most;
	public static ArrayList<Integer>list = new ArrayList<>();
	public static int[] arr;
	public static int[] counting = new int[8002];

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
			if(num>=0)counting[num+4000]++;
			else counting[-num-1]++;
		}
		for(int i = 0; i<8001; i++) {
			if(counting[i]>max) {
				max = counting[i];
			}
		}
		for(int i = 0; i<8001; i++) {
			if(counting[i]==max) {
				if(i>=4000)list.add(i-4000);
				else list.add(-i-1);
			}
		}

		if(list.size()==1) {
			most = list.get(0);
		}
		else {
			Collections.sort(list);
			most = list.get(1);
		}
		Arrays.sort(arr);
		double answer = (double)sum/N;
		System.out.println(Math.round(answer));
		System.out.println(arr[N/2]);
		System.out.println(most);
		System.out.println(arr[N-1]-arr[0]);
	}

}
