package Gold;
import java.io.*;
import java.util.*;
public class BaekJoon3584{
    public static int N,A,B,cx,cy;
    public static List<Integer>[] arr;
    public static List<Integer>passX,passY;
    public static void main(String[] args) throws IOException{
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t<=T; t++) {
            N = Integer.parseInt(br.readLine());
            arr = new ArrayList[N+1];
            for(int i = 0;i<=N;i++)arr[i] = new ArrayList<>();
            for(int i = 0; i<N-1; i++) {
                st = new StringTokenizer(br.readLine());
                A = Integer.parseInt(st.nextToken());
                B = Integer.parseInt(st.nextToken());
                arr[B].add(A); //자식->부모
            }
            st = new StringTokenizer(br.readLine());
            cx = Integer.parseInt(st.nextToken());
            cy = Integer.parseInt(st.nextToken());
            passX = new ArrayList<>();
            passY = new ArrayList<>();
            passX.add(cx);
            passY.add(cy);
            dfs(cx,passX);
            dfs(cy,passY);           
            	int x = passX.size()-1;
                int y = passY.size()-1;
            while(true) {
                if(passX.get(x)!=passY.get(y)) {
                    sb.append(passX.get(x+1)+"\n");
                    break;
                }
                if(x==0||y==0) {
                	sb.append(passX.get(0)+"\n");
                	break;
                }
                
                x--;
                y--;
                
            }
            
        }
        System.out.println(sb);
        
    }
    
    public static void dfs(int cur,List a) {
    	if(arr[cur].size()==0)return;
            int next = arr[cur].get(0);
            a.add(next);        
            dfs(next,a);
    }

}