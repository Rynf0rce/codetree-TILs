import java.io.*;
import java.util.*;

// Interval 클래스 정의
class Interval implements Comparable<Interval> {
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Interval other) {
        // 시작점 기준 오름차순 정렬
        // 시작점이 같으면 끝점 기준 내림차순 정렬
        if (this.start != other.start) {
            return Integer.compare(this.start, other.start);
        }
        return Integer.compare(other.end, this.end);
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Interval> intervals = new ArrayList<>();

        // 첫 번째 줄에서 구간의 총 개수 n 읽음
        String firstLine = br.readLine();
        if (firstLine == null || firstLine.isEmpty()) {
            System.out.println(0);
            return;
        }

        int n = Integer.parseInt(firstLine); // 구간 개수

        // 입력 구간 처리
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            if (line == null || line.trim().isEmpty()) {
                // 빈 줄이면 건너뜀
                continue;
            }

            StringTokenizer st = new StringTokenizer(line);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            intervals.add(new Interval(a, b));
        }

        // 최소 구간 개수 계산
        int result = findMinimumIntervals(intervals);
        System.out.println(result);
    }

    public static int findMinimumIntervals(List<Interval> intervals) {
        // 구간 정렬: Comparable을 활용
        Collections.sort(intervals);

        int targetStart = 3, targetEnd = 220;
        int currentEnd = targetStart; // 현재 커버 가능한 범위
        int maxEnd = targetStart; // 가능한 최대 끝점
        int count = 0; // 선택한 구간의 개수
        int i = 0; // 구간 인덱스

        // 그리디로 구간 선택
        while (currentEnd < targetEnd) {
            boolean found = false;

            // 현재 커버 가능한 범위 내에서 가장 큰 끝점 찾기
            while (i < intervals.size() && intervals.get(i).start <= currentEnd) {
                maxEnd = Math.max(maxEnd, intervals.get(i).end);
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
