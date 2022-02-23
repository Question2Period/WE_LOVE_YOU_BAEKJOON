package Gold;
import java.io.*;
import java.util.*;
public class BaekJoon12865 {
	public static int[][] arr;
	public static List<Integer>list =new ArrayList<>();
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); //물품의 수
		int K = Integer.parseInt(st.nextToken()); // 최대 가용무게
		arr = new int[N+1][3]; //물건 정보 담기
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][1] = Integer.parseInt(st.nextToken()); // 물건의 무게
			arr[i][2] = Integer.parseInt(st.nextToken()); // 물건의 가치
		}
		Arrays.sort(arr, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1]-o2[1];
			}
		}); // 무게 순으로 오름차순 정렬
		int p1 = 0; //포인터 1
		int p2 = 1; // 포인터2
		int sum = arr[p1][1]; //무게합
		int value = arr[p1][2]; //가치 합
			while(p2!=N+1) { // 범위를 넘어가면 종료
				if(p1==p2) { // 같은 위치에 포인터가 놓일때
					if(arr[p2][1]<=K)list.add(arr[p2][2]); //그때 값이 가용무게이하면 리스트에 추가
					p2++;//큰 포인터 한칸 이동
				}
				if(sum<=K) {//무게 합이 최대 가용무게이하라면
					list.add(value); //저장
					sum+=arr[p2][1]; //무게 더하기
					value+=arr[p2][2]; //가치 더하기
					p2++;
				}
				else if(sum>K) { //무게가 초과시
					sum-=arr[p1][1]; //작은 포인터의 무게를 뺴준다
					value-=arr[p1][2]; // 가치도 빼준다
					p1++; // 이후 포인터 오른쪽으로 이동
				}
			}
			if(!list.isEmpty()) { //리스트가 비어있지 않다면(가능한 값이 존재)
			Collections.sort(list); //오름차순 정렬
			System.out.println(list.get(list.size()-1));//최대값 출력
			}
			else System.out.println(0); // 없다면 0 출력
		}
	}


