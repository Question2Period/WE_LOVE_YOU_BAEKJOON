package Silver;
import java.io.*;
import java.util.*;

public class BaekJoon15657 {
    public static int N;
    public static int M;
    public static int[] temp;
    public static int []arr = new int[110];
    public static void recur(int cur,int start){
        if(cur == M){
            for(int i=0; i<M; i++){
                System.out.print(arr[i] + " ");
            }
            System.out.println("");
            return ;
        }
        for(int i=start;i<=N;i++){
            arr[cur] = temp[i];
            recur(cur+1, i);
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());
        temp = new int[N+1];
        for(int i= 1; i<=N; i++)temp[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(temp);
        recur(0,1);
        
    }
}