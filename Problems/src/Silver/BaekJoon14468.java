package Silver;
import java.io.*;
import java.util.*;
public class BaekJoon14468 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int[] cow = new int[26];
		int count = 0;
		for(int i = 0; i<26; i++) {
			cow[i]=-1;
		}
		int[] cow2 = new int[26];
		for(int i = 0; i<52; i++) {
			if(cow[str.charAt(i)-'A']!=-1) {
				cow2[str.charAt(i)-'A']=i;
			}
			else {
			cow[str.charAt(i)-'A'] =i;
			}
		}
		for(int i = 0; i<26; i++) {
			for(int j = 0; j<26; j++) {
				if(j==i) {
					continue;
				}
				else {
					if(cow[i]<cow[j]&&cow2[i]<cow2[j]&&cow[j]<cow2[i]) {
						count++;
					}
				}
			}
		}
		System.out.println(count);
	}
}


