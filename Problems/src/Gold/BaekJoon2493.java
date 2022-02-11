package Gold;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;
 
class Top { // 탑에 대한 정보
    int num; // 탑의 번호
    int height; // 탑의 높이
 
    Top(int num, int height) {
        this.num = num;
        this.height = height;
    }
}
 
public class BaekJoon2493 {
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
 
        Stack<Top> stack = new Stack<>();
        StringBuilder answer = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int height = Integer.parseInt(st.nextToken());
 
            if (stack.isEmpty()) { // 스택이 비어있다면, 0을 출력하고 탑을 push한다. (초기 과정에 속함.)
                answer.append("0 ");
                stack.push(new Top(i, height));
            } else {
                while (true) { 
                    if (stack.isEmpty()) { // 스택이 비어있다면, 0을 출력하고 탑을 push한다.
                        answer.append("0 ");
                        stack.push(new Top(i, height));
                        break;
                    }
 
                    Top top = stack.peek();
 
                    if (top.height > height) { // peek한 탑의 높이가 현재 탑의 높이보다 높다면,
                        answer.append(top.num + " "); // peek한 탑의 번호를 출력하고,
                        stack.push(new Top(i, height)); // 현재 탑을 스택에 push한다.
                        break;
                    } else { // peek한 탑의 높이가 현재 탑의 높이보다 낮다면,
                        stack.pop(); // 스택에서 pop하고 다시 반복문을 돌린다.
                    }
                }
            }
        }
 
        bw.write(answer.toString() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
 
}


//int[] arr = new int[N];
//int[] sequence = new int[100000000];
//int[] answer = new int[N];
//for(int i = 0;i<N;i++) {
//	arr[i] = Integer.parseInt(st.nextToken());
//	sequence[arr[i]]=i;
//}
//Arrays.sort(arr);
//for(int j = arr[0]; j<arr[N-1]; j++) {
//	if(sequence[j]!=0) {
//int x = j-(Arrays.binarySearch(Arrays.copyOfRange(sequence, j+1, arr[N-1]),arr[j]));
//answer[sequence[arr[j]]]=sequence[x]+1;
//	}
//}
//answer[arr[N-1]]=0;
//for(int k = 0; k<N;k++)
//System.out.print(answer[k]+" ");