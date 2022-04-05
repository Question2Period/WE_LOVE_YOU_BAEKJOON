package Gold;
import java.io.*;
import java.util.StringTokenizer;

public class BaekJoon12173 {
	
	/* 발상 : 이분탐색으로 LIS를 찾는다. 찾는 방법은 범위를 지정해서 upper bound를 벗어나면 바로 뒤에 붙이고 길이를 증가시킨다.
	 * 범위 내에 존재한다면 이분탐색을 돌려 나온 인덱스에 값을 집어넣는다. 
	 * 
	 */
	
	static int[] binary;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N+1];
		int[] index = new int[N+1]; //실제 LIS에 arr[i]가 들어갈 위치
		
		StringTokenizer st= new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		binary = new int[N+1]; //이분 탐색 진행할 배열
		int len=0; //현재 수열의 길이
		int idx=0; // 이분탐색한 결과 인덱스
		for(int i=1; i<=N; i++) {
			if(arr[i] > binary[len]) { // 만약 다음 수열의 수가 현재 최대 값보다 클 경우
				len +=1; // 범위를 1칸 늘려주고
				binary[len] = arr[i]; // 범위 최대값에 그 수를 넣어준다.
			}else { // 만약 수가 범위 안에 존재하거나 범위 왼쪽 즉, 범위의 최소값보다 작을 경우
				idx = binarySearch(0,len, arr[i]); // 이분탐색을 통해 그 위치를 찾아준다
				binary[idx] = arr[i]; // 그 위치에 수를 넣어준다
			}
		}
		System.out.println(len); // 마지막 그 길이를 출력
	}
	
	static int binarySearch(int left, int right, int key) { 
		//이분탐색 메서드. 배열의 이분탐색 함수가 있긴 하나, 범위를 벗어날 시 음수가 나온다..
		int mid =0; //현재 인덱스를 나타낼 변수
		while(left<right) { // 범위 내에 수가 있을 경우
			mid = (left+right)/2; // 위치 예상
			if(binary[mid] < key) { // 예상한 위치의 값이 실제보다 작다면
				left = mid+1; // 범위의 최소를 1칸 증가시킨다
			}else {//예상한 위치의 값이 실제 값과 같거나 더 크다면
				right = mid; // 범위의 최대를 예상한 수로 바꿔준다.(어차피 바꿔주더라도 목표 수가 범위안에 들어오므로)
			}
		}
		return right; // 어차피 탈출할때는 left=right일때이므로 left를 리턴해도 같은 결과이다.
	}
}