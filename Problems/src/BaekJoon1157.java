import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
public class BaekJoon1157 {

	public static void main(String[] args) throws IOException{
		int max = 0; // arr배열에서 최댓값 담을 변수
		int index = 0; //사용횟수가 가장 많은 알파벳을 담을 변수
		int flag =0; // 확인 변수
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine().toUpperCase();//출력은 대문자이므로 미리 입력 문자열 대문자변환
		int arr[]=new int[26];//아스키코드 A~Z까지의 개수가 26개이므로 26 크기의 배열 선언
		for(int i=0; i<str.length();i++) {
			arr[str.charAt(i)-65]++;
		}								//(입력 알파벳 아스키코드-65)번째 인덱스에 알파벳 횟수 가산
		for(int j=0;j<26;j++) {
			if(arr[j]>max) {
				max=arr[j];
				index = j;
				flag = 0;//aabbccc처럼 c를 만나기 전 flag값이 1이면 ?를 출력하므로 이를 방지하기 위해 0으로 다시 초기화 
			} 							//max로 최댓값을 탐색하고 그때의 j를 index에 저장
			else if(arr[j]==max&&str.length()!=1) { // 입력 문자가 1개일때 ?가 나오는걸 방지
				flag = 1; //최댓값이 여러개 나올 때
			}
		}
		if(flag==0) {
			char a = (char)(index+65);//arr배열의 index가 알파벳 아스키코드-65한 값이므로 다시 65더해서 원래 아스키코드값으로 복구
			System.out.println(a);
		}
		else if(flag==1) { //flag가 1이므로 ?출력
			System.out.println('?');
		}
	}
}