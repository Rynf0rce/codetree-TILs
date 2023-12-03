import java.util.*;

public class Main {
    public static boolean[] chackArr;
    public static int[] sumArr;
    public static int[] outputArr;

    public static boolean restoration(int idx, int value){
        boolean output = false;

        if(value > 0 && value < chackArr.length && chackArr[value]){
            chackArr[value] = false;
        }
        else{
            return false;
        }

        outputArr[idx] = value;

        if(idx >= sumArr.length){
            return true;
        }
        return restoration(idx + 1, sumArr[idx] - value);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        chackArr = new boolean[N+1];
        outputArr = new int[N];
        sumArr = new int[N-1];
        for(int i = 0 ; i < sumArr.length ; i++){
            sumArr[i] = sc.nextInt();
        }

        for(int i = 1 ; i <= N ; i++){
            Arrays.fill(chackArr, true);
            Arrays.fill(outputArr, 0);
            if(restoration(0, i)){
                break;
            }
        }

        for(int i = 0 ; i < outputArr.length ; i++){
            System.out.print(outputArr[i] + " ");
        }
    }
}