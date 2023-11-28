import java.util.*;

public class Main {
    public static int[] arr;

    public static int exceptSum(int a, int b){
        int sum = 0;
        for(int i = 0; i < arr.length ; i++){
            if(i == a || i == b){
                continue;
            }
            sum += arr[i];
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), S = sc.nextInt(), minVal = Integer.MAX_VALUE;
        arr = new int[N];
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = sc.nextInt();
        }
        
        for(int i = 0; i < arr.length -1 ; i++){
            for(int j = i + 1 ; j < arr.length; j++){
                minVal = Math.min(minVal, Math.abs(S - exceptSum(i,j)));
            }
        }
        System.out.print(minVal);
    }
}

/* 제거할 두 원소의 위치를 일일이 잡아서 해당수를 제외 했을 때의 값이 S와 차이가 나는지 여부 판단

        // 배열의 값들의 총합을 미리 구해둡니다.
        for(int i = 0; i < n; i++)
            arraySum += arr[i];
        
        // 모든 쌍을 다 잡아봅니다.
        for(int i = 0; i < n; i++)
            for(int j = i + 1; j < n; j++) {
                // i번과 j번 수를 제외할 경우 남은 숫자들의 총합은 다음과 같습니다.
                int newSum = arraySum - arr[i] - arr[j];

                int diff = Math.abs(newSum - s);
                ans = Math.min(ans, diff);
            }

*/