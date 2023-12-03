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
    
        int bombCnt = 0;
        int maxVal = 0;
        boolean triger = true;
        for(int i = 1 ; i < cnt ; i++){
            if(idxArr[i] - idxArr[i-1] <= range){
                bombCnt++;
                if(triger){
                    bombCnt++;
                    triger = false;
                }
            }
            else{
                bombCnt = 0;
                triger = true;
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
            if(currentVal == maxBomb){
                maxNum = i;
            }
        }
        if(maxBomb == 0){
            maxNum = 0;
        }
        System.out.println(maxNum);
    }
}