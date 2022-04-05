package Plantinum;
import java.io.*;
import java.util.*;

public class BaekJoon14003 {
	
	/* 발상 : 이분탐색으로 LIS를 찾는다. 찾는 방법은 범위를 지정해서 upper bound를 벗어나면 바로 뒤에 붙이고 길이를 증가시킨다.
	 * 범위 내에 존재한다면 이분탐색을 돌려 나온 인덱스에 값을 집어넣는다. 
	 * 
	 */
	static int N;
	static ArrayList<Integer> list;
	static int[] index,arr;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1];
		index = new int[N+1]; //실제 LIS에 arr[i]가 들어갈 위치
		
		StringTokenizer st= new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		list = new ArrayList<>(); //이분 탐색 진행할 배열
		list.add(arr[1]);
		index[1] = 0;
		for(int i=2; i<=N; i++) {
			if(arr[i] > list.get(list.size()-1)) { // 만약 다음 수열의 수가 현재 최대 값보다 클 경우
				list.add(arr[i]); // 범위를 1칸 늘려주고 범위 최대값에 그 수를 넣어준다.
				index[i] = list.size()-1; // 현재 시점에서의 upper_bound 인덱스에 저장
			}else { // 만약 수가 범위 안에 존재하거나 범위 왼쪽 즉, 범위의 최소값보다 작을 경우
				binarySearch(i);
			}
		}
		Stack<Integer> stack = new Stack<>();
		int value = list.size()-1;
		for(int i =N; i>=1&&value>=0; i--) {
			if(value==index[i]) {
				value--;
			stack.push(arr[i]);
			}
		}
		System.out.println(list.size());
		while(!stack.isEmpty())System.out.print(stack.pop()+" ");
	}
	
	static void binarySearch(int key) { 
		//이분탐색 메서드. 배열의 이분탐색 함수가 있긴 하나, 범위를 벗어날 시 음수가 나온다..
		int start = 0;
		int mid =0; //현재 인덱스를 나타낼 변수
		int end = list.size()-1;//upper_bound
		while(start<end) { // 범위 내에 수가 있을 경우
			mid = (start+end)/2; // 위치 예상
			if(list.get(mid) < arr[key]) { // 예상한 위치의 값이 실제보다 작다면
				start = mid+1; // 범위의 최소를 1칸 증가시킨다
			}else {//예상한 위치의 값이 실제 값과 같거나 더 크다면
				end = mid; // 범위의 최대를 예상한 수로 바꿔준다.(어차피 바꿔주더라도 목표 수가 범위안에 들어오므로)
			}
		}
		list.set(start, arr[key]);
		index[key] = start;
	}
}