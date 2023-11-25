import java.util.*;

public class Main {
    public static int MAX_INPUT = 1000;
    public static int MAX_LIMIT = 1000;
    public static int MAX_VALUE = 1000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[MAX_INPUT];
        int N = sc.nextInt(), T = sc.nextInt(), maxValue = 0, cnt = 0;
        for(int i = 0 ; i < N ; i++){
            arr[i] = sc.nextInt();
        }

        for(int i = 0 ; i < N ; i++){
            if(arr[i] > T){
                if(cnt == 0){
                    cnt = 1;
                }
                else{
                    if(arr[i-1] < arr[i]){
                        cnt++;
                    }
                    else{
                        if(maxValue < cnt){
                            maxValue = cnt + 1;
                        }
                        cnt = 1;
                    }
                }

            }
            else{
                cnt = 0;
            }

            if(i == N-1 && maxValue < cnt){
                maxValue = cnt;
            }
        }
        System.out.print(maxValue);
    }
}