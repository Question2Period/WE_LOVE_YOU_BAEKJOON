package Silver;
import java.io.*;
import java.util.*;
public class BaekJoon12010 {
	public static List<String>list;
	public static int[] arr;
	public static int n,k;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		list = new ArrayList<>();
		arr = new int[n];
		recur(0);
		if(list.size()<k)System.out.println(-1);
		else {
		Collections.sort(list, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				int result = 0;
				for(int i =0; i<n; i++) {
					if(o1.charAt(i)==o2.charAt(i))continue;
					result = o1.charAt(i)-o2.charAt(i);
					break;
				}
				return result;
			}
		});
		String answer = list.get(k-1);
		for(int i =0; i<answer.length()-1; i++) {
			int x = answer.charAt(i)-'0';
			System.out.print(x+"+");
		}
		System.out.print(answer.charAt(answer.length()-1));
		}
	}
	
	public static void recur(int cur) {
		if(cur==n) {//체크
			int sum = 0;
			for(int i = 0;i<arr.length; i++) {
				sum+=arr[i];
			}
			if(sum==n) {
				String str = "";
				for(int i = 0; i<arr.length; i++) {
					if(arr[i]==0)continue;
					str=str+(arr[i]+"");
				}
				if(!(list.contains(str)))list.add(str);
			}
			return;
		}
		
		for(int i=0;i<4; i++) {
			arr[cur] = i;
			recur(cur+1);
		}
		
	}

}
