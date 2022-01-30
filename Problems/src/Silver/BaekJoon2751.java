package Silver;
import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
public class BaekJoon2751 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		HashSet<Integer>set1 = new HashSet<Integer>();
		HashSet<Integer>set2 = new HashSet<Integer>();
		for(int i = 0; i<N; i++) {
			String str = br.readLine();
			if(Integer.parseInt(str)>=0) {
			set1.add(Integer.parseInt(str));
			}
			else {
				set2.add(Integer.parseInt(str));
			}
		}
		ArrayList<Integer>list1 = new ArrayList<Integer>(set1);
		ArrayList<Integer>list2 = new ArrayList<Integer>(set2);
		for(int i = list2.size()-1; i!=-1;i--) {
			System.out.println(list2.get(i));
		}
		for(int i = 0; i<list1.size();i++) {
			System.out.println(list1.get(i));
		}
	}

}
