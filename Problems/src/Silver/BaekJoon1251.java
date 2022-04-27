package Silver;
import java.io.*;
import java.util.*;
public class BaekJoon1251 {
	public static List<String> arr;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		arr = new ArrayList<>();
		for(int i = 0; i<str.length()-2; i++) {
			for(int j= i+1; j<str.length()-1; j++) {
				String first = new StringBuffer(str.substring(0,i+1)).reverse().toString();
				String second = new StringBuffer(str.substring(i+1,j+1)).reverse().toString();
				String third = new StringBuffer(str.substring(j+1,str.length())).reverse().toString();
				arr.add(first+second+third);
			}
		}
		Collections.sort(arr);
		System.out.println(arr.get(0));
		
	}

}
