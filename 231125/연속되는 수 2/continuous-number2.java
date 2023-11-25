import java.util.*;

public class Main {
    public static int num = 1001;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[num];
        int N = sc.nextInt(), cnt = 1, maxVal = Integer.MIN_VALUE;
        for(int i = 0 ; i < N ; i++){
            arr[i] = sc.nextInt();
        }

        for(int i = 0 ; i < N ; i++){
            if(i == 0 || arr[i] != arr[i-1]){
                if(maxVal < cnt){
                    maxVal = cnt;
                }
                cnt = 1;
            }
            else{
                cnt++;
                if(i == N-1){
                    if(maxVal < cnt){
                        maxVal = cnt;
                    }
                }
            }
        }
        System.out.print(maxVal);
    }
}