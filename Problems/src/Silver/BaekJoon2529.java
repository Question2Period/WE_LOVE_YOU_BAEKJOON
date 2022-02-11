package Silver;
import java.io.*;
import java.util.*;
public class BaekJoon2529 {
	public static StringBuilder sb=new StringBuilder();
    public static int N;
    public static int M;
    public static int []arr;
    public static List<Long> list=new ArrayList<Long>();
    public static String []ineq;
    static boolean []visited  = new boolean[10];
    public static void recur(int cur){
        if(cur == N+1	){
            for(int i=0; i<N; i++){
                if(ineq[i].equals("<") && arr[i] > arr[i+1]) return;
                if(ineq[i].equals(">") && arr[i] < arr[i+1]) return;

            }
            for(int i = 0; i<N+1; i++) {
            sb.append(arr[i]);
            }
            list.add(Long.parseLong(sb.toString()));

            sb.delete(0, N+1);
            return ;
        }
        for(int i=0;i<10;i++){
            if(visited[i]){
                continue; //사용중 이라면 건너뜀
            }
            arr[cur] = i;
            visited[i] = true; //사용중인지
            recur(cur+1);
            visited[i] = false; //출력이 되었다면 해제

        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        arr=new int[N+1];
        ineq = new String[N];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int x = 0; x<N; x++) {
        	ineq[x] = st.nextToken();
        }
        recur(0);
        Collections.sort(list);
        String a = list.get(list.size()-1)+"";
        String b = list.get(0)+"";
        if(a.length()!=N+1) {
        	System.out.print(0);
        }
        System.out.println(a);
        if(b.length()!=N+1) {
        	System.out.print(0);
        }
        System.out.println(b);
    }
}