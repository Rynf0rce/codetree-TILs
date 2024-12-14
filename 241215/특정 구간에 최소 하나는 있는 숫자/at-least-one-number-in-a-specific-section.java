import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력 받기
        int n = sc.nextInt();
        int[][] data = new int[n][2];
        for (int i = 0; i < n; i++) {
            data[i][0] = sc.nextInt(); // 위치
            data[i][1] = sc.nextInt(); // 숫자
        }

        // 최소 구간 크기 계산
        int result = findMinimumInterval(n, data);
        System.out.println(result);
    }

    public static int findMinimumInterval(int n, int[][] data) {
        // 데이터를 위치 기준으로 정렬
        Arrays.sort(data, Comparator.comparingInt(a -> a[0]));

        // 고유 숫자 집합
        Set<Integer> uniqueNumbers = new HashSet<>();
        for (int[] pair : data) {
            uniqueNumbers.add(pair[1]);
        }
        int requiredCount = uniqueNumbers.size();

        // 슬라이딩 윈도우 변수 초기화
        Map<Integer, Integer> currentCount = new HashMap<>();
        int left = 0;
        int uniqueFound = 0;
        int minLength = Integer.MAX_VALUE;

        // 슬라이딩 윈도우 실행
        for (int right = 0; right < n; right++) {
            int position = data[right][0];
            int number = data[right][1];

            // 숫자를 윈도우에 추가
            currentCount.put(number, currentCount.getOrDefault(number, 0) + 1);
            if (currentCount.get(number) == 1) {
                uniqueFound++;
            }

            // 모든 고유 숫자가 포함되었는지 확인
            while (uniqueFound == requiredCount) {
                int leftPosition = data[left][0];
                int leftNumber = data[left][1];

                // 최소 구간 길이 업데이트
                minLength = Math.min(minLength, position - leftPosition);

                // 윈도우에서 왼쪽 숫자 제거
                currentCount.put(leftNumber, currentCount.get(leftNumber) - 1);
                if (currentCount.get(leftNumber) == 0) {
                    uniqueFound--;
                }
                left++;
            }
        }

        return minLength;
    }
}
