import java.util.*;

public class Main {
    public static int MAX_INPUT = 1000;
    public static int MAX_LIMIT = 1000;
    public static int MAX_VALUE = 1000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[MAX_INPUT];
        int[] judgeArr = new int[MAX_INPUT];
        int N = sc.nextInt(), T = sc.nextInt(), cnt = 0, maxVal = Integer.MIN_VALUE;   
        for(int i = 0 ; i < N ; i++){
            int input = sc.nextInt();
            if(input > T){
                arr[i] = 1;
            }
        }

        for(int i = 0; i < N ; i++){
            if(arr[i] == 1){
                cnt++;
            }
            else{
                //ans = Math.max(ans, cnt);
                if(maxVal < cnt){
                    maxVal = cnt;
                }
                cnt = 0;
            }
        }
        System.out.print(maxVal);
    }
}