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