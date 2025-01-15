import java.util.Scanner;

public class Main {
    // 시계 방향으로 8방향을 순회 (달팽이 형태)
    //  0: down-left, 1: down, 2: down-right, 3: right,
    //  4: up-right,  5: up,   6: up-left,    7: left
    static int[][] DIRS = {
        {1, -1}, {1, 0}, {1, 1}, {0, 1},
        {-1, 1}, {-1, 0}, {-1, -1}, {0, -1}
    };
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();
        
        // 총 행/열 크기 = 2N - 1
        int size = 2 * N - 1;
        
        // 다이아몬드 영역만 채우기 위해, 전체를 공백으로 초기화
        char[][] grid = new char[size][size];
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                grid[r][c] = ' ';
            }
        }
        
        // 이미 문자를 채운 위치 체크
        boolean[][] used = new boolean[size][size];
        
        // 유효(마름모) 칸의 총 개수 계산
        int totalCells = 0;
        for (int r = 0; r < size; r++) {
            if (r < N) {
                // 윗부분
                totalCells += (2 * (r + 1) - 1);
            } else {
                // 아랫부분
                int rev = (size - 1) - r;
                totalCells += (2 * (rev + 1) - 1);
            }
        }

        // 시작 지점: 맨 위 꼭짓점 (0행, 가운데 열)
        int r = 0, c = N - 1;
        // 시작 방향 (down-left)
        int dIdx = 0;  
        
        // 알파벳 순환 용도
        char letter = 'A';

        for (int fillCount = 1; fillCount <= totalCells; fillCount++) {
            // 현재 위치에 문자 채워넣기
            grid[r][c] = letter;
            used[r][c] = true;
            
            // 다음 문자로 갱신 (Z 다음엔 A)
            letter = (letter == 'Z') ? 'A' : (char)(letter + 1);

            // 다음 위치 탐색
            int nr = r + DIRS[dIdx][0];
            int nc = c + DIRS[dIdx][1];
            
            // 만약 다음 위치가 "범위 밖"이거나 "이미 사용된 칸"이거나 "마름모가 아닌 칸"이면
            // -> 방향을 시계방향으로 바꾸면서 가능한 곳을 찾는다.
            int tries = 0;
            while (!isValidDiamond(nr, nc, N) || used[nr][nc]) {
                dIdx = (dIdx + 1) % 8;  // 방향 전환
                nr = r + DIRS[dIdx][0];
                nc = c + DIRS[dIdx][1];
                tries++;
                if (tries > 8) break; // 8방 전부 막히면 중단
            }
            
            // 새 위치로 이동
            r = nr;
            c = nc;
        }
        
        // 다이아몬드 형태로 출력
        for (int i = 0; i < size; i++) {
            int left, right;
            int leadSpaces;
            
            if (i < N) {
                // 윗부분
                left = (N - 1) - i;
                right = (N - 1) + i;
                leadSpaces = 2 * ((N - 1) - i);
            } else {
                // 아랫부분
                int rev = (size - 1) - i;
                left = (N - 1) - rev;
                right = (N - 1) + rev;
                leadSpaces = 2 * (i - (N - 1));
            }
            
            // 선행 공백 출력 (Java 11 미만에서는 " ".repeat(leadSpaces)를 쓸 수 없으므로 아래 함수 이용)
            System.out.print(repeatSpace(leadSpaces));
            
            // 해당 행의 다이아몬드 영역을 하나씩 출력
            boolean firstChar = true;
            for (int col = left; col <= right; col++) {
                if (!firstChar) {
                    System.out.print(" ");
                }
                firstChar = false;
                System.out.print(grid[i][col]);
            }
            System.out.println();
        }
    }

    // (r, c)가 다이아몬드 내부인지 체크
    static boolean isValidDiamond(int r, int c, int N) {
        int size = 2 * N - 1;
        if (r < 0 || r >= size || c < 0 || c >= size) return false;
        
        // 위쪽 N줄
        if (r < N) {
            int left = (N - 1) - r;
            int right = (N - 1) + r;
            return (left <= c && c <= right);
        }
        // 아래쪽 N-1줄
        else {
            int rev = (size - 1) - r;
            int left = (N - 1) - rev;
            int right = (N - 1) + rev;
            return (left <= c && c <= right);
        }
    }

    // Java 8 이하에서도 공백 반복을 쉽게 쓰기 위한 함수
    private static String repeatSpace(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(' ');
        }
        return sb.toString();
    }
}
