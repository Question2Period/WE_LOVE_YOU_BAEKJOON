package Diamond;
import java.io.*;
import java.util.*;
public class BaekJoon17104 { // 실버 1 골드바흐의 추측 -> 다시 풀어보자

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); // 테스트케이스
		boolean[] arr = new boolean[1000001]; // 에라토스테네스 배열
		Set<Integer>list1 = new HashSet<Integer>();
		arr[0]=arr[1]=true;
		for(int i = 2 ; i*i<1000001;i++) {

			if(!arr[i]) {
				for(int j = i*i; j<1000001;j+=i) {
					arr[j]=true;
				}
			}
		} //에라토스테네스의 체. 소수는 false값으로 저장된다.
		for(int i = 0; i<T; i++) {
			int n = Integer.parseInt(br.readLine());
			for(int j = 2; j<=n/2; j++) {
				if(!arr[j]&&!arr[n-j]) { //j와 n-j가 소수일 때
						list1.add(j);
	
				}
			}
			System.out.println(list1.size());
			list1.clear();
		}
	}

}
