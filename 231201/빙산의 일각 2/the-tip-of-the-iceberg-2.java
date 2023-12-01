import java.util.*;

public class Main {
    public static final int MAX_LEVEL = 1000;
    public static int[] arr;
    public static int chankIceBerg(int level){
        int[] tempArr = arr.clone();
        for(int i = 0 ; i < tempArr.length ; i++){
            tempArr[i] -= level;
        }

        boolean triger = true;
        int cnt = 0;
        for(int i = 0 ; i < tempArr.length ; i++){
            if(tempArr[i] > 0  && triger){
                cnt++;
                triger = false;
            }

            if(tempArr[i] <= 0 ){
                triger = true;
            }
        }
        return cnt;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        arr = new int[N + 2];
        for(int i = 1 ; i < arr.length - 1 ; i++){
            arr[i] = sc.nextInt();
        }

        int maxVal = Integer.MIN_VALUE;
        for(int i = 0 ; i < MAX_LEVEL ; i++){
            maxVal = Math.max(maxVal, chankIceBerg(i));
        }
        System.out.println(maxVal);
    }
}