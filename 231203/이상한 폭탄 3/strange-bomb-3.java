import java.util.*;

public class Main {
    public static int[] arr;
    public static final int MAX_NUM = 1000000;
    public static final int MAX_BOMB = 100;
    public static int numOfBomb(int num, int range){
        int[] idxArr = new int[MAX_BOMB];
        int cnt = 0;
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] == num){
                idxArr[cnt++] = i;
            }
        }
        
        int bombCnt = 1;
        int maxVal = 0;
        for(int i = 1 ; i < cnt ; i++){
            if(idxArr[i] - idxArr[i-1] > range){
                maxVal = Math.max(maxVal, bombCnt);
                bombCnt = 1;
            }
            else{
                bombCnt++;
            }
        }
        maxVal = Math.max(maxVal, bombCnt);

        return maxVal;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), K = sc.nextInt(), maxNum = 0, maxBomb = 0;
        arr = new int[N];
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = sc.nextInt();
        }

        for(int i = 0 ; i <= MAX_NUM ; i++){
            int currentVal = numOfBomb(i, K);
            
            maxBomb = Math.max(maxBomb, currentVal);
            if(currentVal == 0 && currentVal == maxBomb){
                maxNum = i;
            }
        }
        System.out.println(maxNum);
    }
}