package Graph;
import java.util.Arrays;

//서로소집합 알고리즘
//Union - Find 알고리즘
public class UnionFind_Algorhydm {

    static int N;
    static int[] p;
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        N = 5;
        makeSet();
        System.out.println(Arrays.toString(p));
        System.out.println(unionSet(0,1));
        System.out.println(Arrays.toString(p));
        System.out.println(unionSet(2,1));
        System.out.println(Arrays.toString(p));
        System.out.println(unionSet(3,2));
        System.out.println(Arrays.toString(p));
        System.out.println(unionSet(4,3));
        System.out.println(Arrays.toString(p));
        
        System.out.println("==============findSet===========");
        System.out.println(findSet(4));
        System.out.println(Arrays.toString(p));
        System.out.println(findSet(3));
        System.out.println(Arrays.toString(p));
        System.out.println(findSet(2));
        System.out.println(Arrays.toString(p));
        System.out.println(findSet(1));
        System.out.println(Arrays.toString(p));
//        System.out.println(unionSet(0,1));
        
    }
    //기본적인 알고리즘에서는 void
    //응용으로 사용하기 위해서 boolean으로 활용하기도 함
    //a가 포함된 집단과, b가 포함된 집합 합치기
    static boolean unionSet(int a, int b) {
        int aRoot = findSet(a);
        int bRoot = findSet(b);
        if(aRoot == bRoot) {
            return false;
        }
//        p[b] = a; 사용불가 root끼리 합치는 개념이다.
        p[bRoot] = aRoot; 
        return true;
    }
    //a가 포함된 대표자 찾기
    static int findSet(int a) {
        if(a == p[a]) {
            return a;
        }
        p[a] = findSet(p[a]); //경로 압축;
        return p[a]; // 현재 위치의 부모값 반환
    }
    //단위 집단 만들기
    static void makeSet() {
        p = new int[N]; //부모를 관리하는 배열
        //자신의 부모노드를 자신으로 설정
        for(int i =0; i < N; i++) {
            p[i] = i;
        }
    }
}