package Bronze;
import java.io.*;
import java.util.*;
public class BaekJoon3040 { // 투포인터 문제

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[9]; // 투포인터를 사용할 배열
		int[] index = new int[9]; // 처음 순서를 기억할 배열
		int sum = 0; // 전체의 합. 
		for(int i = 0; i<9; i++) {
			String str = br.readLine();
			arr[i] = Integer.parseInt(str);
			index[i] = Integer.parseInt(str);
			sum+=arr[i];
		} // 배열의 정보를 입력하고 그 전체 합을 구한다.

		Arrays.sort(arr); // 투포인터로 두개의 합을 구하기 위해선 정렬을 해줘야한다.
		int Xman = sum-100; // 전체에서 100을 빼줬을 때 난쟁이가 아닌 두명의 합이 나온다.
		int p1 = 0; // 가장 작은 값을 가리키는 포인터
		int p2 = 8; // 가장 큰 값을 가리키는 포인터
		while(p1<p2) { // 포인터가 같은 값을 가리키게 되면 종료한다.
			if(arr[p1]+arr[p2]>Xman) { // 두 명의 합이 Xman보다 클 시 큰 값을 가리키는 포인터 값을 감소시킨다.
				p2--;
			}
			else if(arr[p1]+arr[p2]<Xman) {// 두 명의 합이 Xman보다 작을 시 작은 값을 가리키는 포인터 값을 증가시킨다.
				p1++;
			}
			else { // // 두 명의 합이 Xman, 즉 원하는 답을 찾을 시
				for(int x = 0; x<9; x++) { // 들어온 순서대로 되어 있는 index 배열에서 두 값이 아닌 것만 제외하고 출력
					if(index[x]!=arr[p1] && index[x]!=arr[p2]) {
						System.out.println(index[x]);
					}
				}
				break;
			}
		}
	}

}
