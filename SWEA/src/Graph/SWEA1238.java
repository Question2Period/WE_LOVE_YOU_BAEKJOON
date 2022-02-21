package Graph;

import java.io.*;
import java.util.*;

public class SWEA1238 {
	public static Queue<Integer> queue = new ArrayDeque<>(); //bfs 큐
	public static int to, from,N,M,V,Max,Maxindex,depth; 
	public static int[] deep;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for(int t = 1; t<=10; t++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken()); //간선*2
			V = Integer.parseInt(st.nextToken()); // 시작 정점
			int[][] arr = new int[101][101]; // 인접행렬
			deep = new int[101]; // 깊이 저장 카운팅 배열
			Max = Integer.MIN_VALUE; // 최대값 변수
			st = new StringTokenizer(br.readLine());
			for(int i =1; i<=M/2; i++) { //행렬 원소 채우기
				from = Integer.parseInt(st.nextToken());
				to = Integer.parseInt(st.nextToken());
				arr[from][to]++;
			}
			bfs(arr,new boolean[101],V); //bfs 호출
			System.out.println("#"+t+" "+Max);
		}
	}
	public static void bfs(int[][] x,boolean[] visited,int start) {
		queue.offer(start); //큐에 시작 정점 넣기
		visited[start] = true; // 방문 체크
		deep[start] = 0; // 시작 깊이
		while(!queue.isEmpty()) { // 큐가 빌때까지 반복
			int current = queue.poll(); // 현재 정점의 위치
			for(int i = 1; i<=100; i++) { 
				if(!visited[i] && x[current][i]!=0) { //아직 방문하지 않았고 연결된 간선이 있다면
					queue.offer(i); // 큐에 그 정점 추가
					visited[i] = true; // 방문 체크
					deep[i] = deep[current]+1; // 깊이를 현재 정점의 깊이+1값으로 정해준다
					depth = deep[i]; // 그때의 깊이 저장
				}
			}
		}
		for(int a = 1; a<=100; a++) {
			if(deep[a]==depth) { // 마지막 깊이에 있던 정점들
				if(a>Max) Max = a; // deep배열의 index가 그때 정점의 번호이므로 Max와 비교
			}
		}
	}
}