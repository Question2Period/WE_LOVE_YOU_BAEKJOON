package Bronze;
import java.io.*;
import java.util.*;
public class BaekJoon9046 {
	public static int[] arr;
	public static String str;
	public static char answer;
	public static int index,max,maxindex,flag;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i<N; i++) {
			flag=0;
			max = Integer.MIN_VALUE;
			arr = new int[26];
			str = br.readLine();
			for(int j = 0; j<str.length(); j++) {
				index = str.charAt(j);
				if(index==32)continue;
				arr[index-'a']++;
			}
			for(int k = 0; k<26; k++) {
				if(arr[k]>max) {
					max = arr[k];
					maxindex=k;
					flag=0;
				}
				else if(arr[k]==max)flag=1;
			}
			if(flag==1)System.out.println('?');
			else System.out.println((char)(maxindex+'a'));
		}
		
	}

}
