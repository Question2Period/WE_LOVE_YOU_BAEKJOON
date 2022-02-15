package Silver;
import java.io.*;
import java.util.*;
public class BaekJoon9417 {
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		List<Integer> list = new ArrayList<>();
		int count = 0;
		int zero = 0;
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i<N; i++) {
			int flag=  0;
			st = new StringTokenizer(br.readLine());
			for(int j= 0; st.hasMoreTokens(); j++) {
				list.add(Math.abs(Integer.parseInt(st.nextToken())));
				if(list.get(j)==0) {
					zero++;
				}
			}
			if(zero>list.size()-2&&list.size()>2) {
				System.out.println(0); break;
			}
			else {
				Collections.sort(list);
				if(count==list.size()) {
					Collections.reverse(list);
				}
				int Max = list.get(list.size()-2);
				for(int x = Max;x>0; x--) {
					if(x==1)  {
						System.out.println(1);break;
					}


					for(int y= 0; y<list.size()-1; y++) {

						if(list.get(y)<x) {
							continue;
						}
						if(list.get(y)%x==0 && list.get(list.size()-1)%x==0) {
							System.out.println(x);
							flag = 1;
							break;
						}
					}
					if(flag==1) {
						break;
					}
				}
				list.clear();
			}
		}
	}

}
