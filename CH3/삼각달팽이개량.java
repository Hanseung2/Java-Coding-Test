public class Solution {
    private static final int[] dx = {0, 1, -1};  //아래, 오른쪽, 왼쪽 위 대각선 방향의 dx, dy 좌표를 배열로 저장하여 코드를 간결하게 만들 수 있다.
    private static final int[] dy = {1, 0, -1};

    public int[] solution(int n) {
        int[][] triangle = new int[n][n];
        int v = 1;
        int x = 0;
        int y = 0;
        int d = 0;

        while (true) {
            triangle[y][x] = v++;  //하나씩 숫자를 넣어주고
            int nx = x + dx[d];  //변수 nx에 변화량을 더해 방향을 이동한다. 
            int ny = y + dy[d];
            if (nx == n || ny == n || nx == -1 || ny == -1 || triangle[ny][nx] != 0) {  //더이상 갈 곳이 없을 때를 파악하는 if문
                d = (d + 1) % 3; //방향 초기화 해주는 mod
                nx = x + dx[d];
                ny = y + dy[d];
                if (nx == n || ny == n || nx == -1 || ny == -1 || triangle[ny][nx] != 0) break;
            }
            x = nx;
            y = ny;
        }

        int[] result = new int[v - 1];
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                result[index++] = triangle[i][j];
            }
        }

        return result;
    }
}
