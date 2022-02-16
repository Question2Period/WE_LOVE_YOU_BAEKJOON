package Silver;
import java.io.*;
import java.util.*;
public class BaekJoon11723 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		String order = "";
		int number = 0;
		List<Integer> list = new ArrayList<>();
		int M = Integer.parseInt(br.readLine());
		for(int i = 0; i<M; i++) {
			String str = br.readLine();
				if(str.equals("all")) {
					list.clear();
					for(int x = 0; x<20; x++) list.add(x+1);
				}
				else if(str.equals("empty")) {
					list.clear();
				}
			else {
				st = new StringTokenizer(str);
				order = st.nextToken();
				number = Integer.parseInt(st.nextToken());
				switch (order) {
				case "add": 
					if(!list.contains(number)) {
						list.add(number);
					}
					break;
				case "remove": 
					if(list.contains(number)) {
						list.remove(list.indexOf(number));
					}
					break;
				case "check": 	
					if(list.contains(number)) {
						sb.append(1).append("\n");
					}
					else {
						sb.append(0).append("\n");
					}
					break;
				case "toggle": 
					if(list.contains(number)) {
						list.remove(list.indexOf(number));
					}
					else {
						list.add(number);
					}
					break;

				}
			}
			
		}
		System.out.println(sb);
	}

}
