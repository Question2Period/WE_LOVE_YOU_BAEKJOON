package Silver;
import java.io.*;
import java.util.*;

public class BaekJoon1764 {
	public static int N,M,count;
	public static String str;
	public static HashMap<String,Integer> Listen;
	public static ArrayList<String>list;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		Listen = new HashMap<>();
		list = new ArrayList<>();
		for(int i = 1; i<=N; i++) {
			str = br.readLine();
			Listen.put(str, i);
		}
		for(int i = 0; i<M; i++) {
			str = br.readLine();
			if(Listen.containsKey(str)) {
				count++;
				list.add(str);
			}
		}
		Collections.sort(list);
		System.out.println(count);
		for(int i = 0; i<list.size(); i++) System.out.println(list.get(i));
	}

}
