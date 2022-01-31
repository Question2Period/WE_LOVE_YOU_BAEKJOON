package Silver;
import java.io.*;
import java.util.*;
public class BaekJoon11650 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<String>str = new ArrayList<String>(N);
		for(int i = 0; i<N; i++) {
			str.add(br.readLine());
		}
		Collections.sort(str, new Comparator<String>()){
			
		}
		
		
	}

}
