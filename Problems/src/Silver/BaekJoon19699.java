package Silver;
import java.io.*;
import java.util.*;
public class BaekJoon19699 {
	public static boolean[]chest = new boolean[10001];
	public static int[] arr;
	public static int N,M,sum;
	public static List<Integer> cow;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		chest[0] = true;
		chest[1] = true;
		for(int i = 2; i<=10000;i++) {
			if(chest[i])continue;
			
			for(int j= i*i; j<=10000; j+=i) {
				chest[j] = true;
			}
		}
		cow = new ArrayList<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		arr = new int[N];
		for(int i = 0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());
		recur(0,0);
		if(cow.size()==0)System.out.println(-1);
		else {
		Collections.sort(cow);
		for(int i = 0; i<cow.size(); i++)System.out.print(cow.get(i)+" ");
		}
	}
	
	public static void recur(int start, int cur) {
		if(cur==M) {
			if(check(sum)) {
				if(!cow.contains(sum))cow.add(sum);
			}
			return;
		}
		for(int i = start; i<N; i++) {
			sum+=arr[i];
			recur(i+1,cur+1);
			sum-=arr[i];
		}
	}
	
	public static boolean check(int x) {
		if(chest[x])return false; // 소수가 아니라면
		else return true; // 소수라면
	}

}
