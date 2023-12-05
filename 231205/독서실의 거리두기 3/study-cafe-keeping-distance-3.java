// 이전 완전 탐색에서는 모든 경우에 1을 넣고 가장 가까운 사람간의 거리를 최대로 하는 알고리즘을 구현.
// 여기서는 완전 탐색보다는 논리적으로 구해보도록 하자.
import java.util.*;

public class Main {
    public static final int MAX_SEAT = 1000;
    public static int[] arr = new int[MAX_SEAT];
    public static int[] gapArr = new int[MAX_SEAT];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String str = sc.next();
        for(int i = 0 ; i < N ; i++){
            arr[i] = str.charAt(i) - '0';
        }

        int cnt = 0, idx = 0;
        boolean triger = true;
        for(int i = 0 ; i < N ; i++){
            cnt++;
            if(triger && arr[i] == 1){
                triger = false;
            }
            else if(!triger && arr[i] == 1){
                gapArr[idx++] = cnt;
                cnt = 1;
            }
        }

        int minVal = Integer.MAX_VALUE;
        int output = Integer.MIN_VALUE;

        for(int i = 0 ; i < idx ; i++){
            int currentVal = gapArr[i] / 2;
            if(gapArr[i] > 2 && gapArr[i] % 2 == 0){
                currentVal = (gapArr[i] - 1) / 2;
            }
            minVal = Math.min(minVal, currentVal);
            output = Math.max(output, minVal);
        }
        System.out.println(output);     
    }
}