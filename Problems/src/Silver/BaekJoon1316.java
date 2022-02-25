package Silver;
import java.io.*;
import java.util.*;
public class BaekJoon1316 {
	public static String str;
	public static char a;
	public static int length,size,flag,count;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Set<Character> set = new HashSet<>();
		int N = Integer.parseInt(br.readLine());

		for(int i = 0; i<N; i++) {
			str = br.readLine();
			length = str.length(); // 문자열 길이
			flag=0; // 그룹단어가 아니라면 flag=-1이 된다
			for(int j= 0; j<length; j++) {
				a = str.charAt(j); // j번째 자리 문자
				size = set.size(); // 중복했을 때 set의 크기에는 변화가 없다는 걸 알아내기 위한 넣기 전 set 크기
				set.add(a); // j번째 자리의 문자를 set에 넣어 중복여부 검사
				if(set.size()!=size+1&&str.charAt(j-1)!=a&&j!=0) {
					//중복되어 set에 들어가지 않았는데, 이전문자와 다르다는 것은 그룹단어가 아니라는 뜻
					flag=-1;
					break; //탈출
				}				
			}
			set.clear(); // 다음번 문자열을 위해 비우기
			if(flag==-1)continue; // 그룹단어가 아니므로 카운트해주지 않고 넘어간다
			count++; // 그룹단어는 수를 계산
		}
		System.out.println(count);
	}

}
