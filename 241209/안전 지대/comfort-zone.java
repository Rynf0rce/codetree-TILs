import java.util.*;

public class Main {
    public static int N, M;
    public static int[][] table;
    public static boolean[][] visited;
    public static final int[] dRow = {-1, 0, 1, 0};
    public static final int[] dCol = {0, 1, 0, -1};

    // visited 배열 초기화
    public static void clearVisited() {
        for (int i = 0; i < N; i++) {
            Arrays.fill(visited[i], false);
        }
    }

    // 좌표가 격자 범위 내인지 확인
    public static boolean inRange(int r, int c) {
        return (r >= 0 && r < N && c >= 0 && c < M);
    }

    // 해당 칸(r, c)이 방문 가능(수위 K보다 높고, 아직 방문하지 않음)한지 확인
    public static boolean canGo(int r, int c, int K) {
        if (!inRange(r, c)) return false;
        if (visited[r][c]) return false;
        if (table[r][c] <= K) return false;
        return true;
    }

    /**
     * 새로운 안전구역을 탐색하는 함수.
     * 시작점 (r, c)이 수위 K보다 높은 곳이라면,
     * DFS(또는 재귀)를 통해 연결된 모든 안전영역을 방문 처리한다.
     * 
     * @param r 현재 행
     * @param c 현재 열
     * @param K 수위
     * @return 새로운 안전구역을 발견했다면 true, 아니라면 false
     */
    public static boolean exploreSafeZone(int r, int c, int K) {
        // 시작점이 이동 불가능하다면 안전구역 아님
        if (!canGo(r, c, K)) return false;

        // 방문 처리
        visited[r][c] = true;

        // 상하좌우 탐색
        for (int i = 0; i < 4; i++) {
            int nr = r + dRow[i];
            int nc = c + dCol[i];
            exploreSafeZone(nr, nc, K);
        }
        // 여기까지 오면 (r, c)를 시작점으로 하는 하나의 안전구역을 모두 탐색 완료
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // N, M 입력 후 테이블 및 visited 배열 초기화
        N = sc.nextInt();
        M = sc.nextInt();
        table = new int[N][M];
        visited = new boolean[N][M];

        int inputMax = Integer.MIN_VALUE;

        // 지형 정보 입력 및 최대 높이 파악
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                table[i][j] = sc.nextInt();
                inputMax = Math.max(inputMax, table[i][j]);
            }
        }

        /**
         * 모든 가능한 수위(1부터 최대 높이까지)에 대해
         * 안전구역 개수를 구하고, 그 중 최대값을 갖는 수위와
         * 해당 시 안전구역 개수를 기록한다.
         * 
         * 수위가 0일 때 검사할 수도 있지만, 문제 상황에 따라
         * "물이 아예 없는 상황"도 필요하다면 0부터 시작할 수도 있음.
         */
        int maxSafeZones = Integer.MIN_VALUE;
        int bestLevel = 0;

        for (int level = 1; level <= inputMax; level++) {
            clearVisited();
            int count = 0;
            // 현재 수위에서의 안전구역 개수를 구한다
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < M; c++) {
                    if (exploreSafeZone(r, c, level)) {
                        count++;
                    }
                }
            }

            // 최대 안전구역 개수 갱신
            if (count > maxSafeZones) {
                maxSafeZones = count;
                bestLevel = level;
            }
        }

        // 최대 안전구역 개수를 형성하는 수위와 해당 개수 출력
        System.out.println(bestLevel + " " + maxSafeZones);
    }
}
