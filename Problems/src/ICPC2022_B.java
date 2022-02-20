import java.io.*;
import java.util.*;
public class ICPC2022_B {
	public static int num,A,B,C,D,indexA,indexB,indexC,indexD;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[][] Lang = new int[2][N];
		int[][] Eng = new int[2][N];
		int[][] Math = new int[2][N];
		int[][] Science = new int[2][N];
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			Lang[1][i] = num; 
			Eng[1][i] = num; 
			Math[1][i] = num; 
			Science[1][i] = num; 
			Lang[0][i] = Integer.parseInt(st.nextToken());
			Eng[0][i] = Integer.parseInt(st.nextToken());
			Math[0][i] = Integer.parseInt(st.nextToken());
			Science[0][i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(Lang, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return -(o1[0]-o2[0]);
			}});
		Arrays.sort(Eng, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return -(o1[0]-o2[0]);
			}});
		Arrays.sort(Math, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return -(o1[0]-o2[0]);
			}});
		Arrays.sort(Science, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return -(o1[0]-o2[0]);
			}});
		sb.append(Lang[1][0]+" ");
		indexA = Lang[0][0];
		for(int i = 0; i<N; i++) {
			if(Eng[1][i]!=Lang[1][0]) {
				indexB = i;
				sb.append(Eng[1][i]+" ");
				break;
			}
		}
		for(int i = 0; i<N; i++) {
			if(Math[1][i]!=indexA&&Math[1][i]!=indexB) {
				indexC = i;
				sb.append(Math[1][i]+" ");
				break;
			}
		}
		for(int i = 0; i<N; i++) {
			if(Science[1][i]!=indexA&&Science[1][i]!=indexB && Science[1][i]!=indexC) {
				indexD = i;
				sb.append(Science[1][i]);
				break;
			}
		}
		System.out.println(sb);
		
		
	}

}
