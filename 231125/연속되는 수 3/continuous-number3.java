import java.util.*;

public class Main {
    public static final int INPUT_MAX = 1000;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[INPUT_MAX];
        for(int i = 0 ; i < N ; i++){
            arr[i] = sc.nextInt();
        }
        
        int cnt = 0, maxVal = Integer.MIN_VALUE;
        for(int i = 0 ; i < N ; i++){
            if(i == 0 || arr[i] * arr[i-1] < 0){
                if(maxVal < cnt)
                {
                    maxVal = cnt;
                }
                cnt = 1;
            }
            else{
                cnt++;
            }
            if(i == N-1 && maxVal < cnt){
                maxVal = cnt;
            }
        }
        System.out.print(maxVal);
        
    }
}