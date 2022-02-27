package Regular;
import java.io.*;
import java.util.*;
public class B_20220228 {
	public static ArrayList<Integer> list;
	public static int a;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		list = new ArrayList<>();
		StringTokenizer st;
		st=  new StringTokenizer(br.readLine());
		for(int i =0; st.hasMoreTokens(); i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		st = new StringTokenizer(br.readLine());
		for(int i =0; st.hasMoreTokens();i++) {
			a = Integer.parseInt(st.nextToken());
			if(list.contains(a)) {
				list.remove(list.indexOf(a));
				continue;
			}
			System.out.println("No");
			
		}
		if(list.isEmpty())System.out.println("Yes");
	}

}
