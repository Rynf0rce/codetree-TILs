import java.util.*;

public class Main {
    public static final int MAX_N = 1000 * 1000 * 10;
    public static final int MAX_M = 1000 * 1000 * 10;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] A_Arr = new double[MAX_N], B_Arr = new double[MAX_M];
        int N = sc.nextInt(), M = sc.nextInt(), A_idx = 1, B_idx = 1;
        for(int i = 0 ; i < N ; i++){
            int velocity = sc.nextInt();
            int time = sc.nextInt();
            for(int j = 0 ; j < time ; j++){
                A_Arr[A_idx] = A_Arr[A_idx - 1] + velocity;
                A_idx++;
            }
        }

        for(int i = 0 ; i < M ; i++){
            int velocity = sc.nextInt();
            int time = sc.nextInt();
            for(int j = 0 ; j < time ; j++){
                B_Arr[B_idx] = B_Arr[B_idx - 1] + velocity;
                B_idx++;
            }
        }

        for(int i = 0 ; i < A_idx ; i++){
            //System.out.println(A_Arr[i] + " " + B_Arr[i] + " " + (A_Arr[i] - B_Arr[i]));
        }

        int scope = Math.min(A_idx, B_idx);
        double preVal = 0, currentVal = 0, cnt = 0;
        for(int i = 1 ; i < scope ; i++){
            currentVal = A_Arr[i] - B_Arr[i];
            if(i == 1){
                preVal = currentVal;
            }
            else{
                if(currentVal * preVal < 0){
                    cnt++;
                }
                else if(currentVal * preVal == 0){
                    continue;
                }
                preVal = currentVal;
            }
            //System.out.println("currentVal" + " " + currentVal + " " + "preVal" + preVal);
        }
        System.out.print((int)cnt);
    }
}