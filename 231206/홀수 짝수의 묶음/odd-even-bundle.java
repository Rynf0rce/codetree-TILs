import java.util.*;

public class Main {
    public static final int INPUT_RANGE = 1000;
    public static int[] arr = new int[INPUT_RANGE];
    public static int maxGroup(int evenCnt, int oddCnt, int order){
        if( (order == 1 && oddCnt == 0) || (order == 2 && evenCnt == 0 && oddCnt < 2) ){
            return 0;
        }

        if(order == 1 && (evenCnt > 0 || oddCnt != 2)){
            oddCnt--;
        }
        else if(order == 2 && evenCnt > 0) {
            evenCnt--;
        }
        else if(order == 2 && oddCnt > 1){
            oddCnt -= 2;
        }
        else{
            return 0;
        }

        if(order == 1){
            order = 2;
        }
        else{
            order = 1;
        }

        // System.out.println(evenCnt + " " + oddCnt + " " + order);
        return maxGroup(evenCnt, oddCnt, order) + 1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), oddCnt = 0, evenCnt = 0;
        for(int i = 0 ; i < N ; i++){
            arr[i] = sc.nextInt();
            if(arr[i] % 2 == 0){
                evenCnt++;
            }
            else{
                oddCnt++;
            }
        }
        // System.out.println(evenCnt + " " + oddCnt);
        System.out.print(maxGroup(evenCnt, oddCnt, 2));
    }
}