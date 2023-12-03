// 답을 직접 구하기가 어려운 경우에는 답을 일일히 정해놓고 완전 탐색으로 확인 하는 것도 가능.
import java.util.*;

public class Main {
    public static final int MAX_RANGE = 100;
    public static int[] arr;
    public static boolean isPossible(int maxVal, int range){
        int[] idxArr = new int[MAX_RANGE];
        int idx = 0;
        for(int i = 0; i < arr.length ; i++){
            if(arr[i] <= maxVal){
                idxArr[idx++] = i;
            }
        }
        for(int i = 1 ; i < idx ; i++){
            if(idxArr[i] - idxArr[i-1] > range){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        arr = new int[n];
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = sc.nextInt();
        }
        for(int i = Math.max(arr[0],arr[arr.length - 1]) ; i <= MAX_RANGE ; i++){
            if(isPossible(i, k)){
                System.out.print(i);
                break;
            }
        }
    }
}