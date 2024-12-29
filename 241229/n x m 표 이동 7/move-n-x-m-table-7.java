import java.io.*;
import java.util.*;

public class Main {
    static int n, m, h, w, startX, startY, endX, endY;
    static int[][] grid;
    static boolean[][] visited;

    static int[] dx = {-1, 1, 0, 0}; // 상, 하, 좌, 우
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        startX = Integer.parseInt(st.nextToken()) - 1;
        startY = Integer.parseInt(st.nextToken()) - 1;
        endX = Integer.parseInt(st.nextToken()) - 1;
        endY = Integer.parseInt(st.nextToken()) - 1;

        System.out.println(bfs());
    }

    static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        visited = new boolean[n][m];
        queue.add(new int[]{startX, startY, 0});
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int dist = current[2];

            // 도착점에 도달한 경우
            if (x == endX && y == endY) {
                return dist;
            }

            // 4방향 탐색
            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (isValid(nx, ny) && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny, dist + 1});
                }
            }
        }

        // 이동 불가능한 경우
        return -1;
    }

    static boolean isValid(int x, int y) {
        // 직사각형이 격자 밖으로 나가는 경우
        if (x < 0 || y < 0 || x + h > n || y + w > m) {
            return false;
        }

        // 직사각형이 장애물을 포함하는지 확인
        for (int i = x; i < x + h; i++) {
            for (int j = y; j < y + w; j++) {
                if (grid[i][j] == 1) {
                    return false;
                }
            }
        }

        return true;
    }
}
