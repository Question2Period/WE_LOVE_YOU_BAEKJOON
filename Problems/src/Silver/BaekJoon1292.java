package Silver;
import java.io.*;
import java.util.*;
public class BaekJoon1292 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A= Integer.parseInt(st.nextToken());
		int B= Integer.parseInt(st.nextToken());
        ArrayList<Integer> list = new ArrayList<Integer>();
        int sum=0;

        for(int i=0; i<1000; i++) {
            for(int j=0; j<=i; j++) {
                list.add(i + 1); 
            }
        }

        for(int i=A-1; i<=B-1; i++) {
            sum += list.get(i);
        }

        System.out.println(sum);
    }
}