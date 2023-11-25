import java.util.*;

public class Main {
    public static final int INPUT_MAX = 1000;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[INPUT_MAX];
        int N = sc.nextInt(), saveVal = 0, cnt = 0, maxVal = 0;
        for(int i = 0 ; i < N ; i++){
            arr[i] = sc.nextInt();
        }
        for(int i = 0 ; i < N ; i++){
            if(i == 0){
                saveVal = arr[i];
                cnt = 1;
            }
            else{
                if(saveVal < arr[i]){
                    saveVal = arr[i];
                    cnt++;
                }
                else{
                    if(cnt > maxVal){
                        maxVal = cnt;
                    }
                    saveVal = arr[i];
                    cnt = 1;
                }
            }
        }
        System.out.print(maxVal);
    }
}