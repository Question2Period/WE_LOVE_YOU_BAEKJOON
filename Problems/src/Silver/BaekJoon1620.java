package Silver;
import java.io.*;
import java.util.*;
public class BaekJoon1620 {
	public static int N,M,a,flag;
	public static String str;
	public static String[] arr;
	public static HashMap<String, Integer> map;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new HashMap<>();
		arr = new String[N+1];
		for(int i =1; i<=N; i++) {
			str = br.readLine();
			map.put(str, i);
			arr[i] = str;
		}
		for(int i = 0; i<M; i++) {
			flag=0;
			str = br.readLine();
			 try{
				a = Integer.parseInt(str);
			}catch(NumberFormatException e) {
				System.out.println(map.get(str));
				flag=-1;
			};
			if(flag==0)System.out.println(arr[a]);
		}
	}

}
