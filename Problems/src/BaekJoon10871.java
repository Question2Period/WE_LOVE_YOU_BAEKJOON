import java.io.*;
import java.util.*;
public class BaekJoon10871 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		String[] str = br.readLine().split(" "); 
		for(int i=0;i<N;i++) {
			if(Integer.parseInt(str[i])<X) {
				System.out.print(str[i]+" ");
				
			}
		}

	}

}
