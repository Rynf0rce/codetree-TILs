import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력 처리
        int n = sc.nextInt();
        long k = sc.nextLong();
        int a1 = sc.nextInt() - 1; // 0-based index
        int a2 = sc.nextInt() - 1;
        int b1 = sc.nextInt() - 1;
        int b2 = sc.nextInt() - 1;

        // 초기 수열 생성
        int[] sequence = new int[n];
        for (int i = 0; i < n; i++) {
            sequence[i] = i + 1;
        }

        // 반복 시뮬레이션 및 패턴 탐색
        Map<String, Integer> seen = new HashMap<>();
        List<int[]> states = new ArrayList<>();
        int cycleStart = -1, cycleLength = -1;

        for (int step = 0; step < k; step++) {
            // 현재 상태를 문자열로 저장
            String currentState = Arrays.toString(sequence);
            if (seen.containsKey(currentState)) {
                cycleStart = seen.get(currentState);
                cycleLength = step - cycleStart;
                break;
            }

            seen.put(currentState, step);
            states.add(sequence.clone());

            // [A1, A2] 뒤집기
            reverse(sequence, a1, a2);
            // [B1, B2] 뒤집기
            reverse(sequence, b1, b2);
        }

        // 최종 상태 계산
        if (cycleStart != -1) { // 반복 주기가 발견된 경우
            int remainingSteps = (int) ((k - cycleStart) % cycleLength);
            sequence = states.get(cycleStart + remainingSteps);
        }

        // 출력
        for (int num : sequence) {
            System.out.println(num);
        }

        sc.close();
    }

    // 구간 뒤집기 함수
    static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
