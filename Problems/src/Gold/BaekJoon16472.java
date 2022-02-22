package Gold;
import java.io.*;
import java.util.*;
public class BaekJoon16472 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String str = br.readLine(); //문자열
		int count = 0; // 현재 문자열 길이
		int[] alphabet = new int[26]; // 알파벳 카운트
		int Max = 0; // 최대값
		int p1 = 0; //lower bound 포인터
		int p2 = 1; // upper bound 포인터
		int num1 = 0; // 
		int num2 = 0;
		if(str.length()==N)Max=N;
		else if(str.length()==1)Max=1;
		else
			alphabet[str.charAt(p1)-'a']++;
			count++;
			while(true) {
				if(p2==str.length()) break; // p2가 문자열범위 넘어갈시 탈출
				num1 = str.charAt(p1)-'a'; //lower bound 포인터의 문자값
				num2 = str.charAt(p2)-'a';//upper bound 포인터

				if(alphabet[num2]==0) { //첫사용
					alphabet[num2]++; //사용횟수+1
					count++;//문자종류+1
				}else alphabet[num2]++;

				while(count>N) {// 최대 식별가능한 문자종류를 넘어갈때
					num1 = str.charAt(p1)-'a';
					alphabet[num1]--; 
					if(alphabet[num1]==0)count--;
					p1++; // p1의 범위를 +1해주면서 count가 n보다 작아질때까지 반복
				}
				Max = Math.max(Max, p2-p1+1); //그때의 최대 길이
				p2++; // upper bound증가
			}
		System.out.println(Max);
	}
}

// 백준 게티님 코드
//import java.io.*;
//import java.util.*;
//import static java.lang.Math.max;
//
//public class Main {
//    static String str; // 밑에 함수로 빼둔거 쓰려면 전역변수처럼 쓸수있도록 static변수로 선언
//
//    public static void main(String[] args) throws IOException { // 중괄호를 한칸 띄워주세요..
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int N = Integer.parseInt(br.readLine());
//        int count = 0;
//        int[] alphabet = new int[26];
//        int Max = 0;
//        int p1 = 0;
//        int p2 = 1;
//        int num1 = 0;
//        int num2 = 0;
//
//        // 바로 return해서 뒤에 인덴트없애기
//        if (str.length() == N) {
//            System.out.println(N);
//            return;
//        }
//        if (str.length() == 1) {
//            System.out.println(1);
//            return;
//        }
//
//        alphabet[str.charAt(p1) - 'a']++;
//        count++;
//        while (true) {
//            if (p2 == str.length()) break;
//            num1 = str.charAt(p1) - 'a'; //이런거 다 아래에 정의한 함수로 바꿀수있어요
//            num2 = str.charAt(p2) - 'a';
//            if (alphabet[num2] == 0) {
//                alphabet[num2]++;
//                count++;
//            } else {
//                alphabet[num2]++;    // 위에 중괄호썼으면 아래도 중괄호써야 안헷갈려요
//            }
//
//            while (count > N) {
//                num1 = str.charAt(p1) - 'a';
//                alphabet[num1]--;
//                if (alphabet[num1] == 0) count--;
//                p1++;
//            }
////            Max = Math.max(Max, p2 - p1 + 1);
//            Max = max(Max, p2 - p1 + 1);  // max()를 메서드로 선언하거나 static import 이용.. Math.max 이거 보기싫어서요ㅠㅠㅋㅋ
//                                            // 여기서는 5라인에서 static import함
//            p2++;
//
//            System.out.println(Max);
//        }
//    }
//
//    static int cti(char c) {   // 너무 자주 쓰이는 애들은 함수로 묶어주면 보기좋아요(char to int의 약자)
//        return c - 'a';
//    }
//
//    // 더 귀찮으면 인덱스로 바로 접근해서 숫자로 바꿔주기
//
//    static int toInt(int i) {
//        return str.charAt(i) - 'a';
//    }
//}