package Silver;
import java.io.*;
import java.util.*;
public class BaekJoon1158 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		int count = 1;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int i = 0;
		int[] arr = new int[N];
		for(int y= 0; y<N; y++) {
			arr[y] = y+1;
		}
		if(K==1) {
			System.out.print("<");
			for(int x = 0; x<N-1; x++) {
				System.out.print(arr[x]+", ");
			}
			System.out.print(arr[N-1]+">");
		}
		else {
			List<Integer> list = new ArrayList<>();
			while(list.size()!=N) { // 수를 전부 없앨 때까지 반복
				if(i==N-1) { // 배열 인덱스 끝에 도달
					i=-1; // 0번째 인덱스로 이동하기 
				}
				i++; // 배열 순회
				if(arr[i]!=-1) { // 방문하지 않았다면
					count++; // 카운트+1
				}
				if(count==K) { // 카운트가 k만큼 되었다면
					list.add(arr[i]); // 리스트에 그때의 값 입력. 스트링빌더로 해도 될듯?
					count=0;
					arr[i]=-1;
				}
			}
			System.out.print("<");
			for(int x = 0; x<N-1; x++) {
				System.out.print(list.get(x)+", ");
			}
			System.out.print(list.get(N-1)+">");
		}
	}

}
