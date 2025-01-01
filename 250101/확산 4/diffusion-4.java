import java.util.*;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력 처리
        int n = sc.nextInt();
        int m = sc.nextInt();
        int s = sc.nextInt();
        sc.nextLine(); // 버퍼 클리어

        char[][] grid = new char[n][m];
        for (int i = 0; i < n; i++) {
            grid[i] = sc.nextLine().toCharArray();
        }

        // 결과 계산
        char[][] result = simulate(grid, n, m, s);

        // 출력
        for (int i = 0; i < n; i++) {
            System.out.println(new String(result[i]));
        }
    }

    static char[][] simulate(char[][] grid, int n, int m, int s) {
        if (s == 1) {
            return grid; // 초기 상태
        }
        if (s % 2 == 0) {
            // 모든 칸에 폭탄이 설치된 상태
            char[][] full = new char[n][m];
            for (int i = 0; i < n; i++) {
                Arrays.fill(full[i], 'O');
            }
            return full;
        }

        // 폭발 시뮬레이션 (3초 이상)
        char[][] secondState = explode(grid, n, m);
        char[][] thirdState = explode(secondState, n, m);

        // 반복 패턴 활용
        return (s % 4 == 3) ? secondState : thirdState;
    }

    static char[][] explode(char[][] grid, int n, int m) {
        char[][] result = new char[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(result[i], 'O'); // 모든 칸에 폭탄 설치
        }

        // 폭탄 폭발
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 'O') {
                    result[i][j] = '.'; // 폭탄 자기 자신
                    for (int d = 0; d < 4; d++) {
                        int ni = i + dx[d];
                        int nj = j + dy[d];
                        if (ni >= 0 && ni < n && nj >= 0 && nj < m) {
                            result[ni][nj] = '.';
                        }
                    }
                }
            }
        }
        return result;
    }
}
