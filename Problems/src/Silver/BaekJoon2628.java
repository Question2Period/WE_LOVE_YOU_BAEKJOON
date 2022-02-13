package Silver;
import java.io.*;
import java.util.*;
public class BaekJoon2628 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		List<Integer> listG = new ArrayList<>();
		List<Integer> listS = new ArrayList<>();
		int MaxG = Integer.MIN_VALUE;
		int MaxS = Integer.MIN_VALUE;
		int temp = 0;
		st = new StringTokenizer(br.readLine());
		int Garo = Integer.parseInt(st.nextToken());
		int Sero = Integer.parseInt(st.nextToken());
		int line = Integer.parseInt(br.readLine());
		for(int i = 0; i<line; i++) {
			st = new StringTokenizer(br.readLine());
			if(Integer.parseInt(st.nextToken())==0) {
				listS.add(Integer.parseInt(st.nextToken()));
			}
			else {
				listG.add(Integer.parseInt(st.nextToken()));								
			}
		}
		listG.add(0);		
		listG.add(Garo);		
		listS.add(0);		
		listS.add(Sero);
		Collections.sort(listG);
		Collections.sort(listS);
		for(int i = 0; i<listG.size()-1;i++) {
			temp = listG.get(i+1) - listG.get(i);
			if(temp>MaxG) {
				MaxG=temp;
			}
		}
		for(int i = 0; i<listS.size()-1;i++) {
			temp = listS.get(i+1) - listS.get(i);
			if(temp>MaxS) {
				MaxS=temp;
			}
		}
		System.out.println(MaxG*MaxS);
	}

}
