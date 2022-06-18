package Gom;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
public class bear_B {
	public static TreeSet<String> map;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int cnt = 0;
		map = new TreeSet<>();
		for(int i = 0; i<N; i++) {
			String str = br.readLine();
			if(str.equals("ENTER")) {
				cnt+=map.size();
				map=new TreeSet<>();
				continue;
			}
			map.add(str);
		}
		System.out.println(cnt+map.size());
		
	}

}
