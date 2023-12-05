// 이전 완전 탐색에서는 모든 경우에 1을 넣고 가장 가까운 사람간의 거리를 최대로 하는 알고리즘을 구현.
// 여기서는 완전 탐색보다는 논리적으로 구해보도록 하자.
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), idx = 0;
        int[] arr = new int[N];
        String str = sc.next();
        for(int i = 0 ; i < N ; i++){
            if(str.charAt(i) == '1'){
                arr[idx++] = i;
            }
        }
        
        int maxVal = Integer.MIN_VALUE;
        for(int i = 1 ; i < idx ; i++){
            int minVal = Integer.MAX_VALUE;
            for(int j = 1 ; j < idx ; j++){
                int currentVal = arr[j] - arr[j-1];
                if(i == j && currentVal > 1){
                    currentVal /= 2;
                } 
                minVal = Math.min(minVal, currentVal);
            }
            maxVal = Math.max(maxVal, minVal);
        }
        System.out.println(maxVal);
    }
}
/* 인접한 1의 쌍중에 거리가 먼 1쌍 가운데에 1을 두어서 최소 거리를 구하는 접근 그래야 최소의 최대를 구할 수 있기 때문에
import java.util.Scanner;

public class Main {
    public static final int INT_MAX = Integer.MAX_VALUE;

    public static int n;
    public static char[] seats;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        n = sc.nextInt();
        seats = sc.next().toCharArray();

        // Step1. 최적의 위치 찾기
        // 인접한 쌍들 중 가장 먼 1간의 쌍을 찾습니다.
        int maxDist = 0;
        int maxI = 0, maxJ = 0;
        for(int i = 0; i < n; i++) {
            if(seats[i] == '1') {
                for(int j = i + 1; j < n; j++)
                    if(seats[j] == '1') {
                        // 1간의 쌍을 골랐을 때
                        // 두 좌석간의 거리가 지금까지의 최적의 답 보다 더 좋다면
                        // 값을 갱신해줍니다.
                        if(j - i > maxDist) {
                            maxDist = j - i;

                            // 이때, 두 좌석의 위치를 기억합니다.
                            maxI = i;
                            maxJ = j;
                        }

                        // 인접한 쌍을 찾았으므로 빠져나옵니다.
                        break;
                    }
            }
        }

        // Step2. 최적의 위치에 1을 놓습니다.
        // 가장 먼 쌍의 위치 가운데에 놓으면 됩니다.
        seats[(maxI + maxJ) / 2] = '1';

        // Step3. 이제 인접한 쌍들 중 가장 가까운 1간의 쌍을 찾습니다.
        // 이때의 값이 답이 됩니다.
        int ans = INT_MAX;
        for(int i = 0; i < n; i++) {
            if(seats[i] == '1') {
                for(int j = i + 1; j < n; j++)
                    if(seats[j] == '1') {
                        ans = Math.min(ans, j - i);
                        
                        // 인접한 쌍을 찾았으므로 빠져나옵니다.
                        break;
                    }
            }
        }

        System.out.print(ans);
    }
}
*/
