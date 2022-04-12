package Gold;
import java.io.*;
import java.util.*;
public class BaekJoon1759 {
	public static int[] v,arr,pw,temp;
	public static int L,C;
	public static List<String> list;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		v = new int['z'+1];
		list = new ArrayList<>();
		v['a']++;
		v['e']++;
		v['i']++;
		v['o']++;
		v['u']++;
		st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		pw = new int[L];
		temp = new int[L];
		arr = new int[C];
		st = new StringTokenizer(br.readLine());
		for(int i = 0;i<C; i++) {
			arr[i] = st.nextToken().charAt(0);
		}
		
		comb(0,0);
		Collections.sort(list);
		for(int i = 0; i<list.size(); i++)System.out.println(list.get(i));
	}
	
	public static void comb(int cur, int start) {
		if(cur==L) {
			if(check())return;
			String str = "";
			for(int i = 0; i<L; i++)temp[i] = pw[i];
			Arrays.sort(temp);
			for(int i = 0; i<L; i++)str= str+(char)temp[i]+"";
			list.add(str);
			return;
		}
		
		for(int i = start; i<C; i++) {
			pw[cur] = arr[i];
			comb(cur+1,i+1);
		}
	}
	
	public static boolean check() {
		int a = 0;//모음
		int b = 0;//자음
		for(int i = 0; i<L; i++) {
			if(v[pw[i]]==1)a++;
			else b++;
		}
		if(a<1||b<2)return true;
		else return false;
		
	}

}
