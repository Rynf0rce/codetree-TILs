import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력 처리
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // 정렬
        Arrays.sort(arr);

        // 투 포인터 초기화
        int left = 0;
        int right = n - 1;
        int closestSum = Integer.MAX_VALUE;
        int resultA = 0, resultB = 0;

        // 투 포인터 탐색
        while (left < right) {
            int sum = arr[left] + arr[right];

            // 0에 더 가까운 합인지 확인
            if (Math.abs(sum) < Math.abs(closestSum) || 
                (Math.abs(sum) == Math.abs(closestSum) && arr[left] < resultA)) {
                closestSum = sum;
                resultA = arr[left];
                resultB = arr[right];
            }

            // 포인터 이동
            if (sum < 0) {
                left++; // 합이 작으면 왼쪽 포인터 이동
            } else {
                right--; // 합이 크면 오른쪽 포인터 이동
            }
        }

        // 결과 출력
        System.out.println(resultA + " " + resultB);

        sc.close();
    }
}
