import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력 받기
        int n = sc.nextInt();
        int[][] intervals = new int[n][2];
        for (int i = 0; i < n; i++) {
            intervals[i][0] = sc.nextInt(); // 시작점
            intervals[i][1] = sc.nextInt(); // 끝점
        }

        // 최소 구간 개수 계산
        int result = findMinimumIntervals(intervals);
        System.out.println(result);
    }

    public static int findMinimumIntervals(int[][] intervals) {
        // 구간 정렬: 시작점 기준 오름차순, 끝점 기준 내림차순
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            return b[1] - a[1];
        });

        int targetStart = 3, targetEnd = 220;
        int currentEnd = targetStart; // 현재 커버 가능한 범위
        int maxEnd = targetStart; // 가능한 최대 끝점
        int count = 0; // 선택한 구간의 개수
        int i = 0; // 구간 인덱스

        // 그리디로 구간 선택
        while (currentEnd < targetEnd) {
            boolean found = false;

            // 현재 커버 가능한 범위 내에서 가장 큰 끝점 찾기
            while (i < intervals.length && intervals[i][0] <= currentEnd) {
                maxEnd = Math.max(maxEnd, intervals[i][1]);
                found = true;
                i++;
            }

            if (!found) {
                // 더 이상 확장할 수 없는 경우
                return 0;
            }

            // 범위를 확장하고 구간 선택
            currentEnd = maxEnd;
            count++;
        }

        return count;
    }
}
