import java.util.*;

public class Main {
    public static boolean[] chackArr;
    public static int[] sumArr;
    public static int[] outputArr;

    public static boolean restoration(int idx, int value){
        boolean output = false;
        // if(idx > sumArr.length){
        //     return true;
        // }

        if(chackArr[value]){
            chackArr[value] = false;
        }
        else{
            return false;
        }

        outputArr[idx] = value;
        // System.out.println("current idx : " + idx);

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

        Arrays.fill(chackArr, true);
        boolean tt = restoration(0, 3);

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