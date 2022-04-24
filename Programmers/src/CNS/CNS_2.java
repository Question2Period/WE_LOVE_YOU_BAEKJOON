package CNS;

public class CNS_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

2.
# 3 1 2
# 1 2 1
# 1 3 1
# 2 3 2
# => 1
import sys
si = sys.stdin.readline
n, A, B = map(int, si().split())
graph = [[0 for _ in range(n + 1)] for __ in range(n + 1)]
# for i in range(n * (n - 1) // 2):
#     x, y, c = map(int, si().split())
#     graph[x][y] = c
#     graph[y][x] = c
visit = [0 for _ in range(n + 1)]
path = [A]
visit[A] = 1
ans = 1e9
def get_dist(path):  # A가 이동한 거리 + B가 이동한 거리
    ret = 0
    for i in range(len(path) - 1):
        if path[i + 1] == B:  # i번째 방문한 곳이 A의 마지막 방문 지점
            continue
        ret += graph[path[i]][path[i + 1]]  # i번째 방문한 곳에서 i+1번째 방문한 곳까지의 거리 누적
    return ret
def Backtracking(idx):  # 이제 idx 번째 원소 선택할 차례
    global ans
    if idx == n:
        print(path)
        ans = min(ans, get_dist(path))
        return
    for i in range(1, n + 1):
        if visit[i]:
            continue
        path.append(i)
        visit[i] = 1
        Backtracking(idx + 1)
        path.pop()
        visit[i] = 0
Backtracking(1)
print(ans)
3.
# 6 6
# 122343
# 223344
# 133354
# 333666
# 336666
# 166666
# => 3 2
import sys
si = sys.stdin.readline
n, m = map(int, si().split())
a = []
for _ in range(n):
    a.append(list(map(int, list(si().strip()))))
def solve(a, n, m):
    dy = [[0 for _ in range(m)] for __ in range(n)]
    maxSize, maxCnt = 0, 0
    for i in range(n):
        for j in range(m):
            if a[i][j] == 0:
                continue
            upper, left, upperLeft = 0, 0, 0
            if i > 0: upper = dy[i - 1][j]
            if j > 0: left = dy[i][j - 1]
            if i > 0 and j > 0: upperLeft = dy[i - 1][j - 1]
            dy[i][j] = min([upper, left, upperLeft]) + 1
            if maxSize < dy[i][j]:
                maxSize, maxCnt = dy[i][j], 0
            if maxSize == dy[i][j]:
                maxCnt += 1
    if maxSize == 3:
        maxCnt += 0
    return maxSize, maxCnt
            
b = [[0 for _ in range(m)] for __ in range(n)]
ansSize, ansCnt = 0, 0
for target_num in range(1, 10):
    # map 재구성
    for i in range(n):
        for j in range(m):
            if a[i][j] == target_num:
                b[i][j] = 1
            else:
                b[i][j] = 0
    # 오른쪽으로 밀기
    newN, newM = n, m + n - 1
    c = [[0 for _ in range(newM)] for __ in range(newN)]
    for i in range(n):
        for j in range(m):
            # 원래 배열의 (i, j)는 새로운 배열에서 (i, j + i)
            c[i][j + i] = b[i][j]
    maxSize, maxCnt = solve(c, newN, newM)
    if ansSize < maxSize:
        ansSize, ansCnt = maxSize, 0
    if ansSize == maxSize:
        ansCnt += maxCnt
    
    # 왼쪽으로 밀기
    c = [[0 for _ in range(newM)] for __ in range(newN)]
    for i in range(n):
        for j in range(m):
            # 원래 배열의 (i, j)는 새로운 배열에서 (i, j + (m - 1) - i)
            c[i][j + (m - 1) - i] = b[i][j]
    maxSize, maxCnt = solve(c, newN, newM)
    if ansSize < maxSize:
        ansSize, ansCnt = maxSize, 0
    if ansSize == maxSize:
        ansCnt += maxCnt
    # 아래쪽으로 밀기
    newN, newM = n + m - 1, m
    c = [[0 for _ in range(newM)] for __ in range(newN)]
    for i in range(n):
        for j in range(m):
            # 원래 배열의 (i, j)는 새로운 배열에서 (i + j, j)
            c[i + j][j] = b[i][j]
    maxSize, maxCnt = solve(c, newN, newM)
    if ansSize < maxSize:
        ansSize, ansCnt = maxSize, 0
    if ansSize == maxSize:
        ansCnt += maxCnt
    # 위쪽으로 밀기
    newN, newM = n + m - 1, m
    c = [[0 for _ in range(newM)] for __ in range(newN)]
    for i in range(n):
        for j in range(m):
            # 원래 배열의 (i, j)는 새로운 배열에서 (i + (m - 1) - j, j)
            c[i + m - 1 - j][j] = b[i][j]
    maxSize, maxCnt = solve(c, newN, newM)
    if ansSize < maxSize:
        ansSize, ansCnt = maxSize, 0
    if ansSize == maxSize:
        ansCnt += maxCnt
print(ansSize, ansCnt)
